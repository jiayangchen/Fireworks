var app = angular.module('fireworks', []);
app.controller('FireworksIndexController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {
    $scope.page = 0;
    $scope.blogTitlePage = 0;

    $scope.introduction = "从来不求时间为我搁浅...";
    $scope.recentBlog = [
        '每个人都有一个死角， 自己走不出来，别人也闯不进去。',
        '我把最深沉的秘密放在那里。',
        '你不懂我，我不怪你。'
    ];
    $scope.tagList = ['日志','Java','Android','跨年','数据库'];
    // $scope.titleList = [
    //     '每个人都有一个死角， 自己走不出来，别人也闯不进去。',
    //     '我把最深沉的秘密放在那里。',
    //     '你不懂我，我不怪你。',
    //     '《分布式服务架构：原理、设计与实战》全',
    //     '保障线上服务健康、可靠的最佳方案，是一本架构级、实战型的重',
    //     '然后提出了保证分布式服务系统架构一致性的方案和模式',
    //     '最后给出了一个简要的非功能质量的技术评审提纲。实践上，首先提供',
    //     '《分布式服务架构：原理、设计与实战》以分布式服务',
    //     '架构的设计与实现为主线，由浅入深地介绍了分布式服务架构的',
    //     '方方面面，主要包括理论和实践两部分。理论上，首',
    //     '先介绍了服务架构的背景，以及从服务化架构到微服务架构的演化'
    // ];

    $scope.initActivityPage = function (page) {
        var activityList = [];
        $http.get('/getActivitiesByPage', {
            params: {
                page: page
            }
        }).then(function (response) {
            activityList = response.data;
            if(activityList.length == 0) {
                $scope.activityList = activityList;
                $scope.pageWarning = '已经到顶底啦 :)';
                $("#warnModal").modal('show');
                $scope.page = $scope.page - 3;
                $scope.initActivityPage($scope.page);
            } else {
                for(var i=0; i<activityList.length; i++) {
                    var activity = activityList[i];
                    var time = activity.createTime;
                    activity.createTime = $scope.transferDate(time);
                }
                $scope.activityList = activityList;
            }

        })
    };

    $scope.transferDate = function (time) {
        var dateTime = new Date(time);
        return dateTime.getFullYear() + '-' + $scope.formatDateItem(dateTime.getMonth()) + '-' + $scope.formatDateItem(dateTime.getDay());
    };

    $scope.preActivity = function () {
        $scope.page = $scope.page - 3;
        if($scope.page < 0) {
            $scope.pageWarning = '已经到顶啦 :)';
            $("#warnModal").modal('show');
            $scope.page = $scope.page + 3;
            $scope.initActivityPage($scope.page);
        } else {
            $scope.initActivityPage($scope.page);
        }
    };

    $scope.nextActivity = function () {
        $scope.page = $scope.page + 3;
        $scope.initActivityPage($scope.page);
    };

    $scope.formatDateItem = function (item) {
        if(item < 10) {
            return '0' + item.toString();
        }
        return item.toString();
    };

    $scope.listBlogTitle = function () {
        $http.get('/listBlogTitle', {
            params: {
                page: $scope.blogTitlePage
            }
        }).then(function (response) {
            $scope.titleList = response.data;
        })
    };

    $scope.initActivityPage($scope.page);
    $scope.listBlogTitle($scope.blogTitlePage);
}]);
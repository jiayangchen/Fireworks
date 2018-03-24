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

    $scope.preBlogList = function () {
        $scope.blogTitlePage = $scope.blogTitlePage - 11;
        if($scope.blogTitlePage < 0) {
            $scope.pageWarning = '已经到顶啦 :)';
            $("#warnModal").modal('show');
            $scope.blogTitlePage = $scope.blogTitlePage + 11;
            $scope.listBlogTitle($scope.blogTitlePage);
        } else {
            $scope.listBlogTitle($scope.blogTitlePage);
        }
    };

    $scope.nextBlogList = function () {
        $scope.blogTitlePage = $scope.blogTitlePage + 11;
        $scope.listBlogTitle($scope.blogTitlePage);
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

    $scope.listBlogTitle = function (page) {
        $http.get('/listBlogTitle', {
            params: {
                page: page
            }
        }).then(function (response) {
            var result = response.data;
            $scope.titleList = result.blogList;
            $scope.dateList = result.dateList;

            if($scope.titleList.length == 0) {
                $scope.pageWarning = '已经到顶底啦 :)';
                $("#warnModal").modal('show');
                $scope.blogTitlePage = $scope.blogTitlePage - 11;
                $scope.listBlogTitle($scope.blogTitlePage);
            }
        })
    };


    $scope.initActivityPage($scope.page);
    $scope.listBlogTitle($scope.blogTitlePage);
}]);
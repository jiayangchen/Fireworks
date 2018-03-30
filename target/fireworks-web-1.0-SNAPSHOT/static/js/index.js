var app = angular.module('fireworks', []);
app.controller('FireworksIndexController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {
    //分页查询的起始页数
    $scope.page = 0;
    $scope.blogTitlePage = 0;
    //首页最多显示条目，默认二者都是10，全局配置三人组
    $scope.splitPage = 10;
    $scope.activitySplitPage = 10;
    $scope.introduction = "从来不求时间为我搁浅...";

    $scope.isDateListChosen = false;
    $scope.dateChosen = null;

    //只第一次加载最近更新的博文
    $scope.isRecentBlogLoaded = false;

    $scope.tagList = ['日志','Java','Android','跨年','数据库'];
    $scope.totalPage = 0;
    $scope.currentPage = 1;

    $scope.initActivityPage = function (page, capacity) {
        var activityList = [];
        $http.get('/getActivitiesByPage', {
            params: {
                page: page,
                capacity: capacity
            }
        }).then(function (response) {
            activityList = response.data;
            if(activityList.length == 0) {
                $scope.activityList = activityList;
                $scope.pageWarning = '已经到顶底啦 :)';
                $("#warnModal").modal('show');
                $scope.page = $scope.page - $scope.activitySplitPage;
                $scope.initActivityPage($scope.page, $scope.activitySplitPage);
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

    // $scope.filterBlogByDate = function (date) {
    //     $scope.dateChosen = date;
    //     $scope.isDateListChosen = true;
    //     $http.get('/listBlogTitleByDate', {
    //         params: {
    //             month: date,
    //             page: 0
    //         }
    //     }).then(function (response) {
    //         $scope.titleList = response.data.blogList;
    //     })
    // };

    $scope.transferDate = function (time) {
        var dateTime = new Date(time);
        return dateTime.getFullYear() + '-' + $scope.formatDateItem(dateTime.getMonth()) + '-' + $scope.formatDateItem(dateTime.getDay());
    };

    $scope.preBlogList = function () {
        $scope.blogTitlePage = $scope.blogTitlePage - $scope.splitPage;
        if($scope.blogTitlePage < 0) {
            $scope.pageWarning = '已经到顶啦 :)';
            $("#warnModal").modal('show');
            $scope.blogTitlePage = $scope.blogTitlePage + $scope.splitPage;
            $scope.listBlogTitle($scope.blogTitlePage, $scope.splitPage);
        } else {
            $scope.currentPage = $scope.currentPage - 1;
            $scope.listBlogTitle($scope.blogTitlePage, $scope.splitPage);
        }
    };

    $scope.nextBlogList = function () {
        $scope.currentPage = $scope.currentPage + 1;
        $scope.blogTitlePage = $scope.blogTitlePage + $scope.splitPage;
        $scope.listBlogTitle($scope.blogTitlePage, $scope.splitPage);
    };

    $scope.preActivity = function () {
        $scope.page = $scope.page - $scope.activitySplitPage;
        if($scope.page < 0) {
            $scope.pageWarning = '已经到顶啦 :)';
            $("#warnModal").modal('show');
            $scope.page = $scope.page + $scope.activitySplitPage;
            $scope.initActivityPage($scope.page, $scope.activitySplitPage);
        } else {
            $scope.initActivityPage($scope.page, $scope.activitySplitPage);
        }
    };

    $scope.nextActivity = function () {
        $scope.page = $scope.page + $scope.activitySplitPage;
        $scope.initActivityPage($scope.page, $scope.activitySplitPage);
    };

    $scope.formatDateItem = function (item) {
        if(item < 10) {
            return '0' + item.toString();
        }
        return item.toString();
    };

    $scope.listDate = function () {
        $http.get('/listDate')
            .then(function (response) {
                $scope.dateList = response.data;
            })
    };

    $scope.listBlogTitle = function (page, capacity) {
        $http.get('/listBlogTitle', {
            params: {
                page: page,
                capacity: capacity
            }
        }).then(function (response) {
            var result = response.data;
            $scope.titleList = result.blogList;

            if(!$scope.isRecentBlogLoaded) {
                var recentBlogList = [];
                for(var i=0; i<3; i++) {
                    recentBlogList.push($scope.titleList[i]);
                }
                $scope.recentBlog = recentBlogList;
                $scope.isRecentBlogLoaded = true;
            }

            if($scope.titleList.length == 0) {
                $scope.currentPage = $scope.currentPage - 1;
                $scope.pageWarning = '已经到底啦 :)';
                $("#warnModal").modal('show');
                $scope.blogTitlePage = $scope.blogTitlePage - $scope.splitPage;
                $scope.listBlogTitle($scope.blogTitlePage, $scope.splitPage);
            }

        })
    };

    $scope.initConfiguration = function () {
        $http.get('/getConfiguration').then(function (response) {
            $scope.splitPage = response.data.indexMaxBlogShownNumber;
            $scope.activitySplitPage = response.data.indexMaxActivityShownNumber;
            $scope.introduction = response.data.personalSignature;
            $scope.getTotalPageNum($scope.splitPage);
            $scope.initActivityPage($scope.page, $scope.activitySplitPage);
            $scope.listBlogTitle($scope.blogTitlePage, $scope.splitPage);
        })
    };

    $scope.getTotalPageNum = function (capacity) {
        $http.get('/findTotalPageNumber', {
            params: {
                capacity: capacity
            }
        }).then(function (response) {
                $scope.totalPage = response.data;
            })
    };

    $scope.initConfiguration();
    //$scope.getTotalPageNum();
    // $scope.initActivityPage($scope.page, $scope.activitySplitPage);
    // $scope.listBlogTitle($scope.blogTitlePage, $scope.splitPage);
    $scope.listDate();
}]);
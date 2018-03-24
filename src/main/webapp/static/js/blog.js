var app = angular.module('fireworks', []);
app.controller('FireworksBlogController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {

    $scope.pathname = window.location.pathname;
    $scope.blogFileName = $scope.pathname.split("/")[2];
    $scope.currentBlog = null;

    $scope.favourite = function () {
        $http.post('/favouriteBlog', $scope.currentBlog)
            .then(function (response) {
                if(response.data.status == 200) {
                    $scope.getBlogMetaData();
                } else {
                    alert('点赞失败');
                }
            })
    };

    $scope.getBlogMetaData = function () {
        $http.get('/findBlogByName', {
            params: {
                blogName: $scope.blogFileName
            }
        }).then(function (response) {
            $scope.currentBlog = response.data;
            $scope.publishDate = $scope.transferDate($scope.currentBlog.createTime);
            $scope.initBlog();
        })
    };

    $scope.transferDate = function (time) {
        var dateTime = new Date(time);
        var year = dateTime.getFullYear();
        var month = $scope.formatDateItem(dateTime.getMonth() + 1);
        var day = $scope.formatDateItem(dateTime.getDate());
        return year + '-' + month + '-' + day;
    };

    $scope.formatDateItem = function (item) {
        if(item < 10) {
            return '0' + item.toString();
        }
        return item.toString();
    };

    $scope.initBlog = function () {
        $http.get('/assets/md/' + $scope.blogFileName)
            .then(function (res) {
                if(res.status == 200) {
                    markdown2Html(res.data);
                }
            })
    };

    function markdown2Html(data) {
        var parser = new HyperDown;
        var html = parser.makeHtml(data);
        document.getElementById("blog").innerHTML = html;
    }

    $scope.getBlogMetaData();
}]);
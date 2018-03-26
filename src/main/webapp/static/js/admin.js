var app = angular.module('fireworks', []);
app.controller('FireworksAdminController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {

    $scope.loginUsername = null;
    $scope.loginPassword = null;
    $scope.activityInfo = null;

    $scope.addActivity = function () {
        var activity = {
            content: $scope.activityInfo,
            location: "上海",
            imgUrl: "",
            createTime: new Date().getTime()
        };

        $http.post('/addActivity', activity)
            .then(function (response) {
                if(response.status == 200) {
                    alert('添加成功');
                } else {
                    alert(response.message);
                }
            })
    };

    $scope.uploadBlog = function (blogName) {
        var blog = {
            blogName: blogName,
            blogTitle: $scope.blogTitle,
            blogTag: $scope.blogTag,
            viewCount: 0,
            favouriteCount: 0,
            createTime: new Date().getTime()
        };
        $http.post('/addBlog', blog)
            .then(function (response) {
                if(response.status == 200) {
                    alert('博文插入/更新成功');
                } else {
                    alert('博文插入/更新失败');
                }
            })
    };

    $scope.save = function() {
        var fd = new FormData();
        var file = document.querySelector('input[type=file]').files[0];
        fd.append('file', file);
        $http({
            method:'POST',
            url:"/uploadMarkdown",
            data: fd,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        }).then( function (response) {
            if(response.status == 200) {
                $scope.uploadBlog(file.name);
            } else {
                alert(response.errorMsg);
            }
        });
    };

    $scope.loginAuth = function () {
        alert($scope.loginUsername + ' ' + $scope.loginPassword);
    }
}]);
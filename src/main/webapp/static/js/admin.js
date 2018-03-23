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
                alert("文件上传成功");
            } else {
                alert(response.errorMsg);
            }
        });
    };

    $scope.loginAuth = function () {
        alert($scope.loginUsername + ' ' + $scope.loginPassword);
    }
}]);
var app = angular.module('fireworks', []);
app.controller('FireworksAdminController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {
    $scope.addActivity = function () {
        var activity = {
            content: "撒发达第三方士大夫士大夫",
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
    }
}]);
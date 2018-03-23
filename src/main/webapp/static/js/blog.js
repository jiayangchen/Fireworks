var app = angular.module('fireworks', []);
app.controller('FireworksBlogController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {

    $scope.pathname = window.location.pathname;
    $scope.blogFileName = $scope.pathname.split("/")[2];

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

    $scope.initBlog();
}]);
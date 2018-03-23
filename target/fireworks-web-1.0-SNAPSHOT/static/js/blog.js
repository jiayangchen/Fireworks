var app = angular.module('fireworks', []);
app.controller('FireworksBlogController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {

    $scope.initBlog = function () {
        $http.get('/assets/md/2018-01-29-linkedBlockingQueue-source-code.md')
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
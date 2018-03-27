var app = angular.module('fireworks', []);
app.controller('FireworksGalleryController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {

    $scope.galleryList = null;

    $scope.initGallery = function () {
        $http.get('/getGallery')
            .then(function (response) {
                if(response.status == 200) {
                    $scope.galleryList = response.data.gallery;
                }
            })
    };

    $scope.initGallery();

}]);
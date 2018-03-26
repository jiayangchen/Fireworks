var app = angular.module('fireworks', []);
app.controller('FireworksGalleryController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {

    $scope.galleryList = null;
    // $scope.galleryList = [
    //     {src: 'http://o9oomuync.bkt.clouddn.com/bloghometown.jpeg', desc: '年关的家乡', filmDateAndPlace: '2018.02 摄于张家港乐余镇'},
    //     {src: 'http://o9oomuync.bkt.clouddn.com/blog%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20170921164059.jpg', desc: '东南大学毕业照拍摄地', filmDateAndPlace: '2017.09 摄于东大四牌楼校区'},
    //     {src: 'http://o9oomuync.bkt.clouddn.com/blog%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20170921161442.jpg', desc: '暴风雨来临前的晚霞', filmDateAndPlace: '2017.09 摄于东二十六楼寝室阳台'},
    //     {src: 'http://o9oomuync.bkt.clouddn.com/blog%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20170711192848.jpg', desc: '阵雨过后远处的上海中心', filmDateAndPlace: '2017.08 摄于来安路'},
    //     {src: 'http://o9oomuync.bkt.clouddn.com/bloglove.jpg', desc: '球场看台上的求婚', filmDateAndPlace: '2017.05 摄于上海八万人体育场'},
    //     {src: 'http://o9oomuync.bkt.clouddn.com/blogHackathon.jpg', desc: '2016 Microsoft Penta-Hackathon', filmDateAndPlace: '2016.11 摄于微软紫竹亚研院'},
    //     {src: 'http://o9oomuync.bkt.clouddn.com/blogmuseum.jpg', desc: '唐朝彩色侍女佣像', filmDateAndPlace: '2016 年中秋摄于上海博物馆'},
    //     {src: 'http://o9oomuync.bkt.clouddn.com/blogbinjiang_park.jpg', desc: '初春公园门口的风筝摊', filmDateAndPlace: '2016.04 摄于闵行区滨江公园外'},
    //     {src: 'http://o9oomuync.bkt.clouddn.com/blogmilitary_training.jpg', desc: '大一军训晚会', filmDateAndPlace: '2015.09 摄于上海交通大学霍英东体育馆'},
    //     {src: 'http://o9oomuync.bkt.clouddn.com/blogstadium.jpg', desc: '2015 赛季中超首轮', filmDateAndPlace: '2015.03 摄于上海八万人体育场'}
    // ];

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
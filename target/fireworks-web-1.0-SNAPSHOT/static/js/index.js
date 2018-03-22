var app = angular.module('fireworks', []);
app.controller('FireworksIndexController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {
    $scope.introduction = "从来不求时间为我搁浅...";
    $scope.recentBlog = [
        '每个人都有一个死角， 自己走不出来，别人也闯不进去。',
        '我把最深沉的秘密放在那里。',
        '你不懂我，我不怪你。'
    ];
    $scope.tagList = ['日志','Java','Android','跨年','数据库'];
    $scope.titleList = [
        '每个人都有一个死角， 自己走不出来，别人也闯不进去。',
        '我把最深沉的秘密放在那里。',
        '你不懂我，我不怪你。'
    ];

    $scope.init = function () {
        $http.get('/testHttp',{
            params:{
                data: 'hello world'
            }
        }).then(function (res) {
                console.log(res);
            });
    };

    $scope.init();
}
]);
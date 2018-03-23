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
        '你不懂我，我不怪你。',
        '《分布式服务架构：原理、设计与实战》全',
        '保障线上服务健康、可靠的最佳方案，是一本架构级、实战型的重',
        '然后提出了保证分布式服务系统架构一致性的方案和模式',
        '最后给出了一个简要的非功能质量的技术评审提纲。实践上，首先提供',
        '《分布式服务架构：原理、设计与实战》以分布式服务',
        '架构的设计与实现为主线，由浅入深地介绍了分布式服务架构的',
        '方方面面，主要包括理论和实践两部分。理论上，首',
        '先介绍了服务架构的背景，以及从服务化架构到微服务架构的演化'
    ];
    var activityList = [];
    for(var i=0; i<4; i++) {
        var activity = {};
        activity.content = '发生的尽快哈市发货撒看到了';
        activity.location = '上海';
        activity.date = '2018-01-12';
        activityList.push(activity);
    }
    $scope.activityList = activityList;
}]);
var app = angular.module('fireworks', []);
app.controller('FireworksAdminController', ['$scope', '$http', '$compile', function ($scope, $http, $compile) {

    $scope.loginUsername = null;
    $scope.loginPassword = null;
    $scope.activityInfo = null;
    $scope.imgSrc = '';
    $scope.imgDesc = '';
    $scope.imgDateAndPlace = '';

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

    $scope.editBlog = function (blog) {
        $http.post('/addBlog', blog)
            .then(function (response) {
                if(response.status == 200) {
                    alert('博文编辑成功');
                } else {
                    alert('博文编辑失败');
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

    $scope.addPhotograph = function () {
        var photoGraph = {
            src: $scope.imgSrc,
            desc: $scope.imgDesc,
            filmDateAndPlace: $scope.imgDateAndPlace,
            createTime: new Date().getTime()
        };

        $http.post('/addPhotograph', photoGraph)
            .then(function (response) {
                if(response.status == 200) {
                    alert('图片插入成功');
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
    };

    function showBlogTable (data) {
        layui.use('table', function(){
            var table = layui.table;
            table.on('edit(test)', function(obj){
                var value = obj.value   //得到修改后的值
                    ,data = obj.data    //得到所在行所有键值
                    ,field = obj.field; //得到字段
                var blog = {
                    id: data.id,
                    blogName: data.blogName,
                    blogTitle: data.blogTitle,
                    blogTag: data.blogTag,
                    viewCount: data.viewCount,
                    favouriteCount: data.favouriteCount,
                    createTime: data.createTime
                };
                $scope.editBlog(blog);
            });

            table.on('tool(test)', function(obj){
                var data = obj.data;      //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr;          //获得当前行 tr 的DOM对象
                if(layEvent === 'del'){ //删除
                    layer.confirm('真的删除行么', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        console.log(data);
                    });
                }
            });

            table.render({
                elem: '#test'
                ,cols: [[
                    {field:'id', width: 10, title: 'ID', sort: true}
                    ,{field:'blogName', title: '文件名'}
                    ,{field:'blogTitle', edit: 'text', title: '标题'}
                    ,{field:'blogTag', title: '标签', edit: 'text'}
                    ,{field:'viewCount', title: '阅读量', edit: 'text', sort: true}
                    ,{field:'favouriteCount', title: '点赞数', edit: 'text', sort: true}
                    ,{field:'id', title: '操作', toolbar: '#barDemo'}
                ]]
                ,page: true
                ,data: data
            });
        });
    }

    $scope.initPage = function () {
        $http.get('/listAllBlog')
            .then(function (response) {
                showBlogTable(response.data);
            })
    };
    $scope.initPage();
}]);
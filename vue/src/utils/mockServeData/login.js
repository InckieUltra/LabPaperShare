const Mock = require('mockjs')

const users = {
    username:'admin',
    password:'admin',
    code:0
}

//返回一个函数
module.exports = function(app){
    if(1){// 对环境变量进行一个判断，方便我们替换真实接口
        //监听http请求
        app.get('/api/login', function(req, res) {
            //将json文件传入Mock.mock 方法中，生成的数据返回给浏览器
            res.json(Mock.mock(users));
        });
    }
}

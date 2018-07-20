$(function () {


});

$(document).ready(function () {
    /*检查用户是否登录*/
    var loginResult = $.ajax({url: "/user/checkLogin.action", data: "id:666,name:大大大", async: false});
    var loginResult = loginResult.responseText;
    var loginResult = eval("(" + loginResult + ")");
    if ("true" == loginResult.result) {
        $("#liAboutMenu").after(
            '<li class="layui-nav-item" style=" float:right; list-style-type:none;">' +
            '<a href="javascript:;">' +
            '<img src="/common/images/portrait/face.jpg" class="layui-circle" width="35" height="35">' +
            '<cite>' + loginResult.userName + '</cite>' +
            '</a>' +
            '<dl class="layui-nav-child">' +
            '<dd><a href="/front/center.html" data-url=""><i class="iconfont icon-zhanghu"></i><cite>个人中心</cite></a></dd> ' +
            '<dd><a href="javascript:;" data-url="pages/user/userInfo.html"><i class="iconfont icon-zhanghu" data-icon="icon-zhanghu"></i><cite>个人资料</cite></a></dd> ' +
            '<dd><a href="javascript:;" data-url="pages/user/changePwd.html"><i class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>修改密码</cite></a></dd> ' +
            '<dd><a href="javascript:exit();" class="signOut"><i class="iconfont icon-loginout"></i><cite>退出</cite></a></dd> ' +
            '</dl> ' +
            '</li>'
        );
    } else {
        $("#liAboutMenu").after(
            '<li class="layui-nav-item login_register" style=" float:right; list-style-type:none;">' +
            '<a href="javascript:showLoginModal();">登录/注册</a>' +
            '</li>'
        );
    }
    $(".btn1").click(function () {
        $("p").slideToggle();
    });
});

function exit() {
    $.ajax({
        async: false,
        type: "post",
        url: "/user/exitLogin.html",
        datatype: 'json',
        success: function (data) {
            if ("true" == data) {
                window.location.reload(true);
            }
        }
    })
    ;
}
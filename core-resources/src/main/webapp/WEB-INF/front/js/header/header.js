function showLoginModal(){
    layer.open({
        type: 2,
        title:false,
        shadeClose: true,
        closeBtn:2,
        shade: 0.8,
        area: ['540px', '320px'],
        content: '../front/commonPage/loginPage.html'
    });
}
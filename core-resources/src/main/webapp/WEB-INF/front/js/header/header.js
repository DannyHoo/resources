function showLoginModal(){
    layer.open({
        type: 2,
        title:false,
        shadeClose: true,
        shade: 0.8,
        area: ['560px', '350px'],
        content: '../front/commonPage/loginPage.html'
    });
}
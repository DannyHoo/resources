$(function () {
    $("#loginModal").modal("show");

    $("#loginBtn").click(function () {
        doLogin();
        $("#loginBtn").click(function () {
            doLogin();
        });
    });
})
function doLogin() {
    var userName = $("#id_account_l").val();
    var password = $("#id_password_l").val();
    console.log("userName:" + userName + ";password:" + password);

    var publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSnNia3a3y1345e4Rgc2vJ/lvx5KvMqRHe6LQchn3KiF9c/stgLX8sW/QwhQGqeTP+VUxTV5IFcXWXDCNIJWykLDbruFcUU8JQHesA3yDbXVArstqTvLquuW3oZY4ScIai47O+C0y7yMrAzYcVhZk41gOMeYr4xqkVtc+4UnmSUQIDAQAB";

    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey);
    var encrypted = encrypt.encrypt(password);
    console.log("加密后：" + encrypted);

    var temp;
    $.ajax({
        async: false,
        data:{"userName":userName,"password":encrypted},
        type: "post",
        url: "/user/doLogin.html",
        datatype: 'json',
        success: function (data) {
            temp = data;
        }
    });
    alert(temp);

    /*var decrypt = new JSEncrypt();
     decrypt.setPrivateKey(privateKey);
     var decrypted = decrypt.decrypt(encrypted);
     console.log("解密后："+decrypt);*/
}
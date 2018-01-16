$(function () {
    changeContent("toMyCenter");

    $("#toMyCenter").click(function () {
        changeContent("toMyCenter");
    });
    $("#toSetting").click(function () {
        changeContent("toSetting");
    });
    $("#toMyResources").click(function () {
        changeContent("toMyResources");
    });
    $("#toTaskCenter").click(function () {
        changeContent("toTaskCenter");
    });
    $("#toVoucher").click(function () {
        changeContent("toVoucher");
    });
    $("#toMoney").click(function () {
        changeContent("toMoney");
    });
    $("#toInvite").click(function () {
        changeContent("toInvite");
    });
    $("#toMessages").click(function () {
        changeContent("toMessages");
    });

    /* 根据菜单点击切换内容 */
    function changeContent(liId) {
        var result = $.ajax({url: "/front/center/" + liId, async: false});
        var availableTagsStr = result.responseText;
        $("#center_main_content").html(availableTagsStr);
        changeLeftMenuMark($("#" + liId));
    };

    /* 切换左侧导航栏选中标识 */
    function changeLeftMenuMark(li) {
        $('#navt').find('li').each(function () {
            $(this).attr("class", "");
        });
        $(li).attr("class", "activ");
    };

});

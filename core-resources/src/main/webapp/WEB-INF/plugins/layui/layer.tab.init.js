//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function () {
    var element = layui.element;
    //…
});

$(function () {
    var importType = $("#importType").val();
    /**
     * LOAN(1, "借款数据"),
     * REPAY(2, "还款数据")
     * */
    //借款数据,不能查看 还款信息
    if(importType && "1" == importType) {
        $("#tab3").click(function () {
            return false;
        });
    }
    //还款数据,不能查看 借款人和贷款数据
    if (importType && "2"==importType) {
        $($("div.layui-tab-item")[0]).removeClass("layui-show");
        $("#tab1").removeClass("layui-this");
        $($("div.layui-tab-item")[2]).addClass("layui-show");
        $("#tab3").addClass("layui-this");

        $("#tab1").click(function () {
            return false;
        });
        $("#tab2").click(function () {
            return false;
        });
    }
    /**将显示为 -1.00 的内容显示为空**/
    $("dd.result").each(function () {
        if( $(this).html() =="-1.00" || $(this).html() == "-1" ){
            $(this).html("");
        }
    });
});
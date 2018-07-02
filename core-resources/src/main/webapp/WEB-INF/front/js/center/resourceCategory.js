$(function () {

    queryCategoryDetail();

    /* 分页查询 */
    function queryCategoryDetail() {
        var pageNum = $("#pageNum").val();
        var categoryCode = $("#categoryCode").val();

        var result = $.ajax({
            url: "/front/resource/category/" + categoryCode + "/" + pageNum + ".action",
            async: false
        });
        var categoryDetailStr = result.responseText;
        var categoryDetail = eval("(" + categoryDetailStr + ")");

        var pageCount = categoryDetail.pageCount;
        var dataCount = categoryDetail.dataCount;

        /* 数据显示 */
        var resourceDataList = categoryDetail.resourceDataList;
        for (var i = 0; i < resourceDataList.length; i++) {
            var title = resourceDataList[i].title;
            var note = resourceDataList[i].note;
            var resourceDate = resourceDataList[i].resourceDate;
            var categoryName = resourceDataList[i].categoryName;
            $("#resourceData").append("<li class='publicborder'> <a href='' target='_blank' title='" + title + "'><img src='" + resourceDataList[i].picture + "' alt='" + title + "'></a><h2 class='layui-elip'><a href='' target='_blank' title='" + title + "'>" + substringAndReplace(title, 20) + "</a></h2><p>" + substringAndReplace(note, 30) + "</p><div class='info'><span class='time'><i class='iconfont icon-shijian'></i>" + resourceDate + "</span><span class='source'><i class='iconfont icon-laiyuan1'></i><a href=''>" + categoryName + "</a></span></div></li>");
        }

        /* 分页处理 */
        if (pageNum == 1) {
            $("#page").append("<li>首页</li>");
        } else {
            $("#page").append("<li><a href='/front/resource/category/" + categoryCode + ".html?pageNum=1'>首页</a></li><li><a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + (pageNum - 1) + "'>上一页</a></li>");
        }
        if (pageCount <= 7 || pageNum <= 4) {
            for (var i = 1; i <= (pageCount > 7 ? 7 : pageCount); i++) {
                if (pageNum == i) {
                    $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + i + "'><li class='thisclass'>" + i + "</li></a>");
                } else {
                    $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + i + "'><li>" + i + "</li></a>");
                }
            }
        } else if (pageCount > 7 && pageNum + 3 <= pageCount) {
            $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + (pageNum - 3) + "'><li>" + pageNum - 3 + "</li></a>");
            $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + (pageNum - 2) + "'><li>" + pageNum - 2 + "</li></a>");
            $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + (pageNum - 1) + "'><li>" + pageNum - 1 + "</li></a>");
            $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + pageNum + "'><li class='thisclass'>" + pageNum + "</li></a>");
            $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + (pageNum + 1) + "'><li>" + pageNum + 1 + "</li></a>");
            $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + (pageNum + 2) + "'><li>" + pageNum + 2 + "</li></a>");
            $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + (pageNum + 3) + "'><li>" + pageNum + 3 + "</li></a>");
        } else {
            for (var i = pageCount - 6; i <= pageCount; i++) {
                if (pageNum == i) {
                    $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + i + "'><li class='thisclass'>" + i + "</li></a>");
                } else {
                    $("#page").append("<a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + i + "'><li>" + i + "</li></a>");
                }
            }
        }
        if (pageNum == pageCount) {
            $("#page").append("<li>末页</li>");
        } else {
            $("#page").append("<li><a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + (parseInt(pageNum) + 1) + "'>下一页</a></li>");
            $("#page").append("<li><a href='/front/resource/category/" + categoryCode + ".html?pageNum=" + pageCount + "'>末页</a></li>");
        }
        $("#page").append("<li><span class='pageinfo'>共 <strong>" + pageCount + "</strong>页 <strong>" + dataCount + "</strong>条</span></li>");

    };

    function substringAndReplace(str, length) {
        if (str.length <= length) {
            return str;
        } else {
            return str.substr(0, length) + "......";
        }
    }
});


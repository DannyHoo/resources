$(function () {

    /* 热门排行 */
    queryHotRankList("ulHotRankList", 10);

    /* 随机推荐 */
    queryRandomList("ulRandomList", 12);

    /* 热门排行 */
    function queryHotRankList(ulId, recordCount) {
        $.ajax({
                async: true,
                type: "get",
                data: "",
                url: "/front/resource/queryOrderByViewCount/" + recordCount + ".action",
                datatype: 'json',
                success: function (data) {
                    var resourceList = data.resourceDataList;
                    for (var i = 0; i < resourceList.length; i++) {
                        var title = resourceList[i].title;
                        var resourceCode = resourceList[i].resourceCode;
                        if (i < 3) {
                            $("#" + ulId).append("<li><i style='background:#FA4E57;'>" + (i + 1) + "</i><a href='/front/resource/view/" + resourceCode + ".html' target='_blank' title='" + title + "' class='g-rank-name'>" + substringAndReplace(title, 16) + "</a></li>");
                        } else {
                            $("#" + ulId).append("<li><i style='background:#999;'>" + (i + 1) + "</i><a href='/front/resource/view/" + resourceCode + ".html' target='_blank' title='" + title + "' class='g-rank-name'>" + substringAndReplace(title, 16) + "</a></li>");
                        }
                    }
                }
            }
        );
    }

    /* 随机推荐 */
    function queryRandomList(ulId, recordCount) {
        $.ajax({
                async: true,
                type: "get",
                data: "",
                url: "/front/resource/queryOrderByRand/" + recordCount + ".action",
                datatype: 'json',
                success: function (data) {
                    var resourceList = data.resourceDataList;
                    for (var i = 0; i < resourceList.length; i++) {
                        var title = resourceList[i].title;
                        var resourceCode = resourceList[i].resourceCode;
                        var picture=resourceList[i].picture;
                        if (i < 2) {
                            $("#" + ulId).append("<li class='list_pic'><a href='/front/resource/view/" + resourceCode + ".html' target='_blank' class='hn_img'><img src='"+picture+"' alt=''></a><a title='' target='_blank' href='/front/resource/view/" + resourceCode + ".html' class='list_title'>" + substringAndReplace(title, 14) + "</a></li>");
                        } else {
                            $("#" + ulId).append("<li class='hn_li'><a title='' target='_blank' href='/front/resource/view/" + resourceCode + ".html'>" + substringAndReplace(title, 16) + "</a></li>");
                        }
                    }
                }
            }
        );
    }

    function substringAndReplace(str, length) {
        if (str.length <= length) {
            return str;
        } else {
            return str.substr(0, length) + "......";
        }
    }
});


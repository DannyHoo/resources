$(function () {

    /* 最近更新 */
    queryRecentList();
    /* 热门排行 */
    queryHotRankList("ulHotRankList", 10);

    /* 编程语言 */
    queryResourceList("Course_ProgramLanguage", "ulProgramLanguate", 1, 12);
    /* 实用工具 */
    queryResourceList("Softwares_Tools", "ulSoftwaresTools", 1, 12);
    /* 架构设计 */
    queryResourceList("Course_Architecture", "ulCourseArchitecture", 1, 12);
    /* 系统源码 */
    queryResourceList("SourceCode_SystemCode", "ulSourceCodeSystemCode", 1, 12);
    /* 体育财经 */
    queryResourceList("News_SportsEconomic", "ulNewsSportsEconomic", 1, 12);
    /* 实时热点 */
    queryResourceList("News_HotNews", "ulNewsHotNews", 1, 12);
    /* 电影资源 */
    queryEntertainmentMoviesList("Entertainment_Movies", "ulEntertainmentMovies", 1, 18);

    /* 最近更新 */
    function queryRecentList() {
        var recordCount=60;
        $.ajax({
                async: false,
                type: "get",
                data: "",
                url: "/front/resource/queryOrderByCreateTime/" + recordCount + ".action",
                datatype: 'json',
                success: function (data) {
                    var resourceList = data.resourceDataList;
                    for (var i = 0; i < resourceList.length; i++) {
                        var title = resourceList[i].title;
                        var resourceCode = resourceList[i].resourceCode;
                        var ulId;
                        if (i >=0 && i<10) {
                            ulId="ulRecentList1_1";
                        } else if (i >=10 && i<20){
                            ulId="ulRecentList1_2";
                        } else if (i >=20 && i<30){
                            ulId="ulRecentList2_1";
                        } else if (i >=30 && i<40){
                            ulId="ulRecentList2_2";
                        } else if (i >=40 && i<50){
                            ulId="ulRecentList3_1";
                        } else if (i >=50 && i<60){
                            ulId="ulRecentList3_2";
                        }
                        $("#" + ulId).append("<li class=''><span class='date'>02日</span><span class='title'><a target='_blank' href='/front/resource/view/" + resourceCode + ".html' title='"+title+"'>"+title+"</a></span></li>");
                    }
                }
            }
        );
    }

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
                            $("#" + ulId).append("<li><i style='background:#FA4E57;'>" + (i + 1) + "</i><a href='/front/resource/view/" + resourceCode + ".html' target='_blank' title='" + title + "' class='g-rank-name'>" + substringAndReplace(title, 22) + "</a></li>");
                        } else {
                            $("#" + ulId).append("<li><i style='background:#999;'>" + (i + 1) + "</i><a href='/front/resource/view/" + resourceCode + ".html' target='_blank' title='" + title + "' class='g-rank-name'>" + substringAndReplace(title, 22) + "</a></li>");
                        }
                    }
                }
            }
        );
    }

    /* 分页查询 */
    function queryResourceList(categoryCode, ulId, pageNum, pageSize) {
        $.ajax({
            async: true,
            type: "get",
            data: "",
            url: "/front/resource/category/" + categoryCode + "/" + pageNum + "/" + pageSize + ".action",
            datatype: 'json',
            success: function (data) {
                var resourceList = data.resourceDataList;
                for (var i = 0; i < resourceList.length; i++) {
                    var title = resourceList[i].title;
                    var resourceCode = resourceList[i].resourceCode;
                    $("#" + ulId).append("<li class=''><span class='date'>25日</span><span class='title'><a target='_blank' href='/front/resource/view/" + resourceCode + ".html' title=''>" + substringAndReplace(title, 35) + "</a></span></li>");
                }
            }
        });
    }

    function queryEntertainmentMoviesList(categoryCode, ulId, pageNum, pageSize) {
        $.ajax({
            async: true,
            type: "get",
            data: "",
            url: "/front/resource/category/" + categoryCode + "/" + pageNum + "/" + pageSize + ".action",
            datatype: 'json',
            success: function (data) {
                var resourceList = data.resourceDataList;
                for (var i = 0; i < resourceList.length; i++) {
                    var title = resourceList[i].title;
                    var resourceCode = resourceList[i].resourceCode;
                    var picture = resourceList[i].picture;
                    $("#" + ulId).append("<li><a title='' target='_blank' href=''><img src='" + picture + "' class='lazy' data-original='" + picture + "' height='100px' width='100px' style='display: inline-block;'></a><span><a title='" + title + "' target='_blank' href='/front/resource/view/" + resourceCode + ".html'>" + title + "</a></span></li>");
                }
            }
        });
    }

    function substringAndReplace(str, length) {
        if (str.length <= length) {
            return str;
        } else {
            return str.substr(0, length) + "......";
        }
    }
})
;



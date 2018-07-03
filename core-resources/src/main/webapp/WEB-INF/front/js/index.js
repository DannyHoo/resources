$(function () {

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

    /* 分页查询 */
    function queryResourceList(categoryCode, ulId, pageNum, pageSize) {
        $.ajax({
            async: true,
            type: "get",
            data: "",
            url: "/front/resource/category/" + categoryCode + "/" + pageNum + "/" + pageSize + ".action",
            datatype: 'json',
            success: function (data) {
                var resourceList=data.resourceDataList;
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
                var resourceList=data.resourceDataList;
                for (var i = 0; i < resourceList.length; i++) {
                    var title = resourceList[i].title;
                    var resourceCode = resourceList[i].resourceCode;
                    var picture=resourceList[i].picture;
                    $("#" + ulId).append("<li><a title='' target='_blank' href=''><img src='"+picture+"' class='lazy' data-original='"+picture+"' height='100px' width='100px' style='display: inline-block;'></a><span><a title='"+title+"' target='_blank' href='/front/resource/view/" + resourceCode + ".html'>"+title+"</a></span></li>");
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
});



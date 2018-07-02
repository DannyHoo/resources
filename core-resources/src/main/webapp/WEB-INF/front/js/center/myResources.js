
function changeSecondCategory(firstValue) {
    if (firstValue == "Softwares") {
        $('#secondCategorySelect').empty();
        $("#secondCategorySelect").append("<option value='Softwares_Security'>安全杀毒</option>");
        $("#secondCategorySelect").append("<option value='Softwares_StudyOffice'>学习办公</option>");
        $("#secondCategorySelect").append("<option value='Softwares_Tools'>实用工具</option>");
        $("#secondCategorySelect").append("<option value='Softwares_System'>系统软件</option>");
    }
    if (firstValue == "Course") {
        $('#secondCategorySelect').empty();
        $("#secondCategorySelect").append("<option value='Course_ProgramLanguage'>编程语言</option>");
        $("#secondCategorySelect").append("<option value='Course_FrontDesign'>前端设计</option>");
        $("#secondCategorySelect").append("<option value='Course_SysOperation'>系统运维</option>");
        $("#secondCategorySelect").append("<option value='Course_Security'>安全攻防</option>");
        $("#secondCategorySelect").append("<option value='Course_Architecture'>架构设计</option>");
    }
    if (firstValue == "SourceCode") {
        $('#secondCategorySelect').empty();
        $("#secondCategorySelect").append("<option value='SourceCode_Front'>前端源码</option>");
        $("#secondCategorySelect").append("<option value='SourceCode_PageFunction'>网页特效</option>");
        $("#secondCategorySelect").append("<option value='SourceCode_DevelopDemo'>开发实例</option>");
        $("#secondCategorySelect").append("<option value='SourceCode_SystemCode'>系统源码</option>");
    }
    if (firstValue == "News") {
        $('#secondCategorySelect').empty();
        $("#secondCategorySelect").append("<option value='News_Life'>生活资讯</option>");
        $("#secondCategorySelect").append("<option value='News_Culturl'>文化娱乐</option>");
        $("#secondCategorySelect").append("<option value='News_Finance'>金融动态</option>");
        $("#secondCategorySelect").append("<option value='News_SportsEconomic'>体育财经</option>");
        $("#secondCategorySelect").append("<option value='News_HotNews'>时事热点</option>");
    }
    if (firstValue == "Entertainment") {
        $('#secondCategorySelect').empty();
        $("#secondCategorySelect").append("<option value='Entertainment_Movies'>电影资讯</option>");
        $("#secondCategorySelect").append("<option value='Entertainment_Pictures'>福利美图</option>");
    }
    if (firstValue == "Activity") {
        $('#secondCategorySelect').empty();
        $("#secondCategorySelect").append("<option value='Activity_OnLine'>线上互动</option>");
        $("#secondCategorySelect").append("<option value='Activity_OffLine'>线下分享</option>");
        $("#secondCategorySelect").append("<option value='Activity_Party'>交友聚会</option>");
    }
    layui.use('form', function () {
        var form = layui.form; //重新渲染表单，否则显示不出来
        form.render();
        form.on('select(firstCategory)', function (data) {
            changeSecondCategory(data.value);
        });
    });
}

function readDownloadDisable(selectValue){
    if (selectValue =="read") {
        $("#downloadForm1").attr("style", "display:none;");
        $("#downloadForm2").attr("style", "display:none;");
        $("#downloadForm3").attr("style", "display:none;");
    } else{
        $("#downloadForm1").attr("style", "display:block;");
        $("#downloadForm2").attr("style", "display:block;");
        $("#downloadForm3").attr("style", "display:block;");
    }
}
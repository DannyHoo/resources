function checkLogin(url){
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	if(projectName!="/puhuilicai"){
		projectName="";
	}
	$.ajax({
		type : "POST",
		url : projectName+"/checkLogin.htm",                                                               
		async : false,
		data:'', 
		success : function(data) {
			if(data=='yes'){
				window.location.href=url;
			}else{
				url=escape(url);
				layer.open({
					  type: 2,
					  title: '',
					  shadeClose: true,
					  shade: 0.8,
					  area: ['447px', '452px'],
					  content: projectName+'/toLogin.htm?returnUrl='+url 
				}); 
			}
		}
	});
}
var popWin = {
    scrolling: 'no',
    //是否显示滚动条 no,yes,auto

int: function() {
        this.mouseClose();
        this.closeMask();
    },

showWin: function(width, height, title, src) {
        var iframeHeight = height - 52;
        var marginLeft = width / 2;
        var marginTop = height / 2;
        var inntHtml = '';
        inntHtml += '<div id="mask" style="background-color:#333;width:100%;height:100%;position:fixed; top:0; left:0;z-index:1999;-moz-opacity:0.5; -khtml-opacity: 0.5; opacity:0.5;"></div>'
        inntHtml += '<div id="maskTop" style="color: #333; position: fixed; top: 60%; left: 63%; margin-left: -' + marginLeft + 'px; margin-top: -' + marginTop + 'px; z-index: 2999; filter: progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=4);">'
        inntHtml += '<iframe  allowtransparency="true" style="background-color=transparent"  width="545px" height="675px"  scrolling="' + this.scrolling + '" src="' + src + '"></iframe>';

        parent.$("body").append(inntHtml);


    },
    

showRegister: function(width, height, title, src) {
    var iframeHeight = height - 52;
    var marginLeft = width / 2;
    var marginTop = height / 2;
    var inntHtml = '';
    inntHtml += '<div id="mask" style="position:fixed; top:0; left:0; z-inde:1999; -moz-opacity:0.5; -khtml-opacity: 0.5; opacity:0.5;"></div>'
    inntHtml += '<div id="maskTop" style="color: #333; position: fixed; top: 60%; left: 63%; margin-left: -' + marginLeft + 'px; margin-top: -' + marginTop + 'px; z-index: 2999; filter: progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=4);">'
    inntHtml += '<iframe  allowtransparency="true" style="background-color=transparent"  width="545px" height="810px"  scrolling="' + this.scrolling + '" src="' + src + '"></iframe>';

    $("body").append(inntHtml);
    /*this.int();*/


},

mouseClose: function() {
        $("#popWinClose").on('mouseenter', 
        function() {
            $(this).css("background", "url(img/clses.jpg)no-repeat");

        });

        $("#popWinClose").on('mouseleave', 
        function() {
        	 $(this).css("background", "url(img/clses.jpg)no-repeat");

        });

    },

closeMask: function() {
        $("#popWinClose").on('click', 
        function() {
            $("#mask,#maskTop").fadeOut(function() {
                $(this).remove();

            });

        });

    }
};
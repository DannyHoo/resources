$(function(){
	if(window.location.href.indexOf("loan")>0 || window.location.href.indexOf("invest")>0){
		$("#invest").addClass("current");
	}else if(window.location.href.indexOf("account.htm")>0){
		$("#account").addClass("current");
	}
	else if(window.location.href.indexOf("insurance")>0){
		$("#insurance").addClass("current");
	}
	else if(window.location.href.indexOf("about")>0){
		$("#about").addClass("current");
	}
});

function httpAjax(locationhref, cs) {
	$.ajax({
		type : "POST",
		url : locationhref,
		dataType : "html",
		async : false,
		success : function(data) {
			$("#" + cs).html(data);
		}
	});
}

/**
 * 邮箱
 * 
 * @returns {Boolean}
 */
function checkEmail() {

	var email = $("#email").val();
	if (email == "" || email.length == 0) {
		$("#emailMsg").html("邮箱不能为空！");
		return false;
	}
	if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(email) == false) {
		$("#emailMsg").html("邮箱格式不正确！请重新输入！");
		return false;
	}
	$("#emailMsg").html("");
	return true;
}

/**
 * 验证邮箱
 */
function checkEmailMsg(email,showMsgId){
	if (email == "" || email.length == 0) {
		$("#" + showMsgId).html("邮箱不能为空！");
		return false;
	}
	if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(email) == false) {
		$("#" + showMsgId).html("邮箱格式不正确！请重新输入！");
		return false;
	}
	$("#" + showMsgId).html("");
	return true;
}

/**
 * 手机号验证
 */
function checkMobile() {
	if ($("#mobile").val() == "") {
		$("#mobileMsg").html("手机号码不能为空！");
		return false;
	}
	if (!$("#mobile").val().match(/^1[3|4|5|7|8][0-9]\d{9}$/) && $("#mobile").val().length!=11) {
		$("#mobileMsg").html("手机号码格式不正确！请重新输入！");
		return false;
	}
	$("#mobileMsg").html("");
	return true;
}

/**
 * 手机号验证
 * mobile:手机号 showMsgId:显示提示信息ID
 */
function checkMobileMsg(mobile,showMsgId){
	if(mobile == ''){
		$("#" + showMsgId).html("手机号码不能为空！");
		return false;
	}
	if(!mobile.match(/^1[3|4|5|7|8][\d]{9}$/)){
		$("#" + showMsgId).html("手机号码格式不正确！请重新输入！");
		return false;
	}
	$("#" + showMsgId).html("");
	return true;
}


function money2(payMoney)
{
	var numindex = parseInt(payMoney.indexOf("."),10);  
    if(numindex == 0){  
        return false;  
    }  
    var head = payMoney.substring(0,numindex);  
    var bottom = payMoney.substring(numindex,numindex+3);  
    var fianlNum = head+bottom;  
    return fianlNum;
}

//3位有,
function fmoney(s, n) {
	n = n > 0 && n <= 20 ? n : 2;
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
	var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
	t = "";
	for (i = 0; i < l.length; i++) {
		t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
	}
	return t.split("").reverse().join("") + "." + r;
}

//3位无,
function fmoneys(s, n) {
	n = n > 0 && n <= 20 ? n : 2;
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
	var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
	t = "";
	for (i = 0; i < l.length; i++) {
		t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "" : "");
	}
	return t.split("").reverse().join("") + "." + r;
}
function rmoney(s)  
{  
   return parseFloat(s.replace(/[^\d\.-]/g, ""));  
}  

function formatDate(date, format) {
	var paddNum = function(num) {
		num += "";
		return num.replace(/^(\d)$/, "0$1");
	}
	// 指定格式字符
	var cfg = {
		yyyy : date.getFullYear() // 年 : 4位
		,
		yy : date.getFullYear().toString().substring(2)// 年 : 2位
		,
		M : date.getMonth() + 1 // 月 : 如果1位的时候不补0
		,
		MM : paddNum(date.getMonth() + 1) // 月 : 如果1位的时候补0
		,
		d : date.getDate() // 日 : 如果1位的时候不补0
		,
		dd : paddNum(date.getDate())// 日 : 如果1位的时候补0
		,
		hh : paddNum(date.getHours()) // 时
		,
		mm : paddNum(date.getMinutes()) // 分
		,
		ss : paddNum(date.getSeconds())
	// 秒
	}
	format || (format = "yyyy-MM-dd hh:mm:ss");
	return format.replace(/([a-z])(\1)*/ig, function(m) {
		return cfg[m];
	});
}

function quickQueryCust(evt) {
	evt = (evt) ? evt : ((window.event) ? window.event : "") // 兼容IE和Firefox获得keyBoardEvent对象
	var key = evt.keyCode ? evt.keyCode : evt.which; // 兼容IE和Firefox获得keyBoardEvent对象的键值
	if (key == 13) { 
		// 判断是否是回车事件。
		return false;
	}
}

/**
 * 设置未来(全局)的AJAX请求默认选项
 * 主要设置了AJAX请求遇到Session过期的情况
 */
//$.ajaxSetup({
//    type: 'POST',
//    complete: function(xhr,status) {
//        var sessionStatus = xhr.getResponseHeader('sessionstatus');
//        if(sessionStatus == 'timeout') {
//        	top.location.href = rootPath;
//        }
//    }
//});

/**
 * 在页面中任何嵌套层次的窗口中获取顶层窗口
 * @return 当前页面的顶层窗口对象
 */
function getTopWinow(){
    var p = window;
    while(p != p.parent){
        p = p.parent;
    }
    return p;
}

/**
 * 伪造form表单，实现a标签post提交-胡玉洋-2016年4月8日15:36:02
 * @param url eg:'/dosomething'
 * @param params eg:{id:1,name:’Jack’}
 * @returns {___anonymous4464_4467}
 */
function post(url, params) {
	var temp = document.createElement("form");
	temp.action = url;
	temp.method = "post";
	temp.style.display = "none";
	/*for (var x in params) {
	var opt = document.createElement("textarea");
	opt.name = x;
	opt.value = params[x];
	temp.appendChild(opt);
	}
	document.body.appendChild(temp);*/
	temp.submit();
	return temp;
}
/**
 * 获取网站根目录
 * @returns 网站根目录
 */
function getRootPath(){   
	var strFullPath=window.document.location.href;   
	var strPath=window.document.location.pathname;   
	var pos=strFullPath.indexOf(strPath);   
	var prePath=strFullPath.substring(0,pos);   
	var postPath=strPath.substring(0,strPath.substr(1).indexOf('/')+1);
	if(postPath!="/puhuilicai"){
		postPath="";
	}
	return(prePath+postPath);   
}
/**
 * 关闭当前页面
 */
function closeThisPage(){
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
		   window.opener = null;
		   window.close();
		} else {
		   window.open('', '_top');
		   window.top.close();
		}
	}else if (navigator.userAgent.indexOf("Firefox") > 0) {
		  window.location.href = 'about:blank ';
	} else {
		  window.opener = null;
		  window.open('', '_self', '');
		  window.close();
	}
}
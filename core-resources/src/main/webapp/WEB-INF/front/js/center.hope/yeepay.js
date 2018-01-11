var pathName=window.document.location.pathname;
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
if(projectName!="/puhuilicai"){
	projectName="";
}

function amountCheck() {
	$("#amountMsg").html("");
	var amount = $("#amount").val();
	if (amount == 0) {
		$("#amountMsg").html("操作金额不能为0！");
		return false;
	}
	var moneyType = /^(?!0+(?:\.0+)?$)(?:[1-9]\d*|0)(?:\.\d{1,2})?$/;
	if (moneyType.test(amount) == false) {
		$("#amountMsg").html("请输入有效的操作金额！");
		return false;
	}
	return true;
}

/**
 * 真实姓名有效的验证
 */
function realNameCheck() {
//	if ($("#realName").val() == "") {
//		$("#nameMsg").html("请输入有效的真实姓名！");
//		return false;
//	}
	var realname = $("#realName").val().trim();
	var reg=/^[\u2E80-\u9FFF]+$/;//Unicode编码中的汉字范围
	if(realname == ""){
		$("#nameMsg").text("请输入您的姓名");
		return false;
	}
	else if(!reg.test(realname)){
		$("#nameMsg").text("姓名只能是汉字");
		return false;
	}

	$("#nameMsg").html("");
	return true;
}

/**
 * 手机号号验证
 */
function checkMobile(obj) {
	if (/^[1][3,4,5,7,8][0-9]{9}$/.test(obj) == false) {
		$("#mobileMsg").html("手机号格式不正确！请重新输入！");
		return false;
	}else{
		$("#mobileMsg").html("");
	}
	return true;
}
/**
 * 身份证号验证
 */
function cardNoCeck(obj) {
	if (checkEnergyCard(obj) == false) {
		$("#cardMsg").html("请输入有效的身份证号！");
		return false;
	}
	$("#cardMsg").html("");
	return true;
}

/**
 * 验证邮箱
 */
function checkEmailMsg(email, showMsgId) {
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
function toCgtActivePlatUser(){
	$.ajax({
		type : "POST",
		url : "../../toActivePlatuser.htm",
		dataType : "json",
		async : false,
		success : function(data) {
			if(data.activeStatus==1){
				parent.layer.msg("您的账户已经激活！");
			}else if(data.activeStatus==3){
				parent.layer.msg("激活跑丢了,请联系客服进行手动激活！");
			}else{
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.open({
					  type: 1,
					  title: '',
					  shadeClose: false,
					  closeBtn:0,
					  shade: 0.5,
					  area: ['720px', '420px'],
					  move: false,//禁止拖拽
					  content : $('#win').html()
				});
				parent.$("#serviceName1").val(data.serviceName);
				parent.$("#service1").val(data.serviceName);
				parent.$("#platformNo1").val(data.platformNo);
				parent.$("#reqData1").val(data.reqData);
				parent.$("#keySerial1").val(data.keySerial);
				parent.$("#requestNo1").val(data.requestNo);
				parent.$("#sign1").val(data.sign);
				parent.$("#yeepay1").attr("action",data.action);
				parent.$("#yeepay1").submit();
				parent.layer.close(index);
			}
		}
	});
}
function toCgtActivePlatUserMyHope(){
	$.ajax({
		type : "POST",
		url : "../../toActivePlatuser.htm",
		dataType : "json",
		async : false,
		success : function(data) {
			
			if(data.activeStatus==1){
				layer.msg("您的账户已经激活成功！");
				setTimeout(function(){window.location.reload();},2000);
				$("#oldUser").hide();
			}else if(data.activeStatus==2){
				layer.msg("您的账户已经激活成功！");
				setTimeout(function(){window.location.reload();},2000);
				$("#oldUser").hide();
			}else if(data.activeStatus==3){
				layer.msg("激活跑丢了,请联系客服进行手动激活！");
			}else{
				layer.open({
					  type: 1,
					  title: '',
					  shadeClose: false,
					  closeBtn:0,
					  shade: 0.5,
					  area: ['720px', '420px'],
					  move: false,//禁止拖拽
					  content : $('#win2').html()
				});
				$("#activeServiceName").val(data.serviceName);
				$("#activeService").val(data.serviceName);
				$("#activePlatformNo").val(data.platformNo);
				$("#activeReqData").val(data.reqData);
				$("#activeKeySerial").val(data.keySerial);
				$("#activeRequestNo").val(data.requestNo);
				$("#activeSign").val(data.sign);
				document.activeYeepay.action = data.action;
				document.activeYeepay.submit();
			}
		}
	});
}
/**
 * 易宝修改密码
 */
function toYeePayResetPassword() {

	$.ajax({
		type : "POST",
		url : "../../ssl/payment/toResetPassword.htm",
		dataType : "json",
		async : false,
		success : function(data) {
			//$("#resetpassword_resetpassword_overlay").attr("style", "display:block");
			//$("#resetpassword_win").attr("style", "display:block");
			if(data.isEnterprise=='yes'){
				layer.open({
					  type: 1,
					  title: '',
					  shadeClose: false,
					  closeBtn:0,
					  shade: 0.5,
					  area: ['720px', '420px'],
					  move: false,//禁止拖拽
					  content : $('#win')
				});
				cgtRequestSubmit(data);
			}else{
				layer.msg("您的企业没有通过认证<br>不能进行密码重置！");
			}
		},
		error: function() {
			location.reload();
		}
	});
}

/**
 * 修改易宝手机号
 */
function toYeePayResetMobile(){
	var mobile=$('#mobile').val();//修改预留手机号提交表单存手机号后跳转新网改手机号页面待写
	var data="mobile="+mobile;
	$.ajax({
		type : "POST",
		url : "../../ssl/payment/toResetMobile.htm",
		dataType : "json",
		data:data,
		async : false,
		success : function(data) {
			if(data.isEnterprise=='yes'){
				cgtRequestSubmit(data);
				var rq = data.requestNo;
				parent.layer.open({
					type: 2,
					  title: '',
					  shadeClose: false,
					  closeBtn:0,
					  shade: 0.5,
					  area: ['720px', '420px'],
					  move: false,//禁止拖拽
					  content: [projectName + '/ssl/account/toChangeMobileTanCeng.htm?requestNo='+rq+'&service='+data.serviceName, 'no']
				});
			}else{
				layer.msg("您的企业没有通过认证<br>不能更新手机号！");
			}
		},
		error: function() {
			location.reload();
		}
	});
}

/**
 * 易宝注册(开通银行存管账户)
 */
function toYeePayRegister(type) {
	var data="realName=" + $("#realName").val().trim() + "&cardNo="
	+ $("#cardNo").val().trim() + "&location=" + $("#location").val().trim();
	if(type==1){
		data+="&bankcardNo="+$("#bankcardNo").val().trim()+"&bankcode="+$("#bankcode").val().trim();
		var bankno=$("#bankcardNo").val();
		var num = /^\d*$/;  //全数字
		if (!num.exec(bankno)) {
			$("#bankcardNoMsg").html("银行卡号必须全为数字");
			return false;
		}
		if (bankno.length < 10 || bankno.length > 30) {
			$("#bankcardNoMsg").html("银行卡号长度必须在10到30之间");
			return false;
		}
		$("#bankcardNoMsg").html("");
	}
	if (realNameCheck()&&cardNoCeck($('#cardNo').val())) {
		
		yeePayBlockMask();
		$.ajax({
			type : "POST",
			url : "../../ssl/payment/toRegister.htm",
			data : data,
			dataType : "json",
			async : false,
			success : function(data) {
				//alert(data.req);
				if (data.register == -1) {
					//用户session失效刷新父页面
					 parent.location.reload();
					//yeePayNoneMask();
				}else if (data.register == 1) {
					$("#cardMsg").html("该身份证已经注册！");
					//yeePayNoneMask();
				} else if (data.register == 2) {
					//易宝已注册，本地没有数据，更新本地数据库
					parent.location.reload();
				} else if (data.register == 3) {
					$("#cardMsg").html("您的身份证信息正在认证中！");
					//yeePayNoneMask();
				} else {
					$("#cardMsg").html("");
					cgtRequestSubmit(data);
					var rq = data.requestNo;
					parent.layer.open({
						type: 2,
						  title: '',
						  shadeClose: false,
						  closeBtn:0,
						  shade: 0.5,
						  area: ['720px', '420px'],
						  move: false,//禁止拖拽
						  content: [projectName + '/ssl/account/toFundCustTanCeng.htm?requestNo='+rq+'&service='+data.serviceName, 'no']
					});
					
				}
			},
			error: function() {
				location.reload();
			}
		});
	}
}
/**
 * 绑定银行卡
 */
function toYeePayBindBank(type) {
	var data="";
//	if(type==1){
		var bankno=$("#bankcardNo").val();
		var mobile=$("#mobile").val();
		var bankcode=$("#bankcode").val();
		if(!bankcode){
			bankcode=bankno.substring(0,6);
		}
		data="mobile="+mobile.trim()+"&bankcardNo="+bankno.trim()+"&bankcode="+bankcode.trim();
		var mobileReg = /^[1][3,4,5,7,8][0-9]{9}$/;  //手机号
		if (!mobileReg.exec(mobile)) {
			$("#mobileMsg").html("手机号格式有误，请修改");
			return false;
		}
		if (mobile.length !=11) {
			$("#mobileMsg").html("手机号长度必须为11位！！");
			return false;
		}
		var num = /^\d*$/;  //全数字
		if (!num.exec(bankno)) {
			$("#bankcardNoMsg").html("银行卡号必须全为数字");
			return false;
		}
		if (bankno.length < 10 || bankno.length > 30) {
			$("#bankcardNoMsg").html("银行卡号长度必须在10到30之间");
			return false;
		}
		$("#bankcardNoMsg").html("");		
//	}
	$.ajax({
		type : "POST",
		url : "../../ssl/payment/toBindBank.htm",
		data:data,
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.bind == 1) {
				parent.location.reload();
			} else {
				$("#serviceName").val(data.serviceName);
				$("#platformNo").val(data.platformNo);
				$("#reqData").val(data.reqData);
				$("#keySerial").val(data.keySerial);
				$("#requestNo").val(data.requestNo);
				$("#sign").val(data.sign);
				var rq = data.requestNo;
				//var index = parent.layer.getFrameIndex(window.name);
				parent.layer.open({
					type: 2,
					  title: '',
					  shadeClose: false,
					  closeBtn:0,
					  shade: 0.5,
					  area: ['720px', '420px'],
					  move: false,//禁止拖拽
					  content: [projectName + '/ssl/account/toBindCardTanCeng.htm?requestNo='+rq+'&service='+data.serviceName, 'no']
				});
				document.yeepay.action = data.action;
				document.yeepay.submit();
				//parent.layer.close(index);
			}
		},
		error: function() {
			location.reload();
		}
	});
}

/**
 * 绑定银行卡
 *//*
function toYeePayBindBank(type) {
	var data="";
	if(type==1){
		data="bankcardNo="+$("#bankcardNo").val().trim()+"&bankcode="+$("#bankcode").val().trim();
		var bankno=$("#bankcardNo").val();
		var num = /^\d*$/;  //全数字
		if (!num.exec(bankno)) {
			$("#bankcardNoMsg").html("银行卡号必须全为数字");
			return false;
		}
		if (bankno.length < 10 || bankno.length > 30) {
			$("#bankcardNoMsg").html("银行卡号长度必须在10到30之间");
			return false;
		}
		$("#bankcardNoMsg").html("");		
	}
	$.ajax({
		type : "POST",
		url : "../../ssl/payment/toBindBank.htm",
		data:data,
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.bind == 1) {
				parent.location.reload();
			} else {
				$("#serviceName").val(data.serviceName);
				$("#platformNo").val(data.platformNo);
				$("#reqData").val(data.reqData);
				$("#keySerial").val(data.keySerial);
				$("#requestNo").val(data.requestNo);
				$("#sign").val(data.sign);
				var rq = data.requestNo;
				//var index = parent.layer.getFrameIndex(window.name);
				parent.layer.open({
					type: 2,
					  title: '',
					  shadeClose: false,
					  closeBtn:0,
					  shade: 0.5,
					  area: ['720px', '420px'],
					  move: false,//禁止拖拽
					  content: [projectName + '/ssl/account/toBindCardTanCeng.htm?requestNo='+rq+'&service='+data.serviceName, 'no']
				});
				document.yeepay.action = data.action;
				document.yeepay.submit();
				//parent.layer.close(index);
			}
		},
		error: function() {
			location.reload();
		}
	});
}*/

/**
 * 取消绑定银行卡
 */
function toYeePayUnBindBank() {
	$.ajax({
		type : "POST",
		url : "../../ssl/payment/toUnbindBank.htm",
		dataType : "json",
		async : false,
		success : function(data) {
			if(data.isExist=="yes"){
				layer.open({
					 type: 1,
					  title: '',
					  shadeClose: false,
					  closeBtn:0,
					  shade: 0.5,
					  area: ['720px', '420px'],
					  move: false,//禁止拖拽
					  content : $('#unbindCard')
				});
				cgtRequestSubmit(data);
			}else if(data.isExist=="illegal"){
				var url = "/ssl/account/changeBindCard.htm";
				title="修改银行卡号";
				checkLogin(url,title);
			}else{
				layer.msg("银行卡已解绑~");
			}
		},
		error: function() {
			location.reload();
		}
	});
}

function yeePayBlockMask() {
	$("#overlay").attr("style", "display:block");
	$("#win").attr("style", "display:block");
}

function yeePayNoneMask() {
	$("#overlay").attr("style", "display:none");
	$("#win").attr("style", "display:none");
}

/**
 * 存管通非免费部份的提现申请
 */
function toCgtFeeWithdraw() {
	//验证文本框合法性  
	var amount = $("#amount").val() ? Number($('#amount').val().replace(/,/gi,'')) : 0;
	var strIsLegalAmount=/^(?=([0-9]{1,12}$|[0-9]{1,10}\.))(0|[1-9][0-9]*)(\.[0-9]{1,2})?$/;    
	var b=strIsLegalAmount.test(amount); 
	if (!b) {
		showLayerTips("输入的金额不合法哦~","amount");
		$("#amount").val("");
		return;
	}
	var isUrgent ="NORMAL";
	if($("#isUrgent").attr("checked")=="checked"){
		isUrgent="URGENT";
	}
	$.ajax({
		type : "POST",
		url : "../../ssl/payment/toWithdraw.htm",
		data : {"amount" : amount,"withdrawType":isUrgent},
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.msg == 1) {
				yeePayBlockMask();
				cgtRequestSubmit(data);
				layer.open({
					  type: 1,
					  title: '',
					  closeBtn:false,
					  shadeClose: false,
					  shade: 0.5,
					  area: ['720px', '350px'],
					  move: false,//禁止拖拽
					  content : $('#win')
				});
			} else if (data.msg == 0) {
				layer.msg('您没有足够的余额进行提现！');
			} else if (data.msg == 2) {
				layer.msg('您没有足够的付费体现余额进行提现！');
			} 
		},
		error: function(XMLHttpRequest) {
			if(XMLHttpRequest.status==415){
			layer.msg("新网银行迁移原因，不允许操作!");
			}else{
				location.reload();
			}
		}
	});
}

/**
 * 提现
 */
function toYeePayWithdraw() {
	if (parseFloat($("#availableAmount").val()) < parseFloat($("#amount").val())) {
		//$("#amountMsg").html("您没有足够的余额进行提现");
		layer.msg('您没有足够的余额进行提现！');
		return false;
	}
	if ($("#totalWithdraw").val() >= 100
			&& parseFloat($("#amount").val()) < 100) {
		//$("#amountMsg").html("您的提现金额不能小于100元");
		layer.msg('您的提现金额不能小于100元');
		return false;
	}
	//打开是否遇到问题窗口
//	layer.open({	
//		title:false,
//		closeBtn:false,
//		type: 2,
//		area: ['600px', '460px'],
//		skin: 'layui-layer-rim', //加上边框
//		content: [getRootPath()+'/ssl/accountWithdrawTanceng.htm', 'no']
//	});
	if (amountCheck()) {
		$("#withdrawMsg").html("");
		$.ajax({
			type : "POST",
			url : "../../ssl/payment/toWithdraw.htm",
			data : "amount=" + $("#amount").val(),
			dataType : "json",
			async : false,
			success : function(data) {
				if (data.msg == 1) {
					yeePayBlockMask();
					//存管通跳转
					cgtRequestSubmit(data);
					layer.open({
						  type: 1,
						  title: '',
						  closeBtn:false,
						  shadeClose: false,
						  shade: 0.5,
						  area: ['720px', '350px'],
						  move: false,//禁止拖拽
						  content : $('#win')
					});
				} else if (data.msg == 0) {
					layer.msg('您没有足够的余额进行提现');
				} else if (data.msg == 2) {
					layer.msg('温馨提示：每日仅可提现1次');
				} else if (data.msg == 3) {//跳转到付费提现页面
					/*$("#feeOverlay").attr("style", "display:block");
					$("#feeWin").attr("style", "display:block");
					$("#applyAmount").text(data.applyAmount);
					$("#feeAmount").text(data.feeAmount);
					$("#platFormFee").text(data.platFormFee);*/
					layer.msg('您的提现金额超过免费提现金额！');
				}
			},
			error: function() {
				location.reload();
			}
		});
	}
}

/**
 * 充值
 */
function toYeePayRecharge() {
	if (amountCheck()) {
		var bankCode = $("#bankNext").attr('data');
		if($("#userType").val() == 2){
			if(bankCode == '' || bankCode == null){
				layer.msg('请先选择银行！');
				return false;
			}
		}
		var Paymentchannelidentify = $("input[name='paymentChannelName']:checked").val();
		if(Paymentchannelidentify==null){
			Paymentchannelidentify = "";
        }
		
		$.ajax({
			type : "POST",
			url : "../payment/toRecharge.htm",
			data : {"amount" : $("#amount").val(),"rechargeWay":$('#rechargeWay').val(),"paymentChannelName":Paymentchannelidentify,"bankCode":bankCode},
			dataType : "json",
			async : false,
			success : function(data) {
				if(data.errorCode > 0){
					layer.msg(data.errorMsg);
					return false;
				}
				layer.open({
					  type: 1,
					  title: '',
					  closeBtn:false,
					  shadeClose: false,
					  shade: 0.5,
					  area: ['720px', '350px'],
					  move: false,//禁止拖拽
					  content : $('#win')
				}); 
				
				cgtRequestSubmit(data);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				console.log(XMLHttpRequest.status);
				console.log(XMLHttpRequest.readyState);
				console.log(textStatus);
			}
		});
	}
}

function quickQueryCust(evt) {
	evt = (evt) ? evt : ((window.event) ? window.event : "") // 兼容IE和Firefox获得keyBoardEvent对象
	var key = evt.keyCode ? evt.keyCode : evt.which; // 兼容IE和Firefox获得keyBoardEvent对象的键值
	if (key == 13) {
		var btn = $("#toYeepay");
		btn.focus();
		btn.click();
		// toYeePayTransfer();
		// 判断是否是回车事件。
	}
}

/**
 * 出借
 */
function toYeePayTransfer() {
	if (paymentAmountCheck()) {
		$.ajax({
			type : "POST",
			url : "../invest/isOpenRepay.htm",
			dataType : "json",
			async : false,
			success : function(data) {
				if (data.msg ==2){
					//其他方式实现 -- 乔海锋
					layer.open({
						  type: 2,
						  title: '',
						  shadeClose: true,
						  shade: 0.5,
						  area: ['447px', '452px'],
						  content: '${request.contextPath}/toLogin.htm'
					});
					
				}else{
					//提示开通银行存管账户公共弹层
					if (data.msg == 0) {
						layer.open({
							type: 2,
							title: false,
							area: ['678px', '380px'],
							content: [getRootPath()+'/ssl/account/toFundCustTanCengCommon.htm', 'no']
						}); 
						return false;
					} else {
						var bidMoney=$("#bidMoney").val().replace(/,/gi,'');
						$("#paymentAmount").val(bidMoney);
						$.ajax({
							type : "POST",
							url : "../ssl/payment/toTransfer.htm",
							data : {
								orderNo : $('#orderNo').val(),
								paymentAmount : bidMoney,
								voucherId : $('#voucherId').val(),
								bidPassword : $('#bidPassword').val(),
								appModel : $('#appModel').val()
							},
							dataType : "json",
							async : false,
							success : function(data) {
								if (data.msg == 1 || data.msg == -1 || data.msg == 0 ) {
									yeePayBlockMask();
									document.getElementById("overlay").style.display = 'block';
									document.getElementById("win").style.display = 'block';
									layer.open({
										  type: 1,
										  title: '',
										  closeBtn:0,
										  shadeClose: false,
										  shade: 0.5,
										  area: ['720px', '350px'],
										  move: false,//禁止拖拽
										  content : $('#win')
									}); 
									cgtRequestSubmit(data);
								} else if (data.msg == 2) {
									layer.msg('您没有足够的余额进行出借！');
								} else if (data.msg == 3) {
									layer.msg('您下手晚了,已经满标了！');
								} else if (data.msg == 4) {
									var sumBidAmount = parseFloat($(
											"#maxBidAmount").val())
											- parseFloat(data.amount);
									$("#paymentAmount").val(data.amount);
									layer.msg("您已经出借的金额是"
											+ fmoney(sumBidAmount)
											+ "元");
								} else if (data.msg == 5) {
									layer.msg('抱歉你出借的金额已经超出最大出借额，敬请期待下期！');
								} else if (data.msg == 6) {
									layer.msg('出借密码错误，请重新输入！');
								} else if (data.msg == 7) {
									layer.msg('卡券已使用,请刷新页面重新选择！');
								}else if (data.msg == 8) {
									layer.msg('新手标仅限新手首次出借使用！');
									//禁用出借按钮
									$('#bid').css('background-color','#ccc');
									$('#bid').attr('disabled',"true");
									$('#bid').css('cursor',"not-allowed");
								} else if (data.msg == 9) {
									layer.msg('出借金额超限，无法使用卡券！');
								} else if (data.msg == 10) {
									layer.msg('企业用户不可投标！');
								}
							},
							error: function() {
								location.reload();
							}
						});
					}
				}
			},
			error: function() {
				location.reload();
			}
		});
	}
}

/**
 * 易宝企业注册(开通银行存管账户)
 */
function toYeePayEntRegister() {
	yeePayBlockMask();
	$.ajax({
		type : "POST",
		url : "../../ssl/payment/toEntRegister.htm",
		dataType : "json",
		async : false,
		success : function(data) {
			$("#req").val(data.req);
			$("#sign").val(data.sign);
			document.yeepay.action = data.action;
			document.yeepay.submit();
		},
		error: function() {
			location.reload();
		}
	});
}


function yeepayQuery(type) {
	var service = $("#service").val();
	$.ajax({
		type : "POST",
		url : projectName + "/ssl/payment/query.htm",
		data : "requestNo=" + $("#requestNo").val() + "&service=" + service,
		dataType : "json",
		async : false,
		success : function(data) {
			var content;
			var msg = data.msg;
			if(service=="PERSONAL_REGISTER_EXPAND"
				||service=="ENTERPRISE_REGISTER"
				||service=="PERSONAL_BIND_BANKCARD_EXPAND"
				||service=="ENTERPRISE_BIND_BANKCARD"){
				content="请您重新认证或绑卡或者致电客服4008989189进行咨询";
				if(msg==0&&type==1){
					layer.msg(content,function(){
						parent.location.reload();
					});
				}else{
					parent.location.reload();
				}
			}else if(service=="RECHARGE"){
				content="请您重新充值或者致电客服4008989189进行咨询";
				if(msg==0&&type==1){
					layer.msg(content,function(){
						location.reload();
					});
				}else{
					location.reload();
				}
			}else if(service=="WITHDRAW"){
				content="请您重新提现或者致电客服4008989189进行咨询";
				if(msg==0&&type==1){
					layer.msg(content,function(){
						location.reload();
					});
				}else{
					location.reload();
				}
			}else if(service=="USER_PRE_TRANSACTION"){
				content="请您重新购买或者致电客服4008989189进行咨询";
				if(msg==0&&type==1){
					layer.msg(content,function(){
						location.reload();
					});
				}else{
					location.reload();
				}
			}else if(service=="MODIFY_MOBILE_EXPAND"){
				content="请您重新修改或者致电客服4008989189进行咨询";
				if(msg==0&&type==1){
					layer.msg(content,function(){
						parent.location.reload();
					});
				}else{
					parent.location.reload();
				}
			}else if(service=="USER_AUTHORIZATION"){
				content="请您重新开通或者致电客服4008989189进行咨询";
				if(msg==0&&type==1){
					layer.msg(content,function(){
						location.reload();
					});
				}else{
					location.reload();
				}
			}
		}
	});
}
/**
 * 开通自动还款授权
 */
function toAuthAutoRepay(loanId) {
	yeePayBlockMask();
	$.ajax({
		type : "POST",
		url : "../../ssl/payment/toAuthAutoRepay.htm",
		data : "loanId=" + loanId,
		dataType : "json",
		async : false,
		success : function(data) {
			$("#req").val(data.req);
			$("#sign").val(data.sign);
			document.yeepay.action = data.action;
			document.yeepay.submit();
		},
		error: function() {
			location.reload();
		}
	});
}

/**
 * 债权转让
 */
function toClaimTransfer() {
	//激活用户弹窗
	if(notActive=="yes"){
		layer.open({
				type: 2,
				title: false,
				area: ['678px', '380px'],
				content: ['${ctxPath}/ssl/account/toActiveUserTanceng.htm', 'no']
			}); 
		$("#yeepay1").show();
	}else{
		$.ajax({
			type : "POST",
			url : "../ssl/payment/toClaimTransaction.htm",
			data : "claimId=" + $("#claimId").val(),
			dataType : "json",
			async : false,
			success : function(data) {
				if (data.msg == 0) {
					yeePayBlockMask();
					cgtRequestSubmit(data);
					//打开是否遇到问题窗口
					$("#requestNo").val(data.requestNo);
	//				var index = parent.layer.getFrameIndex(window.name);
					layer.open({
						  type: 1,
						  title: '',
						  closeBtn:false,
						  shadeClose: false,
						  shade: 0.5,
						  area: ['720px', '350px'],
						  move: false,//禁止拖拽
						  content : $('#win')
					});
				} else if (data.msg == -3) {
	//				$("#paymentMsg").html("您没有足够的余额进行出借!");
					layer.msg('您没有足够的余额进行出借！');
				} else if (data.msg == -4) {
	//				$("#paymentMsg").html("您不能购买该债权!");
					layer.msg('您不能购买该债权！');
				}else if (data.msg == -5){
					layer.msg('债权出让失败,不能购买！');
				} else {
	//				$("#paymentMsg").html("购买该债权失败!");
					layer.msg('购买该债权失败！');
				}
			},
			error: function() {
				location.reload();
			}
		});
	}
}

//易宝充值查询
function yeepayQueryRecharge(){
	var service = $("#service").val();
	$.ajax({
		type : "POST",
		url : getRootPath()+"/ssl/payment/query.htm",
		data : "requestNo=" + $("#requestNo").val() + "&service=" + $("#service").val(),
		dataType : "json",
		async : false,
		success : function(data) {
			if (service == "RECHARGE") {
				if (data && data.msg == 1) {
					//layer.alert('充值成功!',function(){
						location.href=getRootPath()+"/ssl/account/toMoney.htm";
					//});
				} else {
					//layer.alert("充值失败！",function(){
						location.reload();
					//});
				}
			}
		},
		error: function() {
			location.reload();
		}
	});
}

//易宝提现查询
function yeepayQueryWithdraw(){
	var service = $("#service").val();
	$.ajax({
		type : "POST",
		url : getRootPath()+"/ssl/payment/query.htm",
		data : "requestNo=" + $("#requestNo").val() + "&service=" + $("#service").val(),
		dataType : "json",
		async : false,
		success : function(data) {
			if (service == "WITHDRAW") {
				if (data && data.msg == 1) {
					//layer.alert('提现成功!',function(){
						location.href=getRootPath()+"/ssl/account/toMoney.htm";
					//});
				} else {
					//layer.alert("提现失败！",function(){
						location.reload();
					//});
				}
			}
		},
		error: function() {
			location.reload();
		}
	});
}


//格式化充值金额，添加两位小数
function formMoney(){
	var amount = $("#amount").val() ? Number($("#amount").val().replace(',','')) : 0;
	if(amount){
		$('#amount').val(fmoney(amount,2));
	}else{
		$('#amount').val('10,000.00');
	
	}
}
/**
 * 自动投标存管通网关跳转
 */
function toAuthAutoTransfer(){
	$.ajax({
		type : "POST",
		url : getRootPath()+"/ssl/payment/toAuthAutoTransfer.htm",
		dataType : "json",
		async : false,
		success : function(data) {
			parent.layer.open({
				  type: 1,
				  title: '',
				  closeBtn:false,
				  shadeClose: false,
				  shade: 0.5,
				  area: ['720px', '375px'],
				  move: false,//禁止拖拽
				  content : $('#win',window.parent.document)
			}); 
			$("#requestNo",window.parent.document).val(data.requestNo);
			$("#service",window.parent.document).val(data.serviceName);
			cgtRequestSubmit(data);
		},
		error: function() {
			location.reload();
		}
	});
}
function activeUserStatusQuery(){
	$.ajax({
		type : "POST",
		url : projectName+"/query/activeUserStatus.htm",
		dataType : "json",
		async : false,
		success : function(data) {
			location.reload();
		},
		error: function() {
			location.reload();
		}
	});
}
/**
 * 存管通网关请求数据装配提交
 * @param data
 */
function cgtRequestSubmit(data){
	$("#serviceName").val(data.serviceName);
	$("#service").val(data.serviceName);
	$("#platformNo").val(data.platformNo);
	$("#reqData").val(data.reqData);
	$("#keySerial").val(data.keySerial);
	$("#requestNo").val(data.requestNo);
	$("#sign").val(data.sign);
	document.yeepay.action = data.action;
	document.yeepay.submit();
}

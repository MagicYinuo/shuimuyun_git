<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type = request.getParameter("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
	<link rel="stylesheet" href="<%=basePath %>APP/css/layer.css" />
	<link rel="stylesheet" href="<%=basePath %>APP/css/smyMobile.css" />
		<style>
			.paymentTop {
				width: 100%;
				height: 0.4rem;
				background: rgb(255,255,255);
				box-sizing: border-box;
				padding: 0 20px;
				margin-top: 0.5rem;
			}
			.paymentTop_l {
				width: 0.8rem;
				height: 0.4rem;
				line-height: 0.4rem;
				color: #999;
				font-size: 0.15rem;
				float: left;
			}
			.paymentTop input {
				display: block;
				width: calc(100% - 0.8rem);
				height: 0.4rem;
				line-height: 0.4rem;
				color: #333;
				font-size: 0.15rem;
				border: 0;
				outline: none;
				background: none;
				float: right;
			}
			.paymentList {
				position: relative;
				overflow: hidden;
				width: 100%;
				height: 1.2rem;
				background: rgb(255,255,255);
				font-size: 0.12rem;
				margin-top: 0.1rem;
				margin-left: 0;
			}
			.paymentList_item {
				position: relative;
				width: 100%;
				height: 0.4rem;
				overflow: hidden;
				line-height: 0.4rem;
				color: #666;
				font-size: 0.15rem;
				border-bottom: 1px solid #eee;
				box-sizing: border-box;
				padding: 0 20px;
			}
			.paymentList_item img {
				vertical-align: middle;
				margin-right: 12px;
				vertical-align: middle;
			}
			.paymentList_position {
				position: absolute;
				top: 50%;
				right: 20px;
				width: 14px;
				height: 14px;
				text-align: center;
				line-height: 12px;
				border-radius: 50%;
				border: 1px solid #afafaf;
				background: rgb(255,255,255);
				margin-top: -7px;
			}
			.paymentList_position span {
				display: none;
				width: 10px;
				height: 10px;
				background: rgb(51,51,51);
				border-radius: 50%;
				margin: 2px;
			}
			.paymentBtn {
				display: block;
				width: 80%;
				height: 0.34rem;
				color: #fff;
				font-size: 0.15rem;
				text-align: center;
				line-height: 0.34rem;
				border: none;
				outline: none;
				border-radius: 5px;
				background: rgb(65,139,230);
				margin: 0 auto;
				margin-top: 0.7rem;
			}
			.paymentBtn:active {
				opacity: 0.8;
			}
			.payTipts {
				position: absolute;
				top: 50%;
				left: 50%;
				width: 1.2rem;
				height: 0.3rem;
				color: #fff;
				font-size: 0.13rem;
				text-align: center;
				line-height: 0.3rem;
				background: rgba(0,0,0,.6);
				border-radius: 5px;
				transform: translate(0,-0.2rem);
				margin-left: -0.6rem;
				margin-top: -0.15rem;
				z-index: 999;
			}
			.payTipts_act {
				transition: .8s;
				transform: translate(0,0);
			}
			.balModal {
				display: none;
				position: fixed;
				top: 0;
				left: 0;
				bottom: 0;
				right: 0;
				width: 100%;
				height: 100%;
				background: rgba(0,0,0,0.8);
			}
			.balModal_po {
				position: relative;
				width: 100%;
				height: 100%;
			}
			.balModal_cont {
				display: none;
				position: absolute;
				left: 0;
				right: 0;
				bottom: 0;
				width: 100%;
				height: auto;
				overflow: hidden;
				background: rgb(255,255,255);
			}
			.balModal_contNumer {
				width: 100%;
				height: auto;
				overflow: hidden;
				border-top: 1px solid #eee;
			}
			.balModal_contNumer a {
				display: block;
				width: 33.3333%;
				height: 40px;
				color: #333;
				text-decoration: none;
				font-size: 16px;
				font-style: italic;
				line-height: 40px;
				text-align: center;
				box-sizing: border-box;
				border: #eee solid 1px;
				border-top: 0;
				border-left: 0;
				float: left;
			}
			.balModal_contNumer a:nth-of-type(10),
			.balModal_contNumer a:nth-of-type(12) {
				background: rgb(238,238,238);
			}
			.balModal_contNumer a img {
				display: inline-block;
				vertical-align: middle;
				margin-top: 12px;
			}
			.balModal_title {
				position: relative;
				width: 100%;
				height: 38px;
				text-align: center;
				line-height: 38px;
				font-size: 15px;
				color: #333;
			}
			.balModal_title:before {
				position: absolute;
				top: 50%;
				right: 20px;
				width: 18px;
				height: 18px;
				content: "";
				background: url(<%=basePath %>APP/images/icon/payClose.png) no-repeat;
				background-size: cover;
				margin-top: -9px;
			}
			.balModal_contPwd {
				width: calc(100% - 40px);
				height: 40px;
				overflow: hidden;
				border: #999 solid 1px;
				border-radius: 5px;
				margin: 10px auto;
			}
			.balModal_contPwd input {
				display: block;
				width: 16.6666%;
				height: 40px;
				color: #333;
				font-size: 13px;
				text-align: center;
				line-height: 40px;
				outline: none;
				background: none;
				border: 0;
				box-sizing: border-box;
				border-right: 1px solid #999;
				float: left;
			}
			.balModal_contPwd .bg {
				background: url(<%=basePath %>APP/images/icon/pasword.png) no-repeat center;
				background-size:22% ;
			}
			.balModal_contPwd>input:last-child {
				border: none;
			}
			.balModal_contLink {
				display: block;
				width: 70px;
				height: 20px;
				color: #1789d5;
				text-align: right;
				text-decoration: none;
				font-size: 12px;
				float: right;
				margin-right: 20px;
				margin-bottom: 6px;
			}
			.balModal_contBal {
				position: relative;
				width: 100%;
				height: 40px;
				color: #333;
				font-size: 15px;
				text-indent: 50px;
				line-height: 40px;
			}
			.balModal_contBal:before {
				position: absolute;
				top: 50%;
				left: 20px;
				width: 18px;
				height: 18px;
				content: "";
				background: url(<%=basePath %>APP/images/icon/balance.png) no-repeat;
				background-size: cover;
				margin-top: -10px;
			}
			.balModal_contBal span {
				color: #999;
				font-size: 12px;
				margin-left: 2px;
			}
			.balModal_contBal span i {
				margin-right: 4px;
			}
			
			
			
			.jzCont {
				position: fixed;
				top: 50%;
				left: 50%;
				width: 60px;
				height: 60px;
				background: rgba(0,0,0,.8);
				border-radius: 5px;
				margin-top: -30px;
				margin-left: -30px;
			}
			.jzCont span {
				display: block;
				width: 20px;
				height: 20px;
				background: url(<%=basePath %>APP/images/icon/loading.gif) no-repeat;
				background-size: cover;
				margin: 20px auto;
			}
		</style>
	</head>
	<body>
		<!--【头部】-->
		<header class="commHeader">
			<a class="commHeader_l" onClick="javascript :history.back(-1);">
				<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
			</a>
			<p>充值</p>
		</header>
		<!--【头部】end-->
		
			
		<%String type1 = request.getParameter("type");  
		  if("2".equals(type1)){
		%>
		<div class="paymentTop">
			<div class="paymentTop_l">充值金额：</div>
			<span class="paymentTop_l" id="shopprices" >200</span>
		</div>
		<%}else{%>
		<div class="paymentTop">
			<div class="paymentTop_l">充值金额：</div>
			<input type="text"  name="shopprices" id="shopprices" value=""/>
		</div>
		<%}%>
		<input type="hidden" name="kuaikeId" id="kuaikeId" value="${login.kuaikeId }">
		<div class="paymentList">
			
			<div class="paymentList_item">
				<img title="" alt="" src="<%=basePath %>APP/images/icon/payment.png" width="25" /> 支付宝
				<div class="paymentList_position" id="paymentSelect">
					<span></span>
				</div>
			</div>
			<div class="paymentList_item">
				<img title="" alt="" src="<%=basePath %>APP/images/icon/wx.png" width="25" /> 微信
				<div class="paymentList_position" id="wxSelect">
					<span></span>
				</div>
			</div>
			<div class="paymentList_item">
				<img title="" alt="" src="<%=basePath %>APP/images/icon/wx.png" width="25" /> 微信二维码
				<div class="paymentList_position" id="wxQrcode">
					<span></span>
				</div>
			</div>
		</div>
		
		<div>
				<samp class="sam"></samp>
				<input type="hidden" name="shopprices" value="0.01">
				<input type="hidden" name="xiaId" value="123456">
				<input type="hidden" name="shopName" value="test">
			</div>
		<input class="paymentBtn" id="paymentBtn" type="button" href="" value="立即支付" /> 
<!-- 		<a class="paymentBtn" id="paymentBtn" href="RequestMappingUtil/requestNUll/APP/payOk">立即付款</a> -->
		
		<!--【余额支付弹窗】-->
		<div class="balModal">
			<div class="balModal_po">
				<div class="balModal_cont">
					<div class="balModal_title">请输入密码</div>
					<div class="balModal_contBal">
						账户余额
						<span>可用余额：<i id="balance"></i>元</span>
					</div>
					<div class="balModal_contPwd">
						<input type="password" value="">
						<input type="password" value="">
						<input type="password" value="">
						<input type="password" value="">
						<input type="password" value="">
						<input type="password" value="">
					</div>
					<a class="balModal_contLink" href="#">忘记密码？</a>
					<div class="balModal_contNumer">
						<a class="num" href="javascript:;">1</a>
						<a class="num" href="javascript:;">2</a>
						<a class="num" href="javascript:;">3</a>
						<a class="num" href="javascript:;">4</a>
						<a class="num" href="javascript:;">5</a>
						<a class="num" href="javascript:;">6</a>
						<a class="num" href="javascript:;">7</a>
						<a class="num" href="javascript:;">8</a>
						<a class="num" href="javascript:;">9</a>
						<a href="javascript:;"></a>
						<a class="num" href="javascript:;">0</a>
						<a id="payDel" href="javascript:;">
							<img title="" alt="" src="<%=basePath %>APP/images/icon/payDel.png" width="22"/>
						</a>
					</div>
				</div>
			</div>
		</div>
		<!--【余额支付弹窗】end-->
		
		<script type="text/javascript" src="<%=basePath %>APP/js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="<%=basePath %>APP/js/layer.js" ></script>
		<script type="text/javascript" src="<%=basePath %>APP/js/smyMobile.js" ></script>
		<script>
			$(function() {
				$(".paymentList_position").click(function() {
					if($(this).find("span").is(":hidden")) {
						$(this).find("span").css("display","block");
						$(this).parent().siblings().find("span").css("display","none");
					}
					else {
						$(this).find("span").css("display","none");
						//$(this).hide().parent().siblings().find(".paymentList_position span").hide();
					}
				})
				
				$("#paymentBtn").click(function() {
					var shopprices="";
					var type=<%=type%>;
					if(type==2){
						var shopprices=200;
					}else{
						var shopprices=$("#shopprices").val();
					}
					var kuaikeId='${login.kuaikeId }';
						if ($("#balaceSelect span").is(":hidden") && $("#paymentSelect span").is(":hidden") && $("#wxSelect span").is(":hidden")) {
	
							layer.open({
								content : '请选择支付方式',
								skin : 'msg',
								time : 2
							});
							return false;
	
						}  else if (!($("#paymentSelect span").is(":hidden"))) {
							if(shopprices>0){
								layer.open({
									content : '支付宝支付',
									skin : 'msg',
									time : 2
								});
							}else{
								alert("请输入正确的金额");
							}
						} else if (!($("#wxSelect span").is(":hidden"))) {
							if(shopprices>0){
								layer.open({
									content : '微信支付',
									skin : 'msg',
									time : 2
								});
							}else{
								alert("请输入正确的金额");
							}						
						} else if (!($("#wxQrcode span").is(":hidden"))) {
// 							layer.open({
// 								content : '微信二维码支付',
// 								skin : 'msg',
// 								time : 2
// 							});
							if(shopprices>0){
								window.location.href="RequestMappingUtil/requestNUll/APP/qrrecharge?kuaikeId="+kuaikeId+"&shopprices="+shopprices+"&type="+type;
							}else{
								alert("请输入正确的金额");
							}
						
						}
					
			
	
				})
				
				
				
			})
		</script>
		<script type="text/javascript">
		if("${login}"==""||"${login}"==null){
		//询问框
		layer.open( {
				anim: 'up',
				shadeClose: false,
				content: '您还没有登陆？',
				btn: ['登录', '注册'],
				yes:function(index){
					layer.close(index);
			  		window.location.href="RequestMappingUtil/requestNUll/APP/login";
				},
				no:function(index){
					layer.close(index);
					window.location.href="RequestMappingUtil/requestNUll/APP/register";
				}  
			});
		}else{
			if("${login.kuaikePhone}"==""||"${login.kuaikeAddressInfo}"==""||"${login.kuaikeShenfenZF}"==""||"${login.kuaikeShouchiSFZ}"==""){
				//验证审核
				if("${login.kuaikeStatus}"==0){
					//提示
				    layer.open({
				    	content: '您的身份还没有通过审核！',
				    	skin: 'msg',
				    	time: 2
				  	});
				}else{
					//询问框
					layer.open( {
						anim: 'up',
						shadeClose: false,
						content: '您的资料还没有完善？',
						btn: ['完善资料','取消'],
						yes:function(index){
							layer.close(index);
							window.location.href="RequestMappingUtil/requestNUll/APP/perfectData_firstStep";
						},
						no:function(index){
							layer.close(index);
						}  
					});
				}
			}
		}
		</script>
		
		
		
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的钱包</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>APP/css/smyMobile.css" />
		<style>
			.wallettop {
				position: relative;
				width: 100%;
				height: 0.2rem;
				color: #999;
				font-size: 0.1rem;
				text-indent: 20px;
				line-height: 0.2rem;
			}
			.wallettop img {
				position: absolute;
				top: 50%;
				right: 20px;
				margin-top: -7px;
			}
			.walletCont {
				width: 100%;
				height: auto;
				overflow: hidden;
				background: rgb(255,255,255);
				padding: 0.1rem 0;
			}
			.walletCont_item {
				width: 50%;
				height: auto;
				overflow: hidden;
				box-sizing: border-box;
				float: left;
				padding-top: 0.04rem;
			}
			.walletCont_item:first-child {
				border-right: 1px solid #eee;
			}
			.walletCont_item_title {
				position: relative;
				width: 100%;
				height: 0.34rem;
				color: #333;
				font-size: 0.12rem;
				line-height: 0.34rem;
				text-indent: 0.4rem;
			}
			.walletCont_item_title:before {
				position: absolute;
				top: 50%;
				left: 20px;
				content: '';
				width: 20px;
				height: 20px;
				background: url(<%=basePath%>APP/images/icon/balance.png) no-repeat;
				background-size: cover;
				margin-top: -12px;
			}
			.walletCont_item_cont {
				width: 100%;
				height: auto;
				font-size: 0.18rem;
				font-weight: 700;
				color: #418bc8;
				text-align: center;
			}
			.walletBtn {
				display: block;
				width: 80%;
				height: 0.24rem;
				border: none;
				outline: none;
				background: rgb(65,139,200);
				border-radius: 5px;
				color: #fff;
				font-size: 0.11rem;
				margin: 0 auto;
				margin-bottom: 0.08rem;
			}
			.walletBtn:active {
				opacity: 0.8;
			}
			.walletBtn:nth-of-type(2) {
				background: #77c841;
			}
			.walletYj {
				margin-top: 0.12rem;
			}
		</style>
	</head>
	<body>
		<header class="commHeader">
			<a class="commHeader_l" href="javascript:self.location=document.referrer;">
				<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
			</a>
			<p>我的钱包</p>
			<a class="commHeader_r" href="javascript:void(0);">
				<p class="commHeader_r_font">银行卡</p>
			</a>
		</header>
		
		<div class="wallettop">
			押金200以上每周三可提现
			<img title="" alt="" src="<%=basePath%>APP/images/icon/wallettop.png" height="14" />
		</div>
		
		<div class="walletCont">
			<div class="walletCont_item">
				<div class="walletCont_item_title">账号余额（元</div>
				<div class="walletCont_item_cont"><i>￥200</i></div>
			</div>
			<div class="walletCont_item">
				<button class="walletBtn">提现</button>
				<button class="walletBtn">充值</button>
			</div>
		</div>
		
		<div class="walletCont walletYj">
			<div class="walletCont_item">
				<div class="walletCont_item_title">我的押金（元</div>
				<div class="walletCont_item_cont"><i>￥200</i></div>
			</div>
			<div class="walletCont_item">
				<button class="walletBtn">提现</button>
				<button class="walletBtn">充值</button>
			</div>
		</div>
		
		<script type="text/javascript" src="<%=basePath%>APP/js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile.js" ></script>
		<script>
			$(function() {
				$(".wallettop img").on("click",function() {
					$(this).parent().hide();
				})
			})
		</script>
	</body>
</html>
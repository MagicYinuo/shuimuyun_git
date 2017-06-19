<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>抢单流程</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>APP/css/mui.min.css" />
	<link rel="stylesheet" href="<%=basePath%>APP/css/layer.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>APP/css/smyMobile.css" />
	<link rel="stylesheet" href="<%=basePath%>APP/css/IMGUP.css" />
	<style type="text/css">
		body{display: block;}
		.l{
			margin-top:.4rem;
			height:.4rem;
			line-height:.4rem;
			padding-left:.20rem;
		}
		.dom_shouhuo_ldiv div{
			height:.3rem;
		}
	</style>
	</head>
	<body>
		<!--【头部】-->
		<header class="commHeader">
			<a class="commHeader_l" onClick="javascript :history.back(-1);">
				<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
			</a>
			<p>上门取货</p>
		</header>
		<!--【头部】end-->
		
		<!-- 抢单状态   start -->
			<div  class="dom_shouhuo_ldiv l">
				${info.status==1?'已抢单,未取货':''}
				${info.status==2?'已取货,未送达':'' }
				${info.status==3?'已到达,未确认':'' } 
			</div>
		<!-- 抢单状态  end -->
		
		<div class="dom_shouhuo">
			<div class="dom_shouhuo_fdiv">
				收货人信息
			</div>
			<div class="dom_shouhuo_ldiv">
				<div class="ldiv_ren">
					<span>收货人：</span>
					<span>${info.shouhuoName }</span>
				</div>
				<div class="ldiv_phone">
					<img src="<%=basePath%>APP/images/icon/courphone.png" width="15" />
					<span>${info.shouhuoShone }</span>
				</div>
				<div class="ldiv_adds">
					<img src="<%=basePath%>APP/images/icon/adds_oreng.png" width="15" />
					<span>${info.shouhuoAddressInfo }</span>
				</div>
			</div>
		</div>
		<div class="dom_shouhuo">
			<div class="dom_shouhuo_fdiv">
				发货人信息
			</div>
			<div class="dom_shouhuo_ldiv">
				<div class="ldiv_ren">
					<span>发货人：</span>
					<span>${info.kuaikeName }</span>
				</div>
				<div class="ldiv_phone">
					<img src="<%=basePath%>APP/images/icon/courphone.png" width="15" />
					<span>${info.kuaikePhone }</span>
				</div>
				<div class="ldiv_adds">
					<img src="<%=basePath%>APP/images/icon/adds_oreng.png" width="15" />
					<span>${info.kuaikeAddressInfo  }</span>
				</div>
			</div>
		</div>
		<div class="dom_shouhuo_fdiv">
			货物信息
		</div>
		<div class="courier_last_con taking_last_con">
			<div class="courier_last_con_list">
				<div>
					<span>类型</span>
					<span>数量</span>
					<span>大小</span>
					<span>总重</span>
					<span>建议交通工具</span>
				</div>
				<div>
					<span>${info.shopType }</span>
					<span>${info.shopNumer }</span>
					<span>${info.shopGuige }</span>
					<span>${info.shopzholiang}kg</span>
					<span>无</span>
				</div>
			</div>
		</div>
		<!--上传图片-->
		<div class="shang_img">		
			
			<c:if test="${info.status==1 }" >
				<!-- 图片预览容器 -->
				<!-- <div id="div_imglook">
					<div style="clear: both;"></div>
				</div>
				图片选择对话框
				<div id="div_imgfile">上传货物照片</div> -->
				<!--确定上传按钮<input type="button" value="确定上传"  />-->
				
				<!-- 确定取货 -->
				<div class="order_buttom">
					<a href="xiaordertab/updateXiaQiangStatus/${info.xiaId}/${info.status}/${login.kuaikeId}"><button id="btn_ImgUpStart" class="order_btn">确定取货</button></a>
				</div>
			</c:if>
			
			<c:if test="${info.status==2 }">
				<!--如果有图片存放img的div-->
				<div></div>
				<a href="RequestMappingUtil/requestNUll/APP/showCode"><button class="order_btn">到达目的地</button></a>
			</c:if>
			
			<c:if test="${info.status==3 }">
				<!-- 如果有图片存放img的div -->
				<div></div>
				<button class="order_btn">评价</button>
			</c:if>
		</div>
		<script type="text/javascript" src="<%=basePath%>APP/js/jquery-1.7.2.min.js" ></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/mui.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/layer.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile_yz.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile_click.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/IMGUP.js" ></script>

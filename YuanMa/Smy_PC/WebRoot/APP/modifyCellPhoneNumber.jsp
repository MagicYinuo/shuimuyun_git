<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改手机号码</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>APP/css/mui.min.css" />
	<link rel="stylesheet" href="<%=basePath%>APP/css/layer.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>APP/css/smyMobile.css" />
	</head>
	<style type="text/css">
		.cell_firstdiv{
			margin-top: .1rem;
		}
	</style>
	<body>
		<!--【头部】-->
		<header class="commHeader">
			<a class="commHeader_l" href="javascript:self.location=document.referrer;">
				<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
			</a>
			<p>修改手机号</p>
		</header>
		<form>

		<div class="appeal_firstdiv" style="margin-top: 0.4rem">
			<div>
				<label>当前手机号</label><input type="text" id="lastPhone" placeholder="请输入原绑定手机号" />			</div>
			
			<div>
				<label>现用手机号</label><input type="text" id="regPhone" placeholder="请输入现用手机号" />			</div>
			<div>
				<label>验 证 码</label>
				<input class="las" style="width:1.4rem" id="cellyzm" type="text" placeholder="请输入验证码" />
				<button id="cellyzmbtn">获取验证码</button>
			</div>
			<div>
				<label>当前手机号</label><input type="text" id="pwd" placeholder="请输入登录密码" />			</div>
		</div>
		<button class="order_btn" id="cellbtn">确定</button>
		</form>
		<script type="text/javascript" src="<%=basePath%>APP/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/mui.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/layer.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile_yz.js" ></script>
		<script type="text/javascript">
			//修改手机号
	$("#cellbtn").click(function(){
		var celllastPhone = $("#celllastPhone").val();
		var cellPhone = $("#cellPhone").val();
		var cellyzm = $("#cellzm").val();
		var cellpwd = $("#cellpwd").val();
		var reg=/^[\u2E80-\u9FFF]+$/;
		if(!(celllastPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(celllastPhone))) {
			//提示
		    layer.open({
		    	content: '曾用手机号错误',
		    	skin: 'msg',
		    	time: 2
		  	});
			return false;
		}
		else if(!(cellPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(cellPhone))) {
			//提示
		    layer.open({
		    	content: '现用手机号错误',
		    	skin: 'msg',
		    	time: 2
		  	});
			return false;
		}
		else if(cellyzm == "") {
			//提示
		    layer.open({
		    	content: '请填写验证码',
		    	skin: 'msg',
		    	time: 2
		  	});
			return false;
		}else if(cellpwd == "") {
			//提示
		    layer.open({
		    	content: '请输入密码',
		    	skin: 'msg',
		    	time: 2
		  	});
			return false;
		}
	})
	$("#cellyzmbtn").click(function() {
	var cellPhone = $("#cellPhone").val();
		if(!(cellPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(cellPhone))) {
			//提示
		    layer.open({
		    	content: '现用手机号错误',
		    	skin: 'msg',
		    	time: 2
		  	});
			return false;
		}else{
			time(this);
		}
	})
			
		</script>
	</body>
</html>

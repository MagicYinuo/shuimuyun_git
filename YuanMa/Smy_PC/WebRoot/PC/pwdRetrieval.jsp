<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" cotent="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<title>找回密码</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>PC/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>PC/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>PC/css/index.css" />
<script src="<%=basePath%>PC/js/jquery-3.1.0.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>PC/js/zhaohuimima.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	/*通过手机号码找回密码    手机接收验证码对密码进行修改【快捷找回密码】*/
	$(function() {
		$("#ajaxPhone").click(function() {
			//得到验证码的文本值
			var mobile_code = $("#yanpwd").val();
			var kuaikePhone=$("#phone").val();
			//发送Ajax请求得到验证码
			$.ajax({
				url : 'getCode/'+kuaikePhone,
				type : 'post',
				async : false,
				data : {
					mobile_code : mobile_code
				},
				//请求成功后触发
				success : function(data) {
					//为验证码文本框进行赋值
					$("#yanpwd").val(data);
					return false;
				}
			});
			//阻止表单提交(Ajax)
			return false;
		});

	});
</script>

<!-- layer -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>PC/layer/mobile/need/layer.css" />
<script src="<%=basePath%>PC/layer/layer.js" type="text/javascript" charset="utf-8"></script>
<style>
	.footer {
	width: 100%;
	height: auto;
	overflow: hidden;
	position: fixed;
	bottom: 0;
}
.footer_top {
	background: #161616;
	height: auto;
	overflow: hidden;
	padding: 10px 0;
}
.foote_cont {
	width: 1200px;
	height: auto;
	overflow: hidden;
	margin: 0 auto;
}
.footer_map {
	width: 100%;
	height: auto;
}
.footer_map a {
	display: block;
	width: auto;
	height: 13px;
	line-height: 13px;
	color: #757575;
	font-size: 12px;
	text-decoration: none;
	padding-right: 10px;
	border-right: 1px solid #757575;
	float: left;
	margin-right: 10px;
}
.footer_map a:hover,
.footer_bCont a:hover{
	color: #ff6d46;
}
.footer_map .footer_map_last {
	border: none;
}
.footer_bottom {
	width: 100%;
	height: auto;
	overflow: hidden;
	background-color: rgba(0,0,0,.8);
}
.footer_bCont {
	width: 1200px;
	height: auto;
	overflow: hidden;
	margin: 0 auto;
	padding: 10px 0;
}
.footer_bCont a {
	display: block;
	width: auto;
	height: 13px;
	line-height: 13px;
	color: #757575;
	font-size: 12px;
	text-decoration: none;
	float: left;
	margin-right: 20px;
}
	
</style>
</head>
<body>
	<div class="header">
		<div class="container flex">
			<p class="flex2 conttent_p">
				${sessionScope.namea!=null?'欢迎:':''}<a
					href="<%=basePath%>RequestMappingUtil/requestData/PC/login">${sessionScope.namea!=null?'':'登录'}</a><a
					href="<%=basePath%>RequestMappingUtil/requestData/PC/register"><span>${sessionScope.namea!=null?'':'注册'}</span></a>${sessionScope.namea!=null?sessionScope.namea:''}</p>
			<ul class="flex8 content_u">
				<li><img src="<%=basePath%>PC/images/e.png" /><a href="javascript:void(0);">wenping@smuyun.com</a></li>
				<li><img src="<%=basePath%>PC/images/p.png" /><a href="javascript:void(0);">0851 8861 0341</a></li>
			</ul>
		</div>
		<div style="clear: both;"></div>
	</div>

	<!--导航开始-->
	<header>
	<div class="container">
		<nav class="nav navlist" role="navigation">
		<div class="navbar-header" style="margin-right: 60px;">
			<a href="<%=basePath%>PC/index.jsp" class="logo"><img
				src="<%=basePath%>PC/images/logo.png" /></a> <a href="#"
				class="navbar-btn navbar-toggle navbtn" data-toggle="collapse"
				data-target="#myCollapse"> <img
				src="<%=basePath%>PC/images/nav-btn.png" />
			</a>
		</div>
		<div class="collapse navbar-collapse navColl" id="myCollapse">
			<ul class="nav navbar-nav pull-left ren_nav">
				<li class="active"><a href="<%=basePath%>PC/index.jsp"
					style="color: #ff6d46;">人人配送</a></li>
				<li><a href="<%=basePath %>PC/intro.jsp">公众号</a></li>
				<li><a href="<%=basePath %>PC/about.jsp">关于我们</a></li>
				<li><a href="<%=basePath%>PC/personalCenter.jsp">个人中心</a></li>
				<li class="active"><a href="http://www.smuyun.com/"
					target="_left">商城</a></li>
			</ul>
		</div>
		</nav>
	</div>
	</header>
	<!--导航结束-->
	<!--内容开始-->
	<div class="zhao_top">
		<div class="zhao_a">找回密码</div>
		<ul class="zhao_b">
			<li>手机找回</li>
			<li class="zhao_r">人工找回</li>
		</ul>
		<div style="clear: both;"></div>
	</div>

	<div class="zhao_c">
		<!--手机找回密码-->
		<div class="zhao_shou2 que0" style="display: none;">
			<!-- 手机找回form 开始 -->
			<form action="reupdatepass/PC" method="post">
				<div class="zhuce_phone">
					<label>* 手机号码：</label> <input type="text" id="phone"
						name="kuaikePhone" /> <span class="hidden2"
						style="width: 100px;height: 30px; color: red;">不能为空</span> <span
						class="hidden2_2" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
					<img src="<%=basePath%>PC/images/g00_03.png" class="img2" />
				</div>
				<div class="zhuce_yanzheng">
					<label>* </label> <input type="text" value="${mobile_code}"
						id="yanpwd" name="mobile_code" />
					<button class="yzbtn zhubtn" id="ajaxPhone">获取手机验证码</button>
					<span class="hidden8"
						style="width: 100px;height: 30px; color: red;">不能为空</span> <span
						class="hidden8_8" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
					<img src="<%=basePath%>PC/images/g00_03.png" class="img8" />
				</div>
				<div class="zhuce_pwd zhao_pwd">
					<label>* 登录密码：</label> <input type="password" value="" id="logopwd"
						name="password" /> <span class="hidden3"
						style="width: 100px;height: 30px; color: red;">不能为空</span> <span
						class="hidden3_3" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
					<img src="<%=basePath%>PC/images/g00_03.png" class="img3" />
				</div>
				<div class="zhuce_xing">
					<label>* 确认密码：</label> <input type="password" value="" id="pwd"
						name="okpassword" /> <span class="hidden4"
						style="width: 100px;height: 30px; color: red;">不能为空</span> <span
						class="hidden4_4" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
					<img src="<%=basePath%>PC/images/g00_03.png" class="img4" />
				</div>
				<div class="zhuce_xiayibu">
					<button id="btn">确认</button>
				</div>
			</form>
			<!-- 手机找回密码结束 -->

		</div>

		<!--人工找回密码-->
		<div class="zhao_ren1 que1" style="display: block;">
			<!--进度条-->
			<div class="setbackss">
				<!--进度条底层-->
				<div class="setbacks_11"></div>
				<!--进度条中层-->
				<div class="setbacks_22" style="width:0%; top: 197px;"></div>
				<!--进度条顶层-->
				<ul class="setbacks_33" style="top: 226px;">
					<li>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="center"><a
									href="<%=basePath%>PC/yianxiekuaike.jsp">
										<p class="setbacks_3_1_cc">1</p>
										<p class="setbacks_3_2_cc">填写快客信息</p>
								</a></td>
							</tr>
						</table>
					</li>
					<li>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="center"><a href="<%=basePath%>PC/toExamine.jsp">
										<p class="setbacks_3_11">2</p>
										<p class="setbacks_3_22">审核</p>
								</a></td>
							</tr>
						</table>
					</li>
					<li>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="center"><a
									href="<%=basePath%>PC/zhuanyepeixun.jsp">
										<p class="setbacks_3_11">3</p>
										<p class="setbacks_3_22">审核成功</p>
								</a></td>
							</tr>
						</table>
					</li>

				</ul>
				<div class="clear"></div>
			</div>

			<form action="selectUpdatePasswordBykuaikeInfo" method="post"
				id="subform">
				<div class="zhuce_xing">
					<label>* 姓名：</label> <input type="text" value="" id="namett"
						name="kuaikeName" /> <span class="hidden1"
						style="width: 100px;height: 30px; color: red;">不能为空</span> <span
						class="hidden1_1" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
					<img src="<%=basePath%>PC/images/g00_03.png" class="img1" />
				</div>

				<div class="zhuce_phone">
					<label>* 手机号码：</label> <input type="text" value="" id="phone"
						name="kuaikePhone" /> <span class="hidden2"
						style="width: 100px;height: 30px; color: red;">不能为空</span> <span
						class="hidden2_2" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
					<img src="<%=basePath%>PC/images/g00_03.png" class="img2" />
				</div>

				<div class="zhuce_dizhi">
					<label>* 现居住地址：</label><select id="Select1" name="kuaikeAddress"></select>　省　<select id="Select2" name="kuaikeAddress"></select>
						　市　<select id="Select3" name="kuaikeAddress"></select>　区

				</div>
				
				<div class="zhuce_xiangqing">
					<label></label> <input type="text" value="" id="jiedao"
						name="kuaikeAddressInfo" /> <span>详情地址</span> <span
						class="hidden7" style="width: 100px;height: 30px; color: red;">不能为空</span>
					<span class="hidden7_7"
						style="width: 100px;height: 30px; color: red;">输入正确的格式</span> <img
						src="<%=basePath%>PC/images/g00_03.png" class="img7" />
				</div>
				<div class="zhuce_xiayibu">
					<button id="btn"
						onclick="document.getElementById('subform').submit();return false">提交
					</button>
				</div>
			</form>
		</div>

	</div>

	<!--【底部】-->
		<footer class="footer">
			<div class="footer_top">
				<div class="foote_cont">
					<div class="footer_map">
						<a href="<%=basePath %>PC/index.jsp">首页</a>
						<a href="<%=basePath %>PC/index.jsp">人人配送</a>
						<a href="<%=basePath %>PC/intro.jsp">公众号</a>
						<a href="<%=basePath %>PC/index.jsp">网站地图</a>
						<a class="footer_map_last" href="<%=basePath %>PC/index.jsp">SITEAPM</a>
					</div>
				</div>
			</div>
			<div class="footer_bottom">
				<div class="footer_bCont">
					<a href="javascript:;">公司：水木云网络科技有限公司</a>
					<a href="javascript:;">公司地址：贵州省贵阳市花果园E区二单元</a>
					<a href="javascript:;">工信部备案号黔ICP备16008136号</a>
					<a href="javascript:;"><span><img alt="" src="<%=basePath%>PC/images/beianhao.jpg" width="15"></span>贵公网安备52010202000388号</a>
				</div>
			</div>
		</footer>
		<!--【底部】end-->
<!-- 提示 -->
<script type="text/javascript">	${errorShow }</script>
</body>
</html>
<script src="<%=basePath%>PC/js/shoujizhaohuimima.js"
	type="text/javascript" charset="utf-8"></script>
<script>
	//找回密码的切换
	$(function() {
		$(".zhao_ren1").css("display", "block");
		$(".zhao_b>li").click(function() {
			$(this).addClass("zhao_r").siblings().removeClass("zhao_r");
			var num = $(this).index();

			$(".que" + num + "").css("display", "block").siblings().css("display", "none");
		})

	})
</script>

<script type="text/javascript" src="<%=basePath%>PC/js/jsAddress.js"></script>
	<script type="text/javascript">
								addressInit('Select1', 'Select2', 'Select3');
	</script>


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
<title>登录</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>PC/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>PC/css/index.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>PC/css/bootstrap.min.css" />
<script src="<%=basePath%>PC/js/jquery-3.1.0.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>PC/js/register.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	/*快客快捷登陆   通过手机接收验证码进行登陆*/
	$(function() {
		$("#ajaxBtn").click(function() {
			var phoneCode = $("#phoneCode").val();
			$.ajax({
				url : 'getCode',

				type : 'POST',
				data : {
					phoneCode : phoneCode
				},

				//请求成功后触发
				success : function(data) {

					$("#phoneCode").val(data);

				}
			});
		});
	});



	/*快客注册   通过手机接收验证码对手机进行绑定*/
	$(function() {
		$("#ajaxphoneCode").click(function() {
			var phoneCode = $("input[name='phoneCode']").val();
			$.ajax({
				url : 'getCode',

				type : 'POST',
				data : {
					phoneCode : phoneCode
				},

				//请求成功后触发
				success : function(data) {

					$("input[name='phoneCode']").val(data);

				}
			});
		});
	});
</script>

</head>
<body>
	<div class="header">
		<div class="container flex">
			<p class="flex2 conttent_p">
				${sessionScope.login.kuaikeName!=null?'欢迎:':''}<a
					href="<%=basePath%>RequestMappingUtil/requestData/PC/login">${sessionScope.login.kuaikeName!=null?'':'登录'}</a><a
					href="<%=basePath%>RequestMappingUtil/requestData/PC/register"><span>${sessionScope.login.kuaikeName!=null?'':'注册'}</span></a>${sessionScope.login.kuaikeName!=null?sessionScope.login.kuaikeName:''}</p>
			<ul class="flex8 content_u">
				<li><img src="<%=basePath%>PC/images/e.png" /><a href="javascript:void(0);">wenping@smuyun.com</a></li>
				<li><img src="<%=basePath%>PC/images/p.png" /><a href="javascript:void(0);">0851
						8510 3179</a></li>
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
				<li><a href="javascript:void(0);">公众号</a></li>
				<li><a href="javascript:void(0);">关于我们</a></li>
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
	<div class="container">

		<div class="zhuce_left col-lg-2 col-md-2 col-sm-2 col-xs-2">

			<button style="clear: both; background: #ff6d46; color: white;"
				class="logo_b">登&nbsp&nbsp录</button>
			<button>注 &nbsp&nbsp册</button>
			<div
				style="position: relative;left: 93.1%; top:-109px; z-index: 999; border: white 1px dashed !important;">
				<img src="<%=basePath%>PC/images/t003_03.png" />
			</div>
		</div>
		<!--右变开始-->
		<div class="zhuce_right col-lg-10 col-md-10 col-sm-10 col-xs-10">
			<!--注册-->
			<div class="zhuce_1" style="display: none;">
				<!--进度条-->
				<div class="setbacks">
					<!--进度条底层-->
					<div class="setbacks_1"></div>
					<!--进度条中层-->
					<div class="setbacks_2" style="width:0%; "></div>
					<!--进度条顶层-->
					<ul class="setbacks_3">
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="center"><a
										href="<%=basePath%>PC/yianxiekuaike.jsp">
											<p class="setbacks_3_1_c">1</p>
											<p class="setbacks_3_2_c">填写快客信息</p>
									</a></td>
								</tr>
							</table>
						</li>
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="center"><a href="<%=basePath%>PC/toExamine.jsp">
											<p class="setbacks_3_1">2</p>
											<p class="setbacks_3_2">审核</p>
									</a></td>
								</tr>
							</table>
						</li>
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="center"><a
										href="<%=basePath%>PC/zhuanyepeixun.jsp">
											<p class="setbacks_3_1">3</p>
											<p class="setbacks_3_2">专业培训</p>
									</a></td>
								</tr>
							</table>
						</li>
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="center"><a href="<%=basePath%>PC/kaoshi.jsp">
											<p class="setbacks_3_1">4</p>
											<p class="setbacks_3_2">考试</p>
									</a></td>
								</tr>
							</table>
						</li>
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="center"><a
										href="<%=basePath%>PC/chengweikuaike.jsp">
											<p class="setbacks_3_1">4</p>
											<p class="setbacks_3_2">成为快客</p>
									</a></td>
								</tr>
							</table>
						</li>

					</ul>
					<div class="clear"></div>
				</div>

				<!--表单开始-->
				<form action="upload.do" method="post" enctype="multipart/form-data">
					<div class="zhuce_xing">
						<label>* 姓名：</label> <input type="text" required="required" name="kuaikeName" value=""
							id="namett" /> <span class="hidden1"
							style="width: 100px;height: 30px; color: red;">不能为空</span> <span
							class="hidden1_1" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
						<img src="<%=basePath%>PC/images/g00_03.png" class="img1" />
					</div>
					<div class="zhuce_phone">
						<label>* 手机号码：</label> <input required="required" type="text" name="kuaikePhone"
							value="" id="phone" /> <span class="hidden2"
							style="width: 100px;height: 30px; color: red;">不能为空</span> <span
							class="hidden2_2" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
						<img src="<%=basePath%>PC/images/g00_03.png" class="img2" />
					</div>
					<div class="zhuce_pwd">
						<label>* 登录密码：</label> <input required="required" type="password" name="password"
							value="" id="logopwd" /> <span class="hidden3"
							style="width: 100px;height: 30px; color: red;">不能为空</span> <span
							class="hidden3_3" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
						<img src="<%=basePath%>PC/images/g00_03.png" class="img3" />
					</div>

					<div class="zhuce_tuleft">
						<img src="<%=basePath%>PC/images/t003_03.png" />
					</div>
					<div class="zhuce_xing">
						<label>* 确认密码：</label> <input required="required" type="password" value="" id="pwd" />
						<span class="hidden4"
							style="width: 100px;height: 30px; color: red;">不能为空</span> <span
							class="hidden4_4" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
						<img src="<%=basePath%>PC/images/g00_03.png" class="img4" />
					</div>
					<div class="zhuce_dizhi">
						<label>* 现居住地址：</label> <select required="required" id="sheng" name="kuaikeAddress">
							<c:forEach items="${province }" var="p">
								<option value="${p.name }">${p.name }</option>
							</c:forEach>
						</select> <span>省</span> <select required="required" id="shi" name="kuaikeAddress">
							<c:forEach items="${city }" var="c">
								<option value="${c.name }">${c.name }</option>
							</c:forEach>
						</select> <span>市</span> <select required="required" id="xian" name="kuaikeAddress">
							<c:forEach items="${area }" var="a">
								<option value="${a.name }">${a.name }</option>
							</c:forEach>
						</select> <span>县/区</span>

					</div>

					<div class="zhuce_xiangqing">
						<label></label> <input required="required" type="text" name="kuaikeAddressInfo"
							value="" id="jiedao" /> <span>详情地址</span> <span class="hidden7"
							style="width: 100px;height: 30px; color: red;">不能为空</span> <span
							class="hidden7_7" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
						<img src="<%=basePath%>PC/images/g00_03.png" class="img7" />
					</div>

					<div class="zhuce_yanzheng">
						<label>* </label> <input required="required" type="text" value="${phoneCode }"
							id="yanpwd" name="phoneCode" />
						<button class="zhubtn" id="ajaxphoneCode">获取手机验证码</button>

						<span class="hidden8"
							style="width: 100px;height: 30px; color: red;">不能为空</span> <span
							class="hidden8_8" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
						<img src="<%=basePath%>PC/images/g00_03.png" class="img8" />
					</div>

					<div class="Passpicture">

						<div class="zhuce_zf">
							<input required="required" type="file" name="file1"
								style="width: 100%;min-height: 200px;opacity: 0;" id="file0"
								multiple="multiple" /> <a href="#" id="zhuce_zf"
								class="btn  disabled" role="button"
								style="cursor: pointer; text-decoration: underline;">
								点击上传正反面身份证复印件 </a> <img src="" id="img0">
						</div>

						<div class="zhuce_c">
							<input required="required" type="file" name="file2"
								style="width: 100%;min-height: 200px;opacity: 0;" id="file1"
								multiple="multiple" /> <a href="#" id="zhuce_c"
								class="btn  disabled" role="button"
								style="cursor: pointer; text-decoration: underline;">点击上传正反面身份证复印件</a>
							<img src="" id="img1">
						</div>
						<span class="hidden9"
							style="width: 100px;height: 30px; color: red;">不能为空</span> <img
							src="<%=basePath%>PC/images/g00_03.png" class="img9" />
					</div>
					<div class="zhuce_sheng">
						<p>*&nbsp;上传身份证复印件</p>
						<p>*&nbsp;上传手持身份证照片</p>
					</div>
					<div style="clear: both;"></div>
					<div class="zhuce_xiayibu">
						<button id="btn">下一步</button>
					</div>
				</form>
			</div>
			<!--登录开始-->

			<div class="box zhuce_0">
				<form action="login" method="post">
					<div class="common">普通登录</div>
					<div class="free">免密登录</div>
					<div style="clear: both;"></div>
					<div class="common_con">
						<span>手机号码:</span> <input required="required" type="text " class="phone"
							value="${sessionScope.uname!=null?sessionScope.uname:''}"
							placeholder="  请输入手机号" name="kuaikePhone" /> <br /> <span>登录密码:</span>
						<input required="required" type="password" class="pwd"
							value="${ sessionScope.newPass!=null?sessionScope.newPass:''}"
							placeholder="  请输入登录密码" name="password" />
						<div style="clear: both;"></div>
						<a
							href="<%=basePath%>RequestMappingUtil/requestData/PC/pwdRetrieval"
							style="left: -168px;top: 20px; color: #999999;position: relative;">忘记密码</a>
						<div>
							<span><input type="checkbox" class="zii" name="repassword" /></span>
							<span class="zi">记住密码</span> <br />
							<button type="submit">登 录</button>
						</div>
					</div>
				</form>
				<form action="phoneLogin" method="post">
					<div class="free_con">
						<span>手机号码: </span><input required="required" type="text" class="phone1"
							placeholder="  请输入手机号" name="kuaikePhone" /><br /> <input required="required"
							type="text" name="phoneCode" id="phoneCode" value="${phoneCode }" />
						<button id="ajaxBtn" class="btn223">获取验证码</button>
						<br />
						<button>登 录</button>

					</div>
				</form>
				<span class="t1"></span> <span class="t2"></span> <span class="t3"></span>
				<img class="t33" src="<%=basePath%>PC/images/g00_03.png" /> <img
					class="t22" src="<%=basePath%>PC/images/g00_03.png" /> <img
					class="t11" src="<%=basePath%>PC/images/g00_03.png" />

			</div>

			<!--登录结束-->

		</div>

	</div>

	<!--底部开始 -->
	<footer>
	<div class="col-lg-1"></div>
	<div class="fooeter1 col-lg-2 col-sm-6 col-xs-6 col-md-2">
		<ul>
			<li>关于我们</li>
			<li><a href="#">关于我们的详情</a></li>
		</ul>
	</div>
	<div class="fooeter2 col-lg-2 col-sm-6 col-xs-6 col-md-2">
		<ul>
			<li><img src="<%=basePath%>PC/images/004_03.png" /><a href="#">帮助信息</a></li>
			<li><img src="<%=basePath%>PC/images/004_03.png" /><a href="#">注册帮助</a></li>
			<li><img src="<%=basePath%>PC/images/004_03.png" /><a href="#">登录帮助</a></li>
			<li><img src="<%=basePath%>PC/images/004_03.png" /><a href="#">认证帮助</a></li>
			<li><img src="<%=basePath%>PC/images/004_03.png" /><a href="#">更多</a></li>
		</ul>

	</div>
	<div class="fooeter3 col-lg-2 col-sm-6 col-xs-6 col-md-2">
		<ul>
			<li>帮助信息</li>
		</ul>
	</div>
	<div class="fooeter4 col-lg-5 col-sm-6 col-xs-6 col-md-5">
		<ul>
			<li>联系我们</li>
			<li><span>商城名称:</span><a href="#">水木云</a></li>
			<li><span>商城客服电话:</span><a href="#"> 400 800 600</a></li>
			<li><span>商城客服邮箱:</span><a href="#">wenping@smuyun.com</a></li>
			<li><span>商城关键词组:</span><a href="#">水木云， 水木云商城</a></li>
			<li><span>商城简要说明:</span><a href="#">水木云实体社区服务商城</a></li>
		</ul>
	</div>
	</footer>
<!-- 提示 -->
<script type="text/javascript">	${errorShow }</script>
</body>
</html>
<script src="<%=basePath%>PC/js/login.js" type="text/javascript"
	charset="utf-8"></script>
<script src="http://www.codefans.net/ajaxjs/jquery-1.6.2.min.js"></script>
<script src="<%=basePath%>PC/js/tu.js" type="text/javascript"
	charset="utf-8"></script>
<script>

	$("#file0").change(function() {
		// getObjectURL是自定义的函数，见下面  
		// this.files[0]代表的是选择的文件资源的第一个，因为上面写了 multiple="multiple" 就表示上传文件可能不止一个  
		// ，但是这里只读取第一个   
		var objUrl = getObjectURL(this.files[0]);
		if (objUrl) {
			// 在这里修改图片的地址属性  
			$("#img0").attr("src", objUrl) ;
		}
	}) ;
	//建立一個可存取到該file的url  
	function getObjectURL(file) {
		var url = null;
		// 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已  
		if (window.createObjectURL != undefined) { // basic  
			url = window.createObjectURL(file) ;
		} else if (window.URL != undefined) { // mozilla(firefox)  
			url = window.URL.createObjectURL(file) ;
		} else if (window.webkitURL != undefined) { // webkit or chrome  
			url = window.webkitURL.createObjectURL(file) ;
		}
		return url;
	}
</script>

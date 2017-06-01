<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'personalCenter.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>PC/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>PC/css/index.css" />
<link rel="stylesheet" href="<%=basePath%>PC/css/style.css" />
<title>个人中心</title>
</head>
<body>
	<div class="perinfo_top">
		<div class="perinfo_top_cont">
			<div class="perinfo_top_l left">人人配送个人中心</div>
			<div class="perinfo_top_r right">安全退出</div>
		</div>
		<div class="clear"></div>
	</div>
	<!--导航位置-->

	<!--导航开始-->
	<header>
	<div class="container">
		<nav class="nav navlist" role="navigation">
		<div class="navbar-header" style="margin-right: 60px;">
			<a href="<%=basePath%>RequestMappingUtil/requestNUll/PC/index" class="logo"><img
				src="<%=basePath%>PC/images/logo.png" /></a> <a href="#"
				class="navbar-btn navbar-toggle navbtn" data-toggle="collapse"
				data-target="#myCollapse"> <img
				src="<%=basePath%>PC/images/nav-btn.png" />
			</a>
		</div>
		<div class="collapse navbar-collapse navColl" id="myCollapse">
			<ul class="nav navbar-nav pull-left ren_nav">
				<li class="active"><a href="http://www.smuyun.com/">商城</a></li>
				<li class="active"><a href="index.html" style="color: #ff6d46;">人人配送</a></li>
				<li><a href="aboutUs.html">公众号</a></li>
				<li><a href="service.html">关于人人配送</a></li>
			</ul>
		</div>
		</nav>
	</div>
	</header>
	<!--导航位置 end-->


	<!--页面主要能容-->
	<div class="perinfo_cont">
		<div class="perinfo_l left">
			<img class="perinfo_user" title="" alt=""
				src="<%=basePath%>PC/images/userImg.png" />
			<p class="perinfo_user_name">15700104801</p>
			<ul class="perinfo_menu">
				<li>
					<p id="allItem" class="perinfo_menu_title">订单记录</p>
				</li>
				<li>
					<p class="perinfo_menu_title">我的钱包</p>
				</li>
				<li>
					<p class="perinfo_menu_title">个人资料</p>
				</li>
				<li>
					<p class="perinfo_menu_title">修改密码</p>
				</li>
				<li>
					<p class="perinfo_menu_title">抢单记录</p>
				</li>
			</ul>
		</div>
		<div class="perinfo_r right">
			<div class="perinfo_rCont" id="perinfo_rContOne">
				<div class="perinfo_menu_item">
					<a href="javascript:void(0);" onclick="javascript:statusHref(0);">全部订单</a> <a class="active"
						href="javascript:void(0);"  onclick="javascript:statusHref(1);">待付款</a> <a href="javascript:void(0);"  onclick="javascript:statusHref(2);">待取货</a> <a
						href="javascript:void(0);"  onclick="javascript:statusHref(3);">正在派送</a> <a href="javascript:void(0);"  onclick="javascript:statusHref(4);">待评价</a>
				</div>
				<table border="0" cellspacing="0" cellpadding="0">
					<thead class="perinfo_thead">
						<tr class="perinfo_order_nav">
							<td class="perinfo_name">货物</td>
							<td class="perinfo_time">取货时间</td>
							<td class="perinfo_pay">实际付款</td>
							<td class="perinfo_state">交易状态</td>
							<td class="perinfo_operation">操作</td>
						</tr>
					</thead>
					<tbody class="perinfo_tbody prolist"></tbody>
				</table>
			</div>
			<div class="perinfo_rCont">我的钱包</div>
			<div class="perinfo_rCont">
				<div class="perinfo_iffo">修改基本资料</div>
				<div class="modify_pwd modify_info">
					<div class="modify_info_user" id="preview">
						<img id="imghead" src="<%=basePath%>PC/images/userImg.png"
							onclick="$('#previewImg').click();">
					</div>
					<input id="previewImg" type="file" onchange="previewImage(this)"
						style="display: none;" id="previewImg">
					<div id="infoNameCont" class="modify_item">
						<div class="modify_item_name left">昵称:</div>
						<input id="infoName" class="modify_item_input left" type="text" />
					</div>
					<div id="infoPhoneCont" class="modify_item">
						<div class="modify_item_name left">手机号码:</div>
						<input id="infoPhone" class="modify_item_input left" type="text" />
					</div>
					<div id="infoNewPhoneCont" class="modify_item">
						<div class="modify_item_name left">备用手机:</div>
						<input id="infoNewPhone" class="modify_item_input left"
							type="text" />
					</div>
				</div>
				<div class="perinfo_iffo">修改手机号码</div>
				<div class="modify_pwd modify_info">
					<div id="infoModifyPhoneCont" class="modify_item">
						<div class="modify_item_name left">手机号:</div>
						<input id="infoModifyPhone" class="modify_item_input left"
							type="text" />
					</div>
					<div id="infoYznCont" class="modify_item">
						<input id="infoYznBtn" class="modify_item_yzbtn right"
							type="button" value="获取验证码" /> <input id="infoYzn"
							class="modify_item_yzinput right" type="text" />
					</div>
					<div id="infoBtn" class="modify_item_btn right">确认修改</div>
				</div>
			</div>
			<div class="perinfo_rCont">
				<div class="modify_pwd">
					<div id="phoneCont" class="modify_item">
						<div class="modify_item_name left">手机号:</div>
						<input id="phone" class="modify_item_input left" type="text" />
					</div>
					<div id="pwdCont" class="modify_item">
						<div class="modify_item_name left">密码:</div>
						<input id="pwd" class="modify_item_input left" type="password" />
					</div>
					<div id="newPwdCont" class="modify_item">
						<div class="modify_item_name left">确认密码:</div>
						<input id="newPwd" class="modify_item_input left" type="password" />
					</div>
					<div id="yzmCont" class="modify_item">
						<input class="modify_item_yzbtn right" type="button" id="yzmBtn"
							value="获取验证码" /> <input id="yzm"
							class="modify_item_yzinput right" type="text" />
					</div>
					<div id="modifyBtn" class="modify_item_btn right">确认修改</div>
				</div>
			</div>
			<div class="perinfo_rCont">抢单记录</div>
		</div>
	</div>
	<!--页面主要能容 end-->

	<!--底部开始-->

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
	<!--jqery库 jquery-2.1.0.js -->
	<script src="<%=basePath%>PC/js/jquery-3.1.0.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		//默认
		$(function(){
			loadmore(0);
		});
	
		//ajax
		function loadmore(status) {
					//请求
					$.ajax({
						type : 'get',
						url : 'xiaordertab/xiadanAjax/'+status,
						dataType : 'html',
						success : function(objs) {
							var data = jQuery.parseJSON(objs);
							if (data == "") {
								alert("没有数据");
							} else {
								var result = ''
								for (var i = 0; i < data.length; i++) {
									//类型
									var shopType = data[i].shopType > 0 ? '不易碎' : '易碎';
									//状态
									status = data[i].status == 0 ? '未接单' : data[i].status;
									status = data[i].status == 1 ? '已接单,未发货' : status;
									status = data[i].status == 2 ? '已到达,未确认' : status;
									status = data[i].status == 3 ? '交易结束(已确认)' : status;
									status = data[i].status == 4 ? '已评价' : status;
	
									result += "<tr> \
										<td class='perinfo_name'> \
											<img class='perinfo_img left' title='"+data[i].shopImages+"' alt='' src='"+data[i].shopImages+"' /> \
											<div class='perinfo_orderinfo right'> \
												<p>大小：" + data[i].shopGuige + "</p> \
												<p>重量：" + data[i].shopzholiang + "kg</p> \
												<p>类型：" + shopType + "</p> \
											</div> \
										</td> \
										<td class='perinfo_time'> \
											<p class='perinfo_time_text'>" + data[i].okDate + "</p> \
										</td> \
										<td class='perinfo_pay'> \
											<p class='perinfo_time_text'>￥" + data[i].kaikeProies + "</p> \
										</td> \
										<td class='perinfo_state'> \
											<p class='perinfo_time_text'>" + status + "</p> \
											<a class='perinfo_actbtn' href='javascript:void(0);'>快递员信息</a> \
										</td> \
										<td class='perinfo_operation'> \
											<p class='perinfo_btn'> \
												<a href='xiaordertab/xiaorderInfo/" + data[i].xiaId + "'><img title='查看详情' alt='' src='<%=basePath%>PC/images/See.png' width='32' /></a> \
											</p> \
										</td> \
									</tr>";
									
									
								}
								$('.prolist').append(result);

							}
						},
						error : function(xhr, type) {
							alert('Ajax error!');
						}
					});
		}
		
		//状态
		function statusHref(status) {
			$('.prolist').html("");
			loadmore(status);
		}
	</script>
	<script>
		$(function() {
			//切换全部订单颜色高亮
			$(".perinfo_menu_item a").click(function() {
				$(this).addClass("active").siblings().removeClass("active");
			})
	
			//选项卡切换
			$(".perinfo_r .perinfo_rCont").eq(0).show();
			$(".perinfo_menu_title").eq(0).addClass("perinfo_menu_title_active");
			$(".perinfo_menu li").click(function() {
				$(this).find(".perinfo_menu_title").addClass("perinfo_menu_title_active");
				$(this).siblings().find(".perinfo_menu_title").removeClass("perinfo_menu_title_active");
				var index = $(this).index();
				$(".perinfo_r .perinfo_rCont").eq(index).show().siblings().hide();
			})
	
			//验证修改密码表单
			$("#modifyBtn").click(function() {
				$(".modify_tips").remove();
				//获取手机号码
				var userPhone = $("#phone").val();
				//获取密码
				var pwd = $("#pwd").val();
				//获取新密码
				var newPwd = $("#newPwd").val();
				//获取验证码
				var yzm = $("#yzm").val();
	
				//判断手机号码是否可用
				if (!(userPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(userPhone))) {
					var isFalse = "请输入正确的手机号码";
					$("#phoneCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				if (userPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(userPhone)) {
					$(".modify_tips").remove();
				}
				//判断密码是否为空
				if (pwd == "") {
					var isFalse = "密码不能为空";
					$("#pwdCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				if (pwd != "") {
					$(".modify_tips").remove();
				}
	
				//判断新密码
				if (newPwd == "") {
					var isFalse = "新密码不能为空";
					$("#newPwdCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				if (newPwd != pwd) {
					var isFalse = "两次密码不一致";
					$("#newPwdCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				//判断是否输入验证码
				if (yzm == "") {
					var isFalse = "请输入验证码";
					$("#yzmCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				if (yzm != "") {
					$(".modify_tips").remove();
				}
			})
	
			//秒获取验证码
			var wait = 60;
			function time(o) {
				if (wait == 0) {
					o.removeAttribute("disabled");
					o.value = "获取验证码";
					wait = 60;
				} else {
					o.setAttribute("disabled", true);
					o.value = "重新发送(" + wait + ")";
					wait--;
					setTimeout(function() {
						time(o)
					}, 1000)
				}
			}
	
			//获取验证码
			$("#yzmBtn").click(function() {
				$(".modify_tips").remove();
				var userPhone = $("#phone").val();
				if (userPhone == '') {
					var isFalse = "手机号码不能为空";
					$("#phoneCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				} else if (!(userPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(userPhone))) {
					var isFalse = "请输入正确的手机号码";
					$("#phoneCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				} else {
					$(".modify_tips").remove();
					time(this);
				}
			});
	
			//个人资料验证
			$("#infoBtn").click(function() {
				$(".user_tips").remove();
				$(".modify_tips").remove();
				//获取用户头像
				var previewImg = $("#previewImg").val();
				//获取用户昵称
				var infoName = $("#infoName").val();
				//获取用户手机号码
				var infoPhone = $("#infoPhone").val();
				//获取用户备用手机号码
				var infoNewPhone = $("#infoNewPhone").val();
				//获取修改的手机号码
				var infoModifyPhone = $("#infoModifyPhone").val();
				//获取修改手机号码的验证码
				var infoYzn = $("#infoYzn").val();
	
				if (previewImg == "") {
					var isFalse = "请上传用户头像";
					$(".modify_info_user").append("<div class='user_tips'>" + isFalse + "</div>");
					return false;
				}
				if (previewImg != "") {
					$(".user_tips").remove();
				}
				if (infoName == "") {
					var isFalse = "请填写昵称";
					$("#infoNameCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				if (infoName != "") {
					$(".modify_tips").remove();
				}
				if (!(infoPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(infoPhone))) {
					var isFalse = "请输入正确的手机号码";
					$("#infoPhoneCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				if (infoPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(infoPhone)) {
					$(".modify_tips").remove();
				}
				if (!(infoNewPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(infoNewPhone))) {
					var isFalse = "请输入正确的手机号码";
					$("#infoNewPhoneCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				if (infoNewPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(infoNewPhone)) {
					$(".modify_tips").remove();
				}
				if (!(infoModifyPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(infoModifyPhone))) {
					var isFalse = "请输入正确的手机号码";
					$("#infoModifyPhoneCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				if (infoModifyPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(infoModifyPhone)) {
					$(".modify_tips").remove();
				}
				if (infoYzn == "") {
					var isFalse = "请填写验证码";
					$("#infoYznCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				}
				if (infoYzn != "") {
					var isFalse = "请填写验证码";
					$(".modify_tips").remove();
				}
			})
	
			//修改手机号码验证码事件
			$("#infoYznBtn").click(function() {
				$(".modify_tips").remove();
				//获取修改的手机号码
				var infoModifyPhone = $("#infoModifyPhone").val();
				if (!(infoModifyPhone && /^1(3[0-9]|4[57]|5[0-35-9]|7[6-8]|8[0-9])\d{8}$/.test(infoModifyPhone))) {
					var isFalse = "请输入正确的手机号码";
					$("#infoModifyPhoneCont").append("<div class='modify_tips'>" + isFalse + "</div>");
					return false;
				} else {
					$(".modify_tips").remove();
					time(this);
				}
			})
		})
	
		//图片上传预览    IE是用了滤镜。
		function previewImage(file) {
			var MAXWIDTH = 90;
			var MAXHEIGHT = 90;
			var div = document.getElementById('preview');
			if (file.files && file.files[0]) {
				div.innerHTML = '<img id=imghead onclick=$("#previewImg").click()>';
				var img = document.getElementById('imghead');
				img.onload = function() {
					var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
					img.width = rect.width;
					img.height = rect.height;
					img.style.marginTop = rect.top + 'px';
				}
				var reader = new FileReader();
				reader.onload = function(evt) {
					img.src = evt.target.result;
				}
				reader.readAsDataURL(file.files[0]);
			} else //兼容IE
			{
				var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
				file.select();
				var src = document.selection.createRange().text;
				div.innerHTML = '<img id=imghead>';
				var img = document.getElementById('imghead');
				img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
				status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width + ',' + rect.height);
				div.innerHTML = "<div id=divhead style='width:" + rect.width + "px;height:" + rect.height + "px;margin-top:" + rect.top + "px;" + sFilter + src + "\"'></div>";
			}
		}
		function clacImgZoomParam(maxWidth, maxHeight, width, height) {
			var param = {
				top : 0,
				left : 0,
				width : width,
				height : height
			};
			if (width > maxWidth || height > maxHeight) {
				rateWidth = width / maxWidth;
				rateHeight = height / maxHeight;
	
				if (rateWidth > rateHeight) {
					param.width = maxWidth;
					param.height = Math.round(height / rateWidth);
				} else {
					param.width = Math.round(width / rateHeight);
					param.height = maxHeight;
				}
			}
			param.left = Math.round((maxWidth - param.width) / 2);
			param.top = Math.round((maxHeight - param.height) / 2);
			return param;
		}
	</script>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<meta http-equiv = "X-UA-Compatible" cotent = "IE=edge,chrome=1"/>
		<meta name="viewport" content="width=device-width,initial-scale=1.0" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<script src="js/jquery-3.1.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/zhuce.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<!--导航开始-->
		<header>
			<div class="container">
				<nav class="nav navlist" role="navigation">
					<div class="navbar-header" style="margin-right: 60px;">
						<a href="index.jsp" class="logo"><img src="images/logo.png" /></a>
						<a href="#" class="navbar-btn navbar-toggle navbtn" data-toggle="collapse" data-target="#myCollapse">
							<img src="images/nav-btn.png"/>
						</a>
					</div>
					<div class="collapse navbar-collapse navColl" id="myCollapse">
						<ul class="nav navbar-nav pull-left ren_nav">
							<li class="active"><a href="http://www.smuyun.com/">商城</a></li>
							<li class="active"><a href="index.jsp" style="color: #ff6d46;">人人配送</a></li>
							<li><a href="aboutUs.jsp">公众号</a></li>
							<li><a href="service.jsp">关于人人配送</a></li>
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
		   	       <div class="zhuce_phone">
                     	   <label>* 手机号码：</label>
                     	   <input type="text" value="" id="phone"/>
                     	   <span class="hidden2" style="width: 100px;height: 30px; color: red;">不能为空</span>
                     	    <span class="hidden2_2" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
                     	 <img src="images/g00_03.png"class="img2"/>
                    </div>
                   <div class="zhuce_yanzheng">
			        	  <label>* </label>
			        	  <input type="text" value="" id="yanpwd"/>
			        	  <input type="button" value="获取手机验证码"/>
			        	  <span class="hidden8" style="width: 100px;height: 30px; color: red;">不能为空</span>
                     	    <span class="hidden8_8" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
			        	<img src="images/g00_03.png" class="img8"/>
			        </div>
			       <div class="zhuce_pwd zhao_pwd">
                     	   <label>* 登录密码：</label>
                     	   <input type="password" value="" id="logopwd"/>
                     	    <span class="hidden3" style="width: 100px;height: 30px; color: red;">不能为空</span>
                     	    <span class="hidden3_3" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
                     	    <img src="images/g00_03.png"class="img3"/>
                     </div>
                    <div class="zhuce_xing">
                     	   <label>* 确认密码：</label>
                     	   <input type="password" value="" id="pwd"/>
                     	    <span class="hidden4" style="width: 100px;height: 30px; color: red;">不能为空</span>
                     	    <span class="hidden4_4" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
                     	    <img src="images/g00_03.png"class="img4"/>
                   </div>
                  <div class="zhuce_xiayibu">
			       	   <a href="#" id="btn">确认</a>
			      </div> 
		   	
		   </div>
		
			<!--人工找回密码-->
			<div class="zhao_ren1 que1" style="display: none;">
			        <!--进度条-->	
					<div class="setbackss">
						<!--进度条底层-->
						<div class="setbacks_11"></div>
						<!--进度条中层-->
						<div class="setbacks_22" style="width:0%; "></div>
						<!--进度条顶层-->
						<ul class="setbacks_33">
							<li>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
									  <td align="center">
										<a href="yianxiekuaike.html">
											<p class="setbacks_3_1_cc">1</p>
											<p class="setbacks_3_2_cc">填写快客信息</p>
										</a>
									  </td>
									</tr>
								</table>
							</li>
							<li>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
									  <td align="center">
										<a href="shenhe.html">
											<p class="setbacks_3_11">2</p>
											<p class="setbacks_3_22">审核</p>
										</a>
									  </td>
									</tr>
								</table>
							</li>
							<li>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
									  <td align="center">
										<a href="zhuanyepeixun.html">
											<p class="setbacks_3_11">3</p>
											<p class="setbacks_3_22">专业培训</p>
										</a>
									  </td>
									</tr>
								</table>
							</li>
							
						</ul>
						<div class="clear"></div>
					</div>
                   
			     
				      <div class="zhuce_xing">
	                     	   <label>* 姓名：</label>
	                     	   <input type="text" value="" id="namett"/>
	                     	    <span class="hidden1" style="width: 100px;height: 30px; color: red;">不能为空</span>
	                     	    <span class="hidden1_1" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
	                     	   <img src="images/g00_03.png"class="img1"/>
	                  </div>
                     
                     <div class="zhuce_phone">
                     	   <label>* 手机号码：</label>
                     	   <input type="text" value="" id="phone"/>
                     	   <span class="hidden2" style="width: 100px;height: 30px; color: red;">不能为空</span>
                     	    <span class="hidden2_2" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
                     	 <img src="images/g00_03.png"class="img2"/>
                     </div>
                     <div class="zhuce_pwd">
                     	   <label>* 登录密码：</label>
                     	   <input type="password" value="" id="logopwd"/>
                     	    <span class="hidden3" style="width: 100px;height: 30px; color: red;">不能为空</span>
                     	    <span class="hidden3_3" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
                     	    <img src="images/g00_03.png"class="img3"/>
                     </div>
                    
                    <div class="zhuce_dizhi">
                     	<label>* 现居住地址：</label>
                     	<select id="sheng">
                     		<option value="贵州省">贵州省</option>
                     		<option value="云南省">云南省</option>
                     		<option value="河北省">河北省</option>
                     		<option value="江苏省">江苏省</option>
                     		<option value="东北省">东北省</option>
                     	</select>
                     	<span>省</span>
                     	<select id="shi">
                     		<option value="贵阳市">贵阳市</option>
                     		<option value="贵阳市">贵阳市</option>
                     		<option value="贵阳市">贵阳市</option>
                     		<option value="贵阳市">贵阳市</option>
                     		<option value="贵阳市">贵阳市</option>
                     		
                     	</select>
                     	<span>市</span>
                     	<select id="xian">
                     		<option value="盘县">盘县</option>
                     		<option value="盘县">盘县</option>
                     		<option value="盘县">盘县</option>
                     		<option value="盘县">盘县</option>
                     	</select>
                     	<span>县/区</span>
                     	
                     </div>
                     <div class="zhuce_jie">
                     	<label></label>
                     	<select id="jie">
                     		<option value="头桥二桥路">头桥二桥路</option>
                     		<option value="头桥二桥路">头桥二桥路</option>
                     		<option value="头桥二桥路">头桥二桥路</option>
                     		<option value="头桥二桥路">头桥二桥路</option>
                     	</select>
                     	<span>街道</span>
                 
                     	<span class="hidden5" style="width: 100px;height: 30px; color: red;">不能为空</span>
                     	<span class="hidden5_5" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
                     	<img src="images/g00_03.png"class="img5"/>
                     </div>
			        <div class="zhuce_xiangqing">
			        	  <label></label>
			        	  <input type="text" value="" id="jiedao"/>
			        	  <span>详情地址</span>
			        	  <span class="hidden7" style="width: 100px;height: 30px; color: red;">不能为空</span>
                     	   <span class="hidden7_7" style="width: 100px;height: 30px; color: red;">输入正确的格式</span>
			        	<img src="images/g00_03.png"class="img7"/>
			        </div>
			        <div class="zhuce_xiayibu">
			       	   <a href="#" id="btn">提交</a>
			       </div>
		
		 </div>
		    
		</div>
	</body>
</html>

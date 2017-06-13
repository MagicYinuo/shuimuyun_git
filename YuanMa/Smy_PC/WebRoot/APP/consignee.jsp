<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <title>收货人信息</title>
	<link rel="stylesheet" href="<%=basePath%>APP/css/smyMobile.css" />
	<link rel="stylesheet" href="<%=basePath%>APP/css/layer.css" />
	</head>
	<body>
		<!--【头部】-->
		<header class="commHeader">
			<a class="commHeader_l" href="javascript:self.location=document.referrer;">
				<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
			</a>
			<h6>收货人信息</h6>
			<a class="commHeader_r hipper_xia" href="javascript:shou();">
				<h6>完成</h6>
			</a>
		</header>
		<!--【头部】end-->
		<div class="hipper_contex">
			<div>
				<span>收货人：</span>
				<input id="con_name" type="text" placeholder="请输入姓名"/>
			</div>			
			<div>
				<span>手机号：</span>
				<input id="con_phone" type="text" placeholder="请输入手机号"/>
			</div>			
			<div>
				<img src="<%=basePath%>APP/images/icon/adds.png"width="15" class="hipper_contex_firstimg"/>
				<input type="text" class="hipper_contex_lasttext" value="贵州省贵阳市南明区花果园金融街2号"/>
				<img src="<%=basePath%>APP/images/icon/consignee_right.png" class="hipper_contex_lastimg" width="15"/>
			</div>			
		</div>
		<!-- 下单id -->
		<input type="hidden" id="xiaId" value="${xiaId }"> 
		<script type="text/javascript" src="<%=basePath%>APP/js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile.js" ></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/layer.js" ></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile_click.js" ></script>
		<script type="text/javascript">
			//ajax提交
			function shou(){
				//下单id
				var xiaId=$("#xiaId").val();
				//收货人
				var shouhuoName=$("#con_name").val();
				//手机号
				var shouhuoPhone=$("#con_phone").val();
				//详细地址
				var shouhuoAddressInfo=$(".hipper_contex_lasttext").val();
				//url
				var url=xiaId+"/"+shouhuoName+"/"+shouhuoPhone+"/"+shouhuoAddressInfo;
				$.ajax({
					url : 'xiaordertab/shou/'+url,
					type : 'POST',
					cache:false, 
	     			ifModified :true ,
					//请求成功后触发 
					beforeSend :function(xmlHttp){ 
				        xmlHttp.setRequestHeader("If-Modified-Since","0"); 
				        xmlHttp.setRequestHeader("Cache-Control","no-cache");
				     },
					success : function(data) {
						alert("保存成功!");
					},
					error : function(xhr, type) {
						alert('Ajax error!');
					},
					async:false
				});
			}
		</script>
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发货人信息</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>APP/css/smyMobile.css" />
	<link rel="stylesheet" href="<%=basePath%>APP/css/layer.css" />
	<script>
			setTimeout(function() {
				$("body").show();
			},500);
		</script>
	
	</head>
	<body>
		<!--【头部】-->
		<header class="commHeader">
			<a class="commHeader_l" href="javascript:self.location=document.referrer;">
				<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
			</a>
			<h6>发货人信息</h6>
			<a class="commHeader_r hipper_xia" href="javascript:fa();">
				<h6>完成</h6>
			</a>
		</header>
		<!--【头部】end-->
		<div class="hipper_contex">
			<div>
				<span>发货人：</span>
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
			function fa(){
				//下单id
				var xiaId=$("#xiaId").val();
				//发货人
				var kuaikeName=$("#con_name").val();
				//快客电话
				var kuaikePhone=$("#con_phone").val();
				//快客详细地址
				var kuaikeAddressInfo=$(".hipper_contex_lasttext").val();
				//url
				var url=xiaId+"/"+kuaikeName+"/"+kuaikePhone+"/"+kuaikeAddressInfo;
				$.ajax({
					url : 'xiaordertab/fa/'+url,
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

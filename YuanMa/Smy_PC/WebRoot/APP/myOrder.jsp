<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

	<title>我的订单</title>
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
<body style="background: #fff">
	<!--【头部】-->
	<header class="commHeader"> <a class="commHeader_l" onClick="javascript :history.back(-1);">
		<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
	</a>
	<p>我的订单</p>
	<a class="commHeader_r" href="RequestMappingUtil/requestNUll/APP/search"> <img class="commHeader_search"
		src="<%=basePath%>APP/images/icon/search.png" width="100%" />
	</a> </header>
	<!--【头部】end-->

	<!--【nav】-->
	<nav class="oallNav" id="div_statusXia" style="margin-top: 0.4rem"> 
		<a class="active" href="javascript:void(0);" id="x0" title="x0" url="xiaordertab/getXiaIdStatusList/${login.kuaikeId}/0" onclick="javascript:statusHref('x0');">全部</a> 
		<a href="javascript:void(0);" title="x1" id="x1" url="xiaordertab/getXiaIdStatusList/${login.kuaikeId}/1" onclick="javascript:statusHref('x1');">已接单</a> 
		<a href="javascript:void(0);" title="x2" id="x2" url="xiaordertab/getXiaIdStatusList/${login.kuaikeId}/2" onclick="javascript:statusHref('x2');">已发货</a> 
		<a href="javascript:void(0);" title="x3" id="x3" url="xiaordertab/getXiaIdStatusList/${login.kuaikeId}/3" onclick="javascript:statusHref('x3');">已到达</a> 
		<a href="javascript:void(0);" title="x4" id="x4" url="xiaordertab/getXiaIdStatusList/${login.kuaikeId}/4" onclick="javascript:statusHref('x4');">已评价</a>
	</nav>
	
	<nav class="oallNav oallNavEr" id="div_statusQiang"  style="display: none; margin-top: 0.4rem"> 
		<a class="active" href="javascript:void(0);" id="q0" title="q0" url="xiaordertab/queryIdStatus/${login.kuaikeId}/0" onclick="javascript:statusHref('q0');">全部</a>
		<a href="javascript:void(0);" title="q0" url="xiaordertab/queryIdStatus/${login.kuaikeId}/0" onclick="javascript:statusHref('q0');">已抢单</a> 
		<a href="javascript:void(0);" title="q1" id="q1" url="xiaordertab/queryIdStatus/${login.kuaikeId}/1" onclick="javascript:statusHref('q1');">已取货</a> 
		<a href="javascript:void(0);" title="q2" id="q2" url="xiaordertab/queryIdStatus/${login.kuaikeId}/2" onclick="javascript:statusHref('q2');">已派单</a> 
	</nav>
	<!--【nav】end-->

	<div class="oallCont" style="margin-top: 0.06rem;" style="border:red solid 1px;">
		<div class="oallCont_muen">
			<div class="active">全部</div>
			<div id="express">我的快递</div>
			<div id="delivery">我的发货</div>
		</div>
		<!--【没有数据的样式】-->
		<!--display: none-->
		<div class="oallDtev">
			<img title="" alt="" src="<%=basePath%>APP/images/noDeta.png" width="80%" />
			<div class="oallCont_div_span">
				<span class="oallCont_span"> 当前没有<label></label>订单
				</span>
			</div>
		</div>
		<!--【没有数据的样式】end-->
		<div class="oallCont_cont">
			<div class="oallCont_cont_item">
				<ul class="oallCont_cont_list"></ul>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>APP/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile.js"></script>
	<script>
		$(function() {
			$(".oallNav a").click(function() {
				//验证审核
				if("${login.kuaikeStatus}"==0){
					//提示
				    layer.open({
				    	content: '您的身份还没有通过审核！',
				    	skin: 'msg',
				    	time: 2
				  	});
				  	return false;
				}
				$(this).addClass("active").siblings().removeClass("active");
			});
	
			$(".oallCont_muen div").click(function() {
				//验证审核
				if("${login.kuaikeStatus}"==0){
					//提示
				    layer.open({
				    	content: '您的身份还没有通过审核！',
				    	skin: 'msg',
				    	time: 2
				  	});
				  	return false;
				}
				$(this).addClass("active").siblings().removeClass("active");
			});
			
			//我的快递
			$("#express").click(function(){
				//验证审核
				if("${login.kuaikeStatus}"==0){
					//提示
				    layer.open({
				    	content: '您的身份还没有通过审核！',
				    	skin: 'msg',
				    	time: 2
				  	});
				  	return false;
				}
				$("#div_statusQiang").css("display","block");
				$("#div_statusXia").css("display","none");
			});
			
			//我的发货
			$("#delivery").click(function(){
				//验证审核
				if("${login.kuaikeStatus}"==0){
					//提示
				    layer.open({
				    	content: '您的身份还没有通过审核！',
				    	skin: 'msg',
				    	time: 2
				  	});
				  	return false;
				}
				$("#div_statusQiang").css("display","none");
				$("#div_statusXia").css("display","block");
			});
		});
	</script>
	<script type="text/javascript" src="<%=basePath%>APP/js/layer.js" ></script>
	<!-- 下单ajax -->
	<script type="text/javascript">
		//默认
		$(function() {
			statusHref('x0');
		});
	
		//ajax
		function loadmore(status) {
			var url=$("#"+status).attr("url");
			//alert(url);
			//请求
			$.ajax({
				type : 'get',
				url : url,
				dataType : 'html',
				success : function(objs) {
					var data = jQuery.parseJSON(objs);
					//var data = page.list;
					if (data == "") {
						//提示
					    layer.open({
					    	content: '没有数据！',
					    	skin: 'msg',
					    	time: 2
					  	});
					} else {
						var result = ''
						for (var i = 0; i < data.length; i++) {
							//类型
							var shopType = data[i].shopType > 0 ? '不易碎' : '易碎';
							//状态
							status = data[i].status == 0 ? '未接单' : data[i].status;
							status = data[i].status == 1 ? '已接单,未取货' : status;
							status = data[i].status == 2 ? '已到达,未确认' : status;
							status = data[i].status == 3 ? '交易结束(待评价)' : status;
							status = data[i].status == 4 ? '已评价' : status;
							//价格
							var prioes=data[i].kaikePrioes==null?'未付款':data[i].kaikePrioes;
							
							var str=data[i].status > 0 ? '派' :'快';
							//date 格式化时间
							//var date=new Date(data[i].okDate);
							//var dataStr=date.getUTCFullYear()+"."+date.getMonth()+"."+date.getDate()+"  "+date.toLocaleTimeString();
							result += "<li><a href='" + url+"/"+data[i].xiaId  + "'><img class='oallCont_cont_img' title='' \
										alt='' src='<%=basePath%>APP/images/oall001.jpg' width='100%' /> \
										<div class='oallCont_contBox'> \
											<p>收货人：" + data[i].shouhuoName + "</p> \
											<p>电话：" + data[i].shouhuoShone + "</p> \
											<div> \
												<span>收货地址：</span> \
												<div class='text_1_hide'>" + data[i].shouhuoAddressInfo + "</div> \
											</div> \
										</div> \
										<div class='oall_zt'>" + str + "</div> <span class='oall_ztl'>" + status + "</span>\
										</a></li>";
	
	
						}
						$('.oallCont_cont_list').append(result);
	
					}
				},
				error : function(xhr, type) {
						//提示
					    layer.open({
					    	content: 'Ajax error',
					    	skin: 'msg',
					    	time: 2
					  	});
				}
			});
		}
	
		//状态
		function statusHref(status) {
					//验证审核
					if("${login.kuaikeStatus}"==0){
						//提示
					    layer.open({
					    	content: '您的身份还没有通过审核！',
					    	skin: 'msg',
					    	time: 2
					  	});
						return false;
					}			
					$('.oallCont_cont_list').html("");
					loadmore(status);
		}
	</script>
		<!-- 验证身份 初级验证 -->
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

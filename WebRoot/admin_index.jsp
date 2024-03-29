<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>系统主页</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body style="background-color:#f2f9fd;">
<%
  //获取session对象绑定的属性userID的值
  String userID=(String)session.getAttribute("userID");
%>
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/logo.jpg" class="radius-circle rotate-hover" height="50" alt="" />食堂后台管理系统</h1>
  </div>
  <div class="head-l" ><a href="" target="_blank" style="color:#FFF" ><span class="icon-user"></span> 欢迎 <%=userID %></a>&nbsp;&nbsp;<a class="button button-little bg-green" href="admin_index.jsp" target="_blank" ><span class="icon-home"></span> 首页</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="servlet/loginServlet?type=adminLoginout"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  
  
  <h2><span class="icon-user"></span>信息管理</h2>
  <ul style="display:block">
    <li><a href="servlet/accountantServlet?type=list" target="right"><span class="icon-caret-right"></span>会计信息管理</a></li>
    <li><a href="servlet/cashierServlet?type=list" target="right"><span class="icon-caret-right"></span>出纳信息管理</a></li>
    <li><a href="servlet/canteenAdminServlet?type=list" target="right"><span class="icon-caret-right"></span>食堂管理员信息管理</a></li> 
    <li><a href="servlet/buyerServlet?type=list" target="right"><span class="icon-caret-right"></span>食堂采购员信息管理</a></li>
    <li><a href="servlet/staffServlet?type=list" target="right"><span class="icon-caret-right"></span>机关工作人员信息管理</a></li> 
    <li><a href="servlet/adminServlet?type=list" target="right"><span class="icon-caret-right"></span>个人信息管理</a></li>  
  </ul> 
  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">欢迎界面</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a>  </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="welcome.html" name="right" width="100%" height="100%"></iframe>
</div>
</body>

</html>

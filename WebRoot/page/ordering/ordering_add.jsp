<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_menu" %>
<%@ page language="java" import="com.gxuwz.bean.BO.actionmenu" %>
<%@ page language="java" import="java.sql.*" %>
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
<title>订单信息添加</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<% String staffID = (String)session.getAttribute("userID");
java.util.Date date = new java.util.Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
String orderingID = staffID+sdf.format(date) ;
%>
<%
actionmenu as =new actionmenu();  		
List<sys_menu> sl=as.listmenu();
String index = request.getParameter("index");
sys_menu tl = sl.get(Integer.parseInt(index));
%>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>下单</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/orderingServlet?type=add">  
      <div class="form-group">
        <div class="label">
          <label>订单编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=orderingID %>" name="orderingID" readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>菜品名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getMenuName() %>" name="menuName" readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
          <!-- 输出值menuID，staffID为servlet取值做准备 -->
          <input type="hidden" class="input w50" value="<%=tl.getMenuID() %>" name="menuID"   />
           <input type="hidden" class="input w50" value="<%=staffID %>" name="staffID"   />
        <div class="form-group">
        <div class="label">
          <label>菜品价格：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getPrice() %>" name="price" readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
        <div class="form-group">
        <div class="label">
          <label>下单数量：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="orderingNum"   />
          <div class="tips"></div>
        </div>
      </div>
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div> </form>
      </div>
    
  </div>


</body>
</html>

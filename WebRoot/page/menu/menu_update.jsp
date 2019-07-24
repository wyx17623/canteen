<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.actionmenu" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_menu" %>

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
<title>菜品信息修改</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%
	actionmenu as =new actionmenu();  		
List<sys_menu> sl=as.listmenu();
String index = request.getParameter("index");
sys_menu tl = sl.get(Integer.parseInt(index));
%>
<div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/menuServlet?type=update">  
      <div class="form-group">
        <div class="label">
          <label>菜品编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getMenuID() %>" name="menuID"  readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>菜品名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getMenuName() %>" name="menuName"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>菜品描述：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getMenuDescription()%>" name="menuDescription"   />
          <div class="tips"></div>
        </div>
      </div>
          <div class="form-group">
        <div class="label">
          <label>菜品价格：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getPrice() %>" name="price"   />
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

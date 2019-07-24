<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_admin "%>
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
<title>管理员信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 管理员信息列表</strong> </div>
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
  
         <th>管理员ID</th>
         <th>姓名</th>
         <th>联系电话</th>
         <th>操作</th>
         

      </tr>
    
			<%  List<sys_admin> sl =(List<sys_admin>)request.getAttribute("adminlist");			
			int index=1;
			Iterator<sys_admin> it = sl.iterator();
			while(it.hasNext()){
				
				sys_admin st = (sys_admin) it.next();
				String adminID=st.getAdminID();
				String adminName = st.getAdminName();
				String adminTel = st.getAdminTel();
				
				  %>
				
		
			<tr>
				 <td><%=index++ %></td>
				  <td><%=adminID %></td>
				 <td><%=adminName %></td>
			     <td><%=adminTel %></td>
			
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/admin/admin_update.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 修改</a> </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
</form>
</body>
</html>

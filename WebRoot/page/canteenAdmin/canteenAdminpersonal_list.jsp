<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_canteenadmin"%>
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
<title>食堂管理员个人列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 个人信息列表</strong> </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
  
         <th>编号</th>
         <th>姓名</th>
         <th>电话</th>
         <th>操作</th>
         

      </tr>
    
			<%
    				List<sys_canteenadmin> sl = (List<sys_canteenadmin>)request.getAttribute("canteenAdminlist");			
    				int index=1;
    				Iterator<sys_canteenadmin> it = sl.iterator();
    				while(it.hasNext()){
    					sys_canteenadmin st = (sys_canteenadmin) it.next();
    					String canteenAdminID=st.getCanteenAdminID();
    					String canteenAdminName = st.getCanteenAdminName();
    					String canteenAdminTel = st.getCanteenAdminTel();
    			%>
				
		
			<tr>
				 <td><%=index++ %></td>
				  <td><%=canteenAdminID %></td>
				 <td><%=canteenAdminName %></td>
				  <td><%=canteenAdminTel %></td>
			
			
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/canteenAdmin/canteenAdminpersonal_update.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 修改</a>  </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
</form>
</body>
</html>

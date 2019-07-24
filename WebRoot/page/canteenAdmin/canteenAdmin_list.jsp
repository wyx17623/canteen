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
<title>食堂管理员列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 食堂管理员信息列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li> <a class="button border-main icon-plus-square-o" href="page/canteenAdmin/canteenAdmin_add.jsp"> 添加食堂管理员信息</a> </li>
       
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
  
         <th>食堂管理员编号</th>
         <th>食堂管理员名称</th>
         <th>食堂管理员联系电话</th>
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
				 <a class="button border-main" href="<%=path%>/page/canteenAdmin/canteenAdmin_update.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="<%=path%>/servlet/canteenAdminServlet?type=remove&canteenAdminID=<%=canteenAdminID%>" ><span class="icon-trash-o"></span> 删除</a>  </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
</body>
</html>

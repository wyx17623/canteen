<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_menu"%>
<%@ page language="java" import="java.sql.*" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%--                                   注意此页面用来给机关工作人员查看使用                                         --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>菜品信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 菜品信息列表</strong> </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
  
         <th>菜品编号</th>
         <th>菜品名称</th>
         <th>菜品描述</th>
         <th>菜品价格</th>
         <th>操作</th>
         

      </tr>
    
			<% 
    				List<sys_menu> sl = (List<sys_menu>)request.getAttribute("menulist");			
    				int index=1;
    				Iterator<sys_menu> it = sl.iterator();
    				while(it.hasNext()){
    					sys_menu st = (sys_menu) it.next();
    					String menuID=st.getMenuID();
    					String menuName = st.getMenuName();
    					String menuDescription= st.getMenuDescription();
    					String price =st.getPrice();
    			%>
				
		
			<tr>
				 <td><%=index++ %></td>
				  <td><%=menuID %></td>
				 <td><%=menuName %></td>
				  <td><%=menuDescription %></td>
			      <td><%=price %></td>
			
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/ordering/ordering_add.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 选择</a></div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
</body>
</html>

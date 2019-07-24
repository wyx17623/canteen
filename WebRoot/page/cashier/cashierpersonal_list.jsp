<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_cashier"%>
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
<title>出纳个人信息列表</title>
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
				
  
         <th>工号</th>
         <th>姓名</th>
         <th>联系电话</th>
         <th>操作</th>
         

      </tr>
    
			<% 
    				List<sys_cashier> sl = (List<sys_cashier>)request.getAttribute("cashierlist");			
    				int index=1;
    				Iterator<sys_cashier> it = sl.iterator();
    				while(it.hasNext()){
    					sys_cashier st = (sys_cashier) it.next();
    					String cashierID=st.getCashierID();
    					String cashierName = st.getCashierName();
    					String cashierTel = st.getCashierTel();
    			%>
				
		
			<tr>
				 <td><%=index++ %></td>
				  <td><%=cashierID %></td>
				 <td><%=cashierName %></td>
				  <td><%=cashierTel %></td>
			
			
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/cashier/cashierpersonal_update.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 修改</a>   </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
</form>
</body>
</html>

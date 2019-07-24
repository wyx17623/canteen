<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listorderingcount"%>
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
<title>订单信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 订单信息列表</strong> </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
  
         <th>套餐编号</th>
         <th>套餐名称</th>
         <th>订购数量</th>
         
         

      </tr>
    
			<% 
    				List<listorderingcount> sl = (List<listorderingcount>)request.getAttribute("orderingcountlist");			
    				int index=1;
    				Iterator<listorderingcount> it = sl.iterator();
    				while(it.hasNext()){
    					listorderingcount st = (listorderingcount) it.next();
    					String menuID=st.getMenuID();
    					String menuName = st.getMenuName();
    					String orderingNum = st.getOrderingNum();
    			%>
				
		
			<tr>
					<td><%=index++%></td>
					<td><%=menuID%></td>
					<td><%=menuName%></td>
					<td><%=orderingNum%></td>
					
					<td>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
</form>
</body>
</html>

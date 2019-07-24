<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listexpenditure"%>
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
<title>消费统计单</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>
<!--                        会计查询所有人每个月的消费情况 -->
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 消费信息列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li> <a class="button border-main icon-plus-square-o" href="servlet/shoppinglistServlet?type=updatelist"> 导出信息</a> </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
				<tr>
					<th>序号</th>
					<th>工号</th>
					<th>姓名</th>
					<th>月份</th>
					<th>用餐次数</th>
					<th>消费总金额</th>

				</tr>

				<%
					List<listexpenditure> sl = (List<listexpenditure>) request
							.getAttribute("orderinglist");
					int index = 1;
					Iterator<listexpenditure> it = sl.iterator();
					while (it.hasNext()) {
						listexpenditure st = (listexpenditure) it.next();
						String staffID = st.getStaffID();
						String staffName = st.getStaffName();
						String months = st.getMonths();
						String mealNum = st.getMealNum();
						String totalCost = st.getTotalCost();
				%>
				
		
			<tr>
				 <td><%=index++ %></td>
				  <td><%=staffID %></td>
				 <td><%=staffName %></td>
				  <td><%=months %></td>
				   <td><%=mealNum %></td>
				 <td><%=totalCost %></td>
			
			
				
			</tr>
	<%} %>
    </table>
  </div>
</form>
</body>
</html>

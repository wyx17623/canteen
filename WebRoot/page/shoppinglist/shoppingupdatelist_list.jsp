<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listshoppinglist"%>
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
<title>采购清单</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>
<!--                                  采购员查看的未审核的采购单界面 未审核即：可修改-->
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 采购信息列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li> <a class="button border-main icon-plus-square-o" href="page/shoppinglist/shoppinglist_add.jsp"> 填写采购清单</a> </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
				<tr>
					<th>序号</th>
					<th>采购单号</th>
					<th>采购人</th>
					<th>采购总金额</th>
					<th>采购时间</th>
					<th>审核状态</th>
					<th>操作</th>


				</tr>

				<%
					List<listshoppinglist> sl = (List<listshoppinglist>) request.getAttribute("shoppinglist");
					int index = 1;
					Iterator<listshoppinglist> it = sl.iterator();
					while (it.hasNext()) {
						listshoppinglist st = (listshoppinglist) it.next();
						String shoppingID = st.getShoppingID();
						String buyerName = st.getBuyerName();
						String totalMenoy = st.getTotalMoney();
						String shoppingtime = st.getShoppingTime();
						String status = st.getStatus();
				%>
				
		
			<tr>
				 <td><%=index++ %></td>
				  <td><%=shoppingID %></td>
				 <td><%=buyerName %></td>
				  <td><%=totalMenoy %></td>
				   <td><%=shoppingtime %></td>
				 <td><%=status %></td>
			
			
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/shoppinglist/shoppinglist_update.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="<%=path%>/servlet/shoppinglistServlet?type=remove&shoppingID=<%=shoppingID%>" ><span class="icon-trash-o"></span> 删除</a>  </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
</form>
</body>
</html>

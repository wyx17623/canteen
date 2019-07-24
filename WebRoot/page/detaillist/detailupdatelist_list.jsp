<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_detaillist"%>
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
<title>采购明细清单</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>
                                 <!-- 可修改的采购明细单的页面显示 -->
<body>
<%String shoppingID = (String)request.getAttribute("shoppingID");%>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 采购明细信息列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li> <a class="button border-main icon-plus-square-o" href="page/detaillist/detaillist_add.jsp?shoppingID=<%=shoppingID%>"> 填写采购明细单</a> </li>
       
      </ul>
    </div>
    <table class="table table-hover text-center">
				<tr>
					<th>序号</th>
					<th>采购单号</th>
					<th>明细单号</th>
					<th>原材料名称</th>
					<th>单价</th>
					<th>数量</th>
					<th>供应商</th>
					<th>操作</th>
				</tr>

				<%
					List<sys_detaillist> sl = (List<sys_detaillist>)request
							.getAttribute("detaillist");
					int index = 1;
					Iterator<sys_detaillist> it = sl.iterator();
					while (it.hasNext()) {
						sys_detaillist st = (sys_detaillist) it.next();
						String detailListID = st.getDetailListID();
						       shoppingID = st.getShoppingID();
						String materialsName = st.getMaterialsName();
						String price = st.getPrice();
						String materialsNum = st.getMaterialsNum();
						String supplier = st.getSupplier();
						
				%>
			<tr>
					<td><%=index++%></td>
					<td><%=shoppingID%></td>
					<td><%=detailListID%></td>
					<td><%=materialsName%></td>
					<td><%=price%></td>
					<td><%=materialsNum%></td>
					<td><%=supplier%></td>
					<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/detaillist/detaillist_update.jsp?index=<%=index-2%>&shoppingID=<%=shoppingID%>"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="<%=path%>/servlet/detaillistServlet?type=remove&detailListID=<%=detailListID %>&shoppingID=<%=shoppingID %>" ><span class="icon-trash-o"></span> 删除</a>  </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
</form>
</body>
</html>

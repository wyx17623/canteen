<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listtakefoodrecord"%>
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
<title>消费记录信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 消费记录信息列表</strong> </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
  
         <th>记录编号</th>
         <th>套餐名称</th>
         <th>订购数量</th>
         <th>剩余数量</th>
         <th>下单时间</th>
      
         

      </tr>
    
			<% 
    				List<listtakefoodrecord> sl = (List<listtakefoodrecord>)request.getAttribute("takefoodrecordlist");			
    				int index=1;
    				Iterator<listtakefoodrecord> it = sl.iterator();
    				while(it.hasNext()){
    					listtakefoodrecord st = (listtakefoodrecord) it.next();
    					String orderingID=st.getOrderingID();
    					String menuName = st.getMenuName();
    					String SurplusNum = st.getSurplusNum();
    					String takefoodtime =st.getTakefoodtime();
    			%>
			<tr>
					<td><%=index++%></td>
					<td><%=orderingID%></td>
					<td><%=menuName%></td>
					<td><%=SurplusNum%></td>
					<td><%=takefoodtime%></td>
					
					<td>
				
				<div class="button-group"></div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
</form>
</body>
</html>

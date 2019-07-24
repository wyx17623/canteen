<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.base.database" %>
<%@ page language="java" import="com.gxuwz.bean.entity.sys_accountant"%>
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
<title>会计个人信息列表</title>
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
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				
          <th>工号</th>
         <th>姓名</th>        
         <th>联系电话</th>
         <th>操作</th>
         

      </tr>
    
			<%
    				List<sys_accountant> sl = (List<sys_accountant>)request.getAttribute("accountantlist");
    				
    				
    				int index=1;
    				Iterator<sys_accountant> it = sl.iterator();
    				while(it.hasNext()){
    					sys_accountant st = (sys_accountant) it.next();
    					String accountantName =st.getAccountantName();
    					String accountantID = st.getAccountantID();
    					
    					String Telephone= st.getAccountantTel();
    			%>
				
		
			<tr>
				 <td><%=index++ %></td>			  
				 <td><%=accountantID %></td>
				 <td><%=accountantName %></td>
			    <td><%=Telephone %></td>
			
				<td>
				<div class="button-group">
				 <a class="button border-main" href="<%=path%>/page/accountant/accountantpersonal_update.jsp?index=<%=index-2%>"><span class="icon-edit"></span> 修改</a> </div>
				</td>
			</tr>
	<%} %>
    </table>
  </div>
</form>
</body>
</html>

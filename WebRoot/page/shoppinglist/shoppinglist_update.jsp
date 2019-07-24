<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.actionshoppinglist" %>
<%@ page language="java" import="com.gxuwz.bean.vo.listshoppinglist" %>

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
<title>采购清单修改</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<% String buyerID = (String)session.getAttribute("userID");
	actionshoppinglist as =new actionshoppinglist(buyerID);  		
List<listshoppinglist> sl=as.listshoppingUpdatelist();
String index = request.getParameter("index");
listshoppinglist tl = sl.get(Integer.parseInt(index));
%>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改采购信息</strong></div>
  <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <li> <a class="button border-main icon-plus-square-o" href="servlet/detaillistServlet?type=updatelist&shoppingID=<%=tl.getShoppingID()%>">管理明细单</a> </li>
      </ul>
    </div>
  <div class="body-content">
  
    <form method="post" class="form-x" action="servlet/shoppinglistServlet?type=update">  
      <div class="form-group">
        <div class="label">
          <label>采购单号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getShoppingID() %>" name="shoppingID"  readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>采购人：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getBuyerName() %>" name="buyerName" readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
       <input type="hidden" class="input w50" value="<%=buyerID %>" name="buyerID" readonly="readonly"  />
      
      
          <input type="hidden" class="input w50" value="<%=tl.getTotalMoney() %>" name="totalMoney"   />
         
        <div class="form-group">
        <div class="label">
          <label>采购时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=tl.getShoppingTime() %>" name="shoppingTime"   />
          <div class="tips"></div>
        </div>
      </div>
       <input type="hidden" class="input w50" value="0" name="status"   />
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div> </form>
      </div>
    
  </div>


</body>
</html>

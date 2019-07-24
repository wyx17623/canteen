<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page language="java" import="java.text.SimpleDateFormat"%>
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
<title>填写采购明细单</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<%  String buyerID=(String)session.getAttribute("userID");
  java.util.Date date = new java.util.Date();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
  String detailListID = "cg"+sdf.format(date);
  String shoppingID = request.getParameter("shoppingID");
  %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>填写采购明细信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/detaillistServlet?type=add">  
     <div class="form-group">
        <div class="label">
          <label>采购单号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=shoppingID %>" name="shoppingID"  readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>采购明细单号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=detailListID%>" name="detailListID"  readonly="readonly"  />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>原材料名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="materialsName"   />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>原材料数量：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="materialsNum"   />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>单价：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="price"   />
          <div class="tips"></div>
        </div>
      </div>
        <div class="form-group">
        <div class="label">
          <label>供应商：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="supplier"   />
          <div class="tips"></div>
        </div>
      </div>     <div class="form-group">
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

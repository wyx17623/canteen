<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.gxuwz.bean.BO.SelectBuyerName"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--                             采购单填写页面                                                      -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>填写采购清单</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>

<% 
//说明：采购清单的单号由系统生成，时间为获取的系统时间，

String buyerID=(String)session.getAttribute("userID");
  java.util.Date date = new java.util.Date();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
  String shoppingID = buyerID+sdf.format(date);
  SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
  String shoppingTime= sf.format(date);
  SelectBuyerName abn = new SelectBuyerName();
  String buyerName=abn.selectBuyerName(buyerID);
  %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>填写采购信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="servlet/shoppinglistServlet?type=add">  
      <div class="form-group">
        <div class="label">
          <label>采购单号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=shoppingID %>" name="shoppingID"  readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>采购人：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=buyerName %>" name="buyerName"   />
          <div class="tips"></div>
        </div>
      </div>
      <input type="hidden" class="input w50" value="<%=buyerID %>" name="buyerID"   />
       
          <input type="hidden" class="input w50" value="0" name="totalMoney"   />
       <div class="form-group">
        <div class="label">
          <label>采购时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=shoppingTime %>" name="shoppingTime"   />
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

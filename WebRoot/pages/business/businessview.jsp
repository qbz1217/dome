<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>企业用户 </title>
    <!-- Bootstrap -->
	    	<script src="<%=path %>/js/jquery.min.js"></script>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/my.css" rel="stylesheet">
	<script src="<%=path %>/js/bootstrap.min.js"></script>
<script src="<%=path %>/js/laydate/laydate.js"></script>
 <script src="<%=path %>/ueditor/ueditor.config.js"></script>
       <script src="<%=path %>/ueditor/ueditor.all.js"></script>
  <script src="<%=path %>/layer/layer.js"></script>


</head>
<body>  
 <jsp:include flush="true" page="../header.jsp"></jsp:include>


<table class="table table-hover table-striped table-bordered">
 <tr><th class="text-center">${c.name }详情 &nbsp; &nbsp;
 <a href="<%=path %>/positionAll?business=${c.id }" class="btn btn-info">查看职位</a>
 
 <c:if test="${ sessionScope.userType == 2}"> 
  <a href="<%=path %>/tousuadd?business=${c.id }" class="btn btn-success">我要投诉</a>
 
 </c:if>
 </th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>



<tr>
<td class="text-right"> 注册资金：</td>
<td>${c.zijin }</td>
</tr>
<tr>
<td class="text-right"> 公司地址：</td>
<td>${c.addr }</td>
</tr>
<tr>
<td class="text-right"> 联系电话：</td>
<td>${c.tel }</td>
</tr>
<tr>
<td class="text-right"> 公司介绍：</td>
<td>${c.jieshao }</td>
</tr></thead></table> </body>
 </html> <jsp:include page="../foot.jsp"></jsp:include>
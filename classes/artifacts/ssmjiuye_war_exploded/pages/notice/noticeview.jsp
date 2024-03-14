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
    <title>新闻公告 </title>
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
 <tr><th class="text-center">${c.title } &nbsp; &nbsp;</th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>



<c:if test="${not empty c.pic}">  <tr><td colspan=2>

   <img src="<%=path %>${c.pic}" class="img-rounded" style="width: 300px;height: 300px;">

</td></tr></c:if><c:if test="${empty c.pic}"></c:if>

<tr>
<td class="text-right"> 内容：</td>
<td>${c.neirong }</td>
</tr>
<tr>
<td class="text-right"> 时间：</td>
<td>${c.addtime }</td>
</tr></thead></table> </body>
 </html>   <jsp:include page="../foot.jsp"></jsp:include>
 
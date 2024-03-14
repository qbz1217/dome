<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%><jsp:include flush="true" page="../header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>招聘职位 </title>
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
<div class="container">


<table class="table table-hover table-striped table-bordered">
 <tr><th class="text-center">${c.businessfk.name}详情 &nbsp; &nbsp; 
 <a href="<%=path %>/positionAll?business=${c.business}" class="btn btn-default">查看${c.businessfk.name}的其他职位</a>
        <c:if test="${sessionScope.userType == 2}">
         | <a href="<%=path %>/sqadd?buname=${c.uname }&uname=${sessionScope.loginname}&position=${c.id }" class="btn btn-info">申请职位</a> 
        
        </c:if>
 </th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>
<tr>
<td class="text-right"> 职位名称：</td>
<td>${c.name }</td>
</tr>
<tr>
<td class="text-right"> 职位类别：</td>
<td>${c.zleibie }</td>
</tr>
<tr>
<td class="text-right"> 工作地点：</td>
<td>${c.didian }</td>
</tr>
<tr>
<td class="text-right"> 招聘人数：</td>
<td>${c.renshu }</td>
</tr>
<tr>
<td class="text-right"> 学历要求：</td>
<td>${c.xyaoqiu }</td>
</tr>
<tr>
<td class="text-right"> 岗位工资：</td>
<td>${c.price }</td>
</tr>
<tr>
<td class="text-right"> 点击量：</td>
<td>${c.hits }</td>
</tr>
<tr>
<td class="text-right"> 发布时间：</td>
<td>${c.stime }</td>
</tr>
<tr>
<td class="text-right"> 职位详情：</td>
<td>${c.details }</td>
</tr>
<tr>
<td class="text-right"> 发布企业：</td>
<td>${c.uname }</td>
</tr>
<tr>
</tr>
 </thead>
</table>
</div>
</body>
 </html> <jsp:include page="../foot.jsp"></jsp:include>
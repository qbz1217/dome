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
    <title>简历 </title>
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
 <tr><th class="text-center">${c.memberfk.name} 的简历详情 &nbsp; &nbsp;

 </th></tr></table>

<table class="table table-hover table-striped table-bordered">
 <thead>
 <tr>

<th>姓名</th>

<th>免冠照片</th>

<th>出生日期</th>

<th>联系电话</th>

<th>性别</th>

<th>邮箱</th>

</tr></thead>
<c:forEach items="${requestScope.member}" var="s"  varStatus="ss">

 <tbody><tr>

<td>${s.name}</td>

<td>
			<c:if test="${not empty s.pic}">  
				<img src="<%=path %>${s.pic}" class="img-rounded" style="width: 100px;height: 100px;"></c:if>
			<c:if test="${empty s.pic}">无图</c:if>
			</td>

<td>${s.sdate}</td>

<td>${s.tel}</td>

<td>${s.sex}</td>

<td>${s.email}</td>

</tr></tbody>
</c:forEach>
<table class="table table-hover table-striped table-bordered">
 <thead>
<tr>
<td class="text-right"> 简历名称：</td>
<td>${c.name }</td>
</tr>
<tr>
<td class="text-right"> 籍贯：</td>
<td>${c.jiguan }</td>
</tr>
<tr>
<td class="text-right"> 身高：</td>
<td>${c.shengao }</td>
</tr>
<tr>
<td class="text-right"> 体重：</td>
<td>${c.tizhong }</td>
</tr>
<tr>
<td class="text-right"> 所在院校：</td>
<td>${c.school }</td>
</tr>
<tr>
<td class="text-right"> 求职类型：</td>
<td>${c.zleibie }</td>
</tr>
<tr>
<td class="text-right"> 学历：</td>
<td>${c.xueli }</td>
</tr>
<tr>
<td class="text-right"> 政治面貌：</td>
<td>${c.mianmao }</td>
</tr>
 <tr><td class="text-right">简历附件</td><td>
<c:if test="${not empty c.zfile}"><a href="<%=path %>${c.zfile}" class="btn btn-default" target="_blank">下载</a></c:if>
<c:if test="${empty c.zfile}">未上传</c:if>
</td></tr>

<tr>
<td class="text-right"> 月薪要求：</td>
<td>${c.yuexin }</td>
</tr>
<tr>
<td class="text-right"> 专业：</td>
<td>${c.zhuanye }</td>
</tr>
<tr>
<td class="text-right"> 应聘岗位：</td>
<td>${c.gangwei }</td>
</tr>
<tr>
<td class="text-right"> 爱好特长：</td>
<td>${c.techang }</td>
</tr>
<tr>
<td class="text-right"> 教育经历：</td>
<td>${c.jingli }</td>
</tr>
<tr>
<td class="text-right"> 自我介绍：</td>
<td>${c.jieshao }</td>
</tr>
<tr>
<td class="text-right"> 点击率：</td>
<td>${c.hits }</td>
</tr>
<tr>

<tr>
<td class="text-right"> 所属用户：</td>
<td>${c.uname }</td>
</tr>
<tr>
<td class="text-right"> 简历创建时间：</td>
<td>${c.stime }</td>
</tr></thead></table> </body>
 </html> <jsp:include page="../foot.jsp"></jsp:include>
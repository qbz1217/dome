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
    <title>教师 </title>
    <!-- Bootstrap -->
	    	<script src="<%=path %>/js/jquery.min.js"></script>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/my.css" rel="stylesheet">
	<script src="<%=path %>/js/bootstrap.min.js"></script>
<script  src="<%=path %>/js/laydate/laydate.js"></script>
	<script type="text/javascript">
		</script>
	      

</head>

<table   class="table table-hover">
 <tr> <th>
<form name="formsea" class="form-inline" role="form" method="post" action="<%=path %>/jiaoshiAll">
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="name" id="name" class="form-control" placeholder="姓名" style="width:120px" />
	</div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="xueyuan" id="xueyuan" class="form-control" placeholder="学院" style="width:120px" />
	</div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="tel" id="tel" class="form-control" placeholder="电话" style="width:120px" />
	</div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="email" id="email" class="form-control" placeholder="邮箱" style="width:120px" />
	</div>
  </div>

 <button type="submit"  class="btn  btn-primary">查询</button>

          </form>   </th>
        </tr>    
</table>

<table class="table table-hover table-striped table-bordered">
 <tr><th>教师列表 &nbsp; &nbsp; 
</th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>
 <tr>
<th>序号</th>

<th>姓名</th>

<th>性别</th>

<th>学院</th>

<th>电话</th>

<th>邮箱</th>


	<!--<th>操作</th>--></tr></thead>
<c:forEach items="${requestScope.page.data}" var="c"  varStatus="ss">

 <tbody><tr>
<td>${ss.index+1}</td>

<td>${c.name}</td>

<td>${c.sex}</td>

<td>${c.xueyuan}</td>

<td>${c.tel}</td>

<td>${c.email}</td>

<%--  <td><a href="<%=path %>/add?xx=${c.xx}&xx=${c.xx}" class="btn btn-info">添加</a></td>--%></tr></tbody>
</c:forEach> </table><script type="text/javascript">
	       function go(index)
           {
               window.location.href="<%=path %>/jiaoshiAll?index="+index;
           }
</script>
<jsp:include flush="true" page="/pages/jsp_pages.jsp"></jsp:include>


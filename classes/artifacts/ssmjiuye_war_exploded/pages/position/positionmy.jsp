<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
    <title>招聘职位 </title>
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
<form name="formsea" class="form-inline" role="form" method="post" action="<%=path %>/positionmy">
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="name" id="name" class="form-control" placeholder="职位名称"/>
	</div>
  </div>


   <div class="form-group">
       <div class="col-sm-2">
       <select name="zleibie" class="form-control">
<option value="">请选择职位类别</option>
<c:forEach items="${zleibie}" var="s"  varStatus="ss">
   <option value="${s.name}">${s.name}</option>
</c:forEach>
		 </select> 
		 </div>
   </div>
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="didian" id="didian" class="form-control" placeholder="工作地点"/>
	</div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="renshu" id="renshu" class="form-control" placeholder="招聘人数"/>
	</div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="xyaoqiu" id="xyaoqiu" class="form-control" placeholder="学历要求"/>
	</div>
  </div>

 <button type="submit"  class="btn  btn-primary">查询</button>

          </form>   </th>
        </tr>    
</table>

<table class="table table-hover table-striped table-bordered">
 <tr><th>我的招聘职位列表 &nbsp; &nbsp; 
 <!--
 <button type="button" onclick="location.href='<%=path %>/positionadd'" class="btn  btn-primary">添加</button>
 -->
</th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>
 <tr>
<th>序号</th>
<th>职位名称</th>
<th>职位类别</th>
<th>工作地点</th>
<th>招聘人数</th>
<th>学历要求</th>
<th>岗位工资</th>
<th>点击量</th>
<th>发布时间</th>
<th>查看详情</th><th>审核状态</th>
<th>操作</th></tr></thead>
<c:forEach items="${requestScope.page.data}" var="c"  varStatus="ss">

 <tbody><tr>
<td>${ss.index+1}</td>

<td>${c.name}</td>

<td>${c.zleibie}</td>

<td>${c.didian}</td>

<td>${c.renshu}</td>

<td>${c.xyaoqiu}</td>

<td>${c.price}</td>

<td>${c.hits}</td>

<td>${c.stime}</td>
<td><a href="<%=path %>/positionview?id=${c.id}" class="btn-default" target="_blank">查看详情</a></td>
<td>${c.zt}</td>

<td>
  <c:if test="${c.zt=='未审核'}">
 <a href="<%=path %>/positionedit?id=${c.id}&forword=positionmy" class="btn btn-default">修改</a> |

  </c:if>
    <a href="positiondel?id=${c.id}&forword=positionmy" onClick="return confirm('您确定要删除吗?')" class="btn btn-default">删除</a>
 </td>
</tr></tbody>
</c:forEach> </table><script type="text/javascript">
	       function go(index)
           {
               window.location.href="<%=path %>/positionmy?index="+index;
           }
</script>
<table class="table table-hover table-striped table-bordered">
						        <tr>
							        <td>
							                  共<span style="color:#FF0000">${requestScope.page.totle}</span>条记录&nbsp;&nbsp;&nbsp;&nbsp;
							                  每页<span style="color:#FF0000">${requestScope.page.pageSize}</span>条&nbsp;&nbsp;&nbsp;&nbsp;
							                  第<span style="color:#FF0000">${requestScope.page.index}</span>页/共${requestScope.page.totlePage}页&nbsp;&nbsp;&nbsp;&nbsp;
							                <c:if test="${requestScope.page.index==1}">
							                       首&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;
							                </c:if>
							                <c:if test="${requestScope.page.index!=1}">
							                       <a style="color: red" href="#" onclick="go(1)">首&nbsp;&nbsp;页</a>
							                       &nbsp;&nbsp;&nbsp;&nbsp;
							                       <a style="color: red" href="#" onclick="go(${requestScope.page.index-1})">上一页</a>
							                       &nbsp;&nbsp;&nbsp;&nbsp;
							                </c:if>
							                <c:if test="${requestScope.page.index >= requestScope.page.totlePage}">
							                          下一页&nbsp;&nbsp;&nbsp;&nbsp;末&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
							                </c:if>
							                <c:if test="${requestScope.page.index < requestScope.page.totlePage}">
							                       <a style="color: red" href="#" onclick="go(${requestScope.page.index+1})">下一页</a>
							                       &nbsp;&nbsp;&nbsp;&nbsp;
							                       <a style="color: red" href="#" onclick="go(${requestScope.page.totlePage})">末&nbsp;&nbsp;页</a>
							                </c:if>
							        </td>
						       </tr>
  </table>
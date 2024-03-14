<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
<script  src="<%=path %>/js/laydate/laydate.js"></script>
	<script type="text/javascript">
		</script>
	      

</head>

<table   class="table table-hover">
 <tr> <th>
<form name="formsea" class="form-inline" role="form" method="post" action="<%=path %>/resumeAll">
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="name" id="name" class="form-control" placeholder="简历名称"/>
	</div>
  </div>
  

  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="school" id="school" class="form-control" placeholder="院校"/>
	</div>
  </div>

<!--
   <div class="form-group">
       <div class="col-sm-2">
       <select name="zleibie" class="form-control">
<option value="">请选择求职类型</option>
<c:forEach items="${zleibie}" var="s"  varStatus="ss">
   <option value="${s.name}">${s.name}</option>
</c:forEach>
		 </select>
		 </div>
   </div>
   -->
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="xueli" id="xueli" class="form-control" placeholder="学历"/>
	</div>
  </div>

  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="zhuanye" id="zhuanye" class="form-control" placeholder="专业"/>
	</div>
  </div>

 <button type="submit"  class="btn  btn-primary">查询</button>

          </form>   </th>
        </tr>    
</table>

<table class="table table-hover table-striped table-bordered">
 <tr><th>简历列表 &nbsp; &nbsp; 
</th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>
 <tr>
<th>序号</th>

<th>简历名称</th>



<th>所在院校</th>

<th>求职类型</th>

<th>学历</th>

<th>简历附件</th>

<th>月薪要求</th>

<th>专业</th>

<th>查看详情</th>

<th>点击率</th>

</tr></thead>
<c:forEach items="${requestScope.page.data}" var="c"  varStatus="ss">

 <tbody><tr>
<td>${ss.index+1}</td>

<td>${c.name}</td>



<td>${c.school}</td>

<td>${c.zleibie}</td>

<td>${c.xueli}</td>


<td>
		<c:if test="${not empty c.zfile}"><a href="<%=path %>${c.zfile}" class="btn btn-default" target="_blank">下载</a></c:if>
		<c:if test="${empty c.zfile}">未上传</c:if>
		</td>

<td>${c.yuexin}</td>

<td>${c.zhuanye}</td>


<td><a href="<%=path %>/resumeview?id=${c.id}" class="btn-default" >查看详情</a></td>

<td>${c.hits}</td>



</tr></tbody>

</c:forEach> </table><script type="text/javascript">
	       function go(index)
           {
               window.location.href="<%=path %>/resumeAll?index="+index;
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
  </table></body>
</html> <jsp:include page="../foot.jsp"></jsp:include>
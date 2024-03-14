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
    <title>投递简历 </title>
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


<script>
function check()
{

 if (document.formAdd.buname.value=="")
  {
    alert("企业用户不能为空！");
    document.formAdd.buname.focus();
    return false;
  }

 if (document.formAdd.shuoming.value=="")
  {
    alert("留言不能为空！");
    document.formAdd.shuoming.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="squpdate" class="form-horizontal" role="form">
<fieldset> <legend>修改投递简历</legend>

<input type="hidden" name="id" value="${c.id}"/>


<div class="form-group">
    <label class="col-sm-2 control-label" for="buname">企业用户</label>
      <div class="col-sm-4">
<input name="buname" type="text" id="buname"  value="${c.buname}"  class="form-control" >
 </div>
	</div>


   <div class="form-group">
   <label for="position"  class="col-sm-2 control-label">职位</label>
       <div class="col-sm-2">
       <select name="position" class="form-control">
   <c:forEach items="${position}" var="s"  varStatus="ss">
   <option value="${s.id}"<c:if test="${s.id eq c.position}"> selected</c:if>>${s.name}</option>
</c:forEach>
		 </select> 
		 </div>
   </div>
<script type="text/javascript">
function upzfile()
		    {
 layer.open({
   type: 2,
 title: '上传',
  skin: 'layui-layer-rim', //加上边框
  area: ['420px', '340px'], //宽高
  content: '<%=path %>/upload/upload.jsp?upname=zfile'
  ,btn: ['关闭'] //只是为了演示
});
		  	     
		    }
</script>
<div class="form-group">
   <label class="col-sm-2 control-label" for="zfile">简历附件</label>
    <div class="col-sm-4">
	<input type="text" name="zfile" id="zfile" value="${c.zfile}" readonly class="form-control" placeholder="点击上传"/>
           <button type="button" class="btn  btn-primary" onclick="upzfile()">点击上传</button>
		</div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="shuoming">留言</label>
      <div class="col-sm-4">
<input name="shuoming" type="text" id="shuoming"  value="${c.shuoming}"  class="form-control" >
 </div>
	</div>

<input name="zt" type="hidden" value="未审核">

	</fieldset>  
   <fieldset>
     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
			 <input name="forword" type="hidden" value="${param.forword}"/>
           <button type="button" class="btn  btn-primary" onclick="check()">保存数据</button>
	 <button type="button" class="btn btn-default" onClick="history.back(-1)">返回</button>

    </div>
</div>
	 </fieldset>
</form>
</div>
    </body>
 </html>  
  
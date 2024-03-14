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


<script>
function check()
{

 if (document.formAdd.name.value=="")
  {
    alert("职位名称不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.didian.value=="")
  {
    alert("工作地点不能为空！");
    document.formAdd.didian.focus();
    return false;
  }

 if (document.formAdd.renshu.value=="")
  {
    alert("招聘人数不能为空！");
    document.formAdd.renshu.focus();
    return false;
  }

 if (document.formAdd.xyaoqiu.value=="")
  {
    alert("学历要求不能为空！");
    document.formAdd.xyaoqiu.focus();
    return false;
  }

 if (document.formAdd.price.value=="")
  {
    alert("岗位工资不能为空！");
    document.formAdd.price.focus();
    return false;
  }

 if (document.formAdd.details.value=="")
  {
    alert("职位详情不能为空！");
    document.formAdd.details.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="positionupdate" class="form-horizontal" role="form">
<fieldset> <legend>修改招聘职位</legend>

<input type="hidden" name="id" value="${c.id}"/>


<div class="form-group">
    <label class="col-sm-2 control-label" for="name">职位名称</label>
      <div class="col-sm-4">
<input name="name" type="text" id="name"  value="${c.name}"  class="form-control" >
 </div>
	</div>


   <div class="form-group">
   <label for="zleibie"  class="col-sm-2 control-label">职位类别</label>
       <div class="col-sm-2">
       <select name="zleibie" class="form-control">
   <c:forEach items="${zleibie}" var="s"  varStatus="ss">
   <option value="${s.name}"<c:if test="${s.name eq c.zleibie}"> selected</c:if>>${s.name}</option>
</c:forEach>
		 </select> 
		 </div>
   </div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="didian">工作地点</label>
      <div class="col-sm-4">
<input name="didian" type="text" id="didian"  value="${c.didian}"  class="form-control" >
 </div>
	</div>
<div class="form-group">
   <label class="col-sm-2 control-label" for="renshu">招聘人数</label>
    <div class="col-sm-4">
	<input name="renshu" type="text" id="renshu" value="${c.renshu }" class="form-control"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">

	</div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="xyaoqiu">学历要求</label>
      <div class="col-sm-4">
<input name="xyaoqiu" type="text" id="xyaoqiu"  value="${c.xyaoqiu}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="price">岗位工资</label>
      <div class="col-sm-4">
<input name="price" type="text" id="price"  value="${c.price}"  class="form-control" >
 </div>
	</div>
<div class="form-group">
   <label class="col-sm-2 control-label" for="details">职位详情</label>
    <div class="col-sm-4">
						      <textarea name="details" id="details" style="width:500px;height:340px">${c.details }</textarea>
	                            <script type="text/javascript">
UE.getEditor('details',{toolbars:[['FullScreen', 'Source','Undo', 'Redo','Bold','test']],wordCount:false,elementPathEnabled:false,
            initialFrameHeight:200,initialFrameWidth:340})   </script>
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
  
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


<script>
function check()
{

 if (document.formAdd.name.value=="")
  {
    alert("简历名称不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.jiguan.value=="")
  {
    alert("籍贯不能为空！");
    document.formAdd.jiguan.focus();
    return false;
  }

 if (document.formAdd.shengao.value=="")
  {
    alert("身高不能为空！");
    document.formAdd.shengao.focus();
    return false;
  }

 if (document.formAdd.tizhong.value=="")
  {
    alert("体重不能为空！");
    document.formAdd.tizhong.focus();
    return false;
  }

 if (document.formAdd.school.value=="")
  {
    alert("所在院校不能为空！");
    document.formAdd.school.focus();
    return false;
  }

 if (document.formAdd.xueli.value=="")
  {
    alert("学历不能为空！");
    document.formAdd.xueli.focus();
    return false;
  }

 if (document.formAdd.mianmao.value=="")
  {
    alert("政治面貌不能为空！");
    document.formAdd.mianmao.focus();
    return false;
  }

 if (document.formAdd.yuexin.value=="")
  {
    alert("月薪要求不能为空！");
    document.formAdd.yuexin.focus();
    return false;
  }

 if (document.formAdd.zhuanye.value=="")
  {
    alert("专业不能为空！");
    document.formAdd.zhuanye.focus();
    return false;
  }

 if (document.formAdd.gangwei.value=="")
  {
    alert("应聘岗位不能为空！");
    document.formAdd.gangwei.focus();
    return false;
  }

 if (document.formAdd.techang.value=="")
  {
    alert("爱好特长不能为空！");
    document.formAdd.techang.focus();
    return false;
  }

 if (document.formAdd.jingli.value=="")
  {
    alert("教育经历不能为空！");
    document.formAdd.jingli.focus();
    return false;
  }

 if (document.formAdd.jieshao.value=="")
  {
    alert("自我介绍不能为空！");
    document.formAdd.jieshao.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="resumeupdate" class="form-horizontal" role="form">
<fieldset> <legend>修改简历</legend>

<input type="hidden" name="id" value="${c.id}"/>


<div class="form-group">
    <label class="col-sm-2 control-label" for="name">简历名称</label>
      <div class="col-sm-4">
<input name="name" type="text" id="name"  value="${c.name}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="jiguan">籍贯</label>
      <div class="col-sm-4">
<input name="jiguan" type="text" id="jiguan"  value="${c.jiguan}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="shengao">身高</label>
      <div class="col-sm-4">
<input name="shengao" type="text" id="shengao"  value="${c.shengao}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="tizhong">体重</label>
      <div class="col-sm-4">
<input name="tizhong" type="text" id="tizhong"  value="${c.tizhong}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="school">所在院校</label>
      <div class="col-sm-4">
<input name="school" type="text" id="school"  value="${c.school}"  class="form-control" >
 </div>
	</div>


   <div class="form-group">
   <label for="zleibie"  class="col-sm-2 control-label">求职类型</label>
       <div class="col-sm-2">
       <select name="zleibie" class="form-control">
   <c:forEach items="${zleibie}" var="s"  varStatus="ss">
   <option value="${s.name}"<c:if test="${s.name eq c.zleibie}"> selected</c:if>>${s.name}</option>
</c:forEach>
		 </select> 
		 </div>
   </div>

<div class="form-group">
    <label for="xueli"  class="col-sm-2 control-label">学历</label>
    <div class="col-sm-2">
   <select class="form-control" name="xueli">
      <option value="专科" <c:if test="${c.xueli=='专科'}"> selected</c:if>>专科</option>
  <option value="本科" <c:if test="${c.xueli=='本科'}"> selected</c:if>>本科</option>
  <option value="硕士" <c:if test="${c.xueli=='硕士'}"> selected</c:if>>硕士</option>
  <option value="博士" <c:if test="${c.xueli=='博士后'}"> selected</c:if>>博士</option>
  <option value="博士后" <c:if test="${c.xueli=='博士后'}"> selected</c:if>>博士后</option>
   <option value="其他" <c:if test="${c.xueli=='其他'}"> selected</c:if>>其他</option>
    </select>
    </div>
 </div>
<div class="form-group">
    <label for="mianmao"  class="col-sm-2 control-label">政治面貌</label>
    <div class="col-sm-2">
   <select class="form-control" name="mianmao">
  <option value="团员">团员</option>
  <option value="积极分子">积极分子</option>
 <option value="预备党员">预备党员</option>
  <option value="党员" selected="selected">党员</option>
  <option value="其他" >其他</option>

 </select>
    </div>
 </div><script type="text/javascript">
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
    <label class="col-sm-2 control-label" for="yuexin">月薪要求</label>
      <div class="col-sm-4">
<input name="yuexin" type="text" id="yuexin"  value="${c.yuexin}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="zhuanye">专业</label>
      <div class="col-sm-4">
<input name="zhuanye" type="text" id="zhuanye"  value="${c.zhuanye}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="gangwei">应聘岗位</label>
      <div class="col-sm-4">
<input name="gangwei" type="text" id="gangwei"  value="${c.gangwei}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="techang">爱好特长</label>
      <div class="col-sm-4">
<input name="techang" type="text" id="techang"  value="${c.techang}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="jingli">教育经历</label>
      <div class="col-sm-4">
<input name="jingli" type="text" id="jingli"  value="${c.jingli}"  class="form-control" >
 </div>
	</div>
<div class="form-group">
   <label class="col-sm-2 control-label" for="jieshao">自我介绍</label>
    <div class="col-sm-4">
						      <textarea name="jieshao" id="jieshao" style="width:500px;height:340px">${c.jieshao }</textarea>
	                            <script type="text/javascript">
UE.getEditor('jieshao',{toolbars:[['FullScreen', 'Source','Undo', 'Redo','Bold','test']],wordCount:false,elementPathEnabled:false,
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
  
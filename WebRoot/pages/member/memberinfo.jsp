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
    <title>学生 </title>
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

 if (document.formAdd.username.value=="")
  {
    alert("登录名不能为空！");
    document.formAdd.username.focus();
    return false;
  }

 if (document.formAdd.pwd.value=="")
     {
      alert("密码不能为空！")
           return false;
     }
	  if (document.formAdd.pwd.value!=document.formAdd.repwd.value)
     {
      alert("输入的密码不一致！");
          return false;
     }

 if (document.formAdd.name.value=="")
  {
    alert("姓名不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.sdate.value=="")
  {
    alert("出生日期不能为空！");
    document.formAdd.sdate.focus();
    return false;
  }

 if (document.formAdd.tel.value=="")
  {
    alert("联系电话不能为空！");
    document.formAdd.tel.focus();
    return false;
  }

 if (document.formAdd.email.value=="")
  {
    alert("邮箱不能为空！");
    document.formAdd.email.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="memberinfosave" class="form-horizontal" role="form">
<fieldset> <legend>修改学生</legend>

<input type="hidden" name="id" value="${c.id}"/>


<div class="form-group">
    <label class="col-sm-2 control-label" for="username">登录名</label>
      <div class="col-sm-4">
<input name="username" type="text" id="username"  value="${c.username}" readonly class="form-control" >不可更改
 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="pwd">登录密码</label>
              <div class="col-sm-4">
<input name="pwd" type="password" id="pwd" class="form-control" placeholder="输入密码" >
 </div>
	</div>
<div class="form-group">
             <label class="col-sm-2 control-label" for="repwd">确认密码</label>
              <div class="col-sm-4">
<input name="repwd" type="password" id="repwd" class="form-control" placeholder="确认密码" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="name">姓名</label>
      <div class="col-sm-4">
<input name="name" type="text" id="name"  value="${c.name}"  class="form-control" >
 </div>
	</div>
<script type="text/javascript">
function uppic()
		    {
 layer.open({
   type: 2,
 title: '上传',
  skin: 'layui-layer-rim', //加上边框
  area: ['420px', '340px'], //宽高
  content: '<%=path %>/upload/upload.jsp?upname=pic'
  ,btn: ['关闭'] //只是为了演示
});
		  	     
		    }
</script>
<div class="form-group">
   <label class="col-sm-2 control-label" for="pic">免冠照片</label>
    <div class="col-sm-4">
	<input type="text" name="pic" id="pic" value="${c.pic}" readonly class="form-control" placeholder="点击上传"/>
           <button type="button" class="btn  btn-primary" onclick="uppic()">点击上传</button>
		</div>
	</div>


<div class="form-group">
   <label class="col-sm-2 control-label" for="sdate">出生日期</label>
    <div class="col-sm-4">
	<input name="sdate" type="text" id="sdate" class="form-control" value="${c.sdate}"/>
	<script>laydate.render({elem: '#sdate'});</script>

</div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="tel">联系电话</label>
      <div class="col-sm-4">
<input name="tel" type="text" id="tel"  value="${c.tel}"  class="form-control" >
 </div>
	</div>

<div class="form-group">
 <label class="col-sm-2 control-label" for="ds_password">性别</label>
   <div class="col-sm-4 radio text-left"">
    <label>  <input type="radio" name="sex"  value="男" checked> 男 </label>
    <label>  <input type="radio" name="sex"  value="女"> 女 </label>
    
   </div>
</div>

<div class="form-group">
    <label class="col-sm-2 control-label" for="email">邮箱</label>
      <div class="col-sm-4">
<input name="email" type="text" id="email"  value="${c.email}"  class="form-control" >
 </div>
	</div>

	</fieldset>  
   <fieldset>
     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
			 <input name="forword" type="hidden" value="memberinfo?id=${param.id}"/>
           <button type="button" class="btn  btn-primary" onclick="check()">保存</button>
	    </div>
</div>
	 </fieldset>
</form>
</div>
    </body>
 </html>  
  
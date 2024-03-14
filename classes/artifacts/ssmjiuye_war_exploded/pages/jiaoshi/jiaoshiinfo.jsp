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
<script>
function check()
{

 if (document.formAdd.name.value=="")
  {
    alert("姓名不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.xueyuan.value=="")
  {
    alert("学院不能为空！");
    document.formAdd.xueyuan.focus();
    return false;
  }

 if (document.formAdd.tel.value=="")
     {
      alert("手机不能为空！")
           return false;
     }
	 var phone = document.getElementById('tel').value;
 if(!(/^1[34578]\d{9}$/.test(phone))){ 
     alert("手机号码有误，请重填");  
     return false; 
 } 

 if (document.formAdd.email.value=="")
     {
      alert("邮箱不能为空！")
           return false;
     }
 var email = document.getElementById("email");//获得邮箱输入框对象
  var regex = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
  				//判断
 if(!regex.test(email.value))
 {
	alert("邮箱格式不正确");
  return false;
} 

 if (document.formAdd.username.value=="")
  {
    alert("账号不能为空！");
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
 if(document.formAdd.pwd.value.length<5){
	   alert("密码长度不能小于5位！");
	   return false
	 }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="jiaoshiinfosave" class="form-horizontal" role="form">
<fieldset> <legend>修改教师</legend>

<input type="hidden" name="id" value="${c.id}"/>


<div class="form-group">
    <label class="col-sm-2 control-label" for="name">姓名</label>
      <div class="col-sm-4">
<input name="name" type="text" id="name"  value="${c.name}"  class="form-control" >
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
    <label class="col-sm-2 control-label" for="xueyuan">学院</label>
      <div class="col-sm-4">
<input name="xueyuan" type="text" id="xueyuan"  value="${c.xueyuan}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="tel">电话</label>
      <div class="col-sm-4">
<input name="tel" type="text" id="tel"  value="${c.tel}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="email">邮箱</label>
      <div class="col-sm-4">
<input name="email" type="text" id="email"  value="${c.email}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="username">账号</label>
      <div class="col-sm-4">
<input name="username" type="text" id="username"  value="${c.username}" readonly class="form-control" >不可更改
 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="pwd">登录密码</label>
              <div class="col-sm-4">
<input name="pwd" type="password" id="pwd" class="form-control" value="${c.pwd}">
 </div>
	</div>
<div class="form-group">
             <label class="col-sm-2 control-label" for="repwd">确认密码</label>
              <div class="col-sm-4">
<input name="repwd" type="password" id="repwd" class="form-control" value="${c.pwd}">
 </div>
	</div>

	</fieldset>  
   <fieldset>
     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
			 <input name="forword" type="hidden" value="jiaoshiinfo?id=${param.id}"/>
           <button type="button" class="btn  btn-primary" onclick="check()">保存</button>
	    </div>
</div>
	 </fieldset>
</form>
</div>
    </body>
 </html>  
  
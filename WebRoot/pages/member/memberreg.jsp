<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
 <jsp:include flush="true" page="../header.jsp"></jsp:include>

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
 var phone = document.getElementById('tel').value;
 if(!(/^1[34578]\d{9}$/.test(phone))){ 
     alert("手机号码有误，请重填");  
     return false; 
 } 
 if (document.formAdd.email.value=="")
  {
    alert("邮箱不能为空！");
    document.formAdd.email.focus();
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
document.formAdd.submit();
}
</script>

<div style="width:950px;margin:0 auto">
<table   class="table table-hover">
 <tr> <th><form name="formAdd" method="post" action="<%=path %>/memberreg" class="form-horizontal" role="form">
	<fieldset> <legend>用户注册</legend>	

<div class="form-group">
             <label class="col-sm-2 control-label" for="username">登录名</label>
              <div class="col-sm-4">
<input name="username" type="text" id="username" value="" placeholder="登录名" class="form-control" >
 

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
<input name="name" type="text" id="name" value="" placeholder="姓名" class="form-control" >
 

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
	<input type="text" name="pic" id="pic" readonly class="form-control" placeholder="点击上传"/>
           <button type="button" class="btn  btn-primary" onclick="uppic()">点击上传</button>
			</div>
	</div>

<div class="form-group">
   <label class="col-sm-2 control-label" for="sdate">出生日期</label>
    <div class="col-sm-4">
<input name="sdate" type="text" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" id="sdate" class="form-control" />
<script>laydate.render({elem: '#sdate'});</script>
</div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="tel">联系电话</label>
              <div class="col-sm-4">
<input name="tel" type="text" id="tel" value="" placeholder="联系电话" class="form-control" >
 

 </div>
	</div>

<div class="form-group">
 <label class="col-sm-2 control-label" >性别</label>
   <div class="col-sm-4 radio text-left">
    <label>  <input type="radio" name="sex"  value="男" checked> 男 </label>
    <label>  <input type="radio" name="sex"  value="女"> 女 </label>
    
   </div>
</div>
<div class="form-group">
             <label class="col-sm-2 control-label" for="email">邮箱</label>
              <div class="col-sm-4">
<input name="email" type="text" id="email" value="" placeholder="邮箱" class="form-control" >
 

 </div>
	</div>


     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10">
			       <input name="forword" type="hidden" value="<%=path%>/index.jsp"/>
           <button type="button" class="btn  btn-primary" onclick="check()">注册</button>
	 <button type="button" class="btn btn-default" onClick="history.back(-1)">返回</button>
    </div>
</div>
	 </fieldset>
</form>

</th></tr></table>
</div>
    </body>
 </html>  
    <jsp:include page="../foot.jsp"></jsp:include>
  
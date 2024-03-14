<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/css.css" />
<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/sdmenu.js"></script>

</head>

<body>
<div class="header">
	 <div class="logo">后台管理系统</div>
				<div class="header-right">
				   <i class="icon-question-sign icon-white"></i>
				    <c:if test="${sessionScope.userType ne 0}">
				    <a href="<%=path %>/" target="_top">返回首页</a> 
				    </c:if>
				   <a href="#" style="font-size:16px">欢迎你:
                  ${sessionScope.loginname}
	                </strong></a>
	                
	                
				   <i class="icon-off icon-white"></i> <a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal" style="font-size:18px">注销</a> 
                <div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:300px; margin-left:-150px; top:30%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						注销系统
					</h3>
				</div>
				<div class="modal-body">
					<p>
						您确定要注销退出系统吗？
					</p>
				</div>
				<div class="modal-footer">
					 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
					 <a class="btn btn-primary" style="line-height:20px;" href="<%=path %>/userLogout" target="_top" >确定退出</a>
				</div>
			</div>
				</div>
</div>
<!-- 顶部 -->
<div id="middle">
     <div class="left">

     <script type="text/javascript">
var myMenu;
window.onload = function() {
	myMenu = new SDMenu("my_menu");
	myMenu.init();
};
</script>

<div id="my_menu" class="sdmenu">
					   <c:if test="${sessionScope.userType==3}">
					   <!--开始-->
 <div class="collapsed">
 <span>学生管理</span>
         <a target="manFrame" href="<%=path %>/memberlist">学生管理</a> 
         <a target="manFrame" href="<%=path %>/memberadd">学生添加</a>
    </div><div class="collapsed">
 <span>统计模块</span>
         <a target="manFrame" href="<%=path %>/membertongji">学生统计</a>
    </div>
	<!--结束-->
	 <div class="collapsed">
 <span>修改个人资料</span>
         <a target="manFrame" href="<%=path %>/jiaoshiinfo?id=${sessionScope.loginid}">修改个人资料</a> 
    </div>
</c:if>
 <c:if test="${sessionScope.userType==0}">
   <div class="collapsed">
 <span>统计模块</span>
         <a target="manFrame" href="<%=path %>/membertongji">学生统计</a>
    </div>
 <div class="collapsed">
 <span>教师管理</span>
     <a target="manFrame" href="<%=path %>/jiaoshilist">教师管理</a>
      <a target="manFrame" href="<%=path %>/jiaoshiadd">教师添加</a> 
    </div>
 <div class="collapsed">
 <span>投诉管理</span>
         <a target="manFrame" href="<%=path %>/tousulist">投诉管理</a> 
    </div>
	<!--结束-->
<!--开始-->
 <div class="collapsed">
 <span>管理员管理</span>
         <a target="manFrame" href="<%=path %>/adminlist">管理员管理</a> 
      <a target="manFrame" href="<%=path %>/adminadd">管理员添加</a> 
    </div>
	<!--结束-->

<!--开始-->
 <div class="collapsed">
 <span>企业用户管理</span>
         <a target="manFrame" href="<%=path %>/businesslist">企业用户管理</a> 
    </div>
	<!--结束-->

<!--开始-->
 <div class="collapsed">
 <span>新闻公告管理</span>
         <a target="manFrame" href="<%=path %>/noticelist">新闻公告管理</a> 
      <a target="manFrame" href="<%=path %>/noticeadd">新闻公告添加</a> 
    </div>
	<!--结束-->
<!--开始-->
 <div class="collapsed">
 <span>招聘审核管理</span>
         <a target="manFrame" href="<%=path %>/positionlist">招聘审核管理</a> 
    </div>
	<!--结束-->
<!--开始-->
 <div class="collapsed">
 <span>简历审核管理</span>
         <a target="manFrame" href="<%=path %>/resumelist">简历审核管理</a> 
    </div>
	<!--结束-->

<!--开始
 <div class="collapsed">
 <span>职位类别管理</span>
         <a target="manFrame" href="<%=path %>/zleibielist">职位类别管理</a> 
      <a target="manFrame" href="<%=path %>/zleibieadd">职位类别添加</a> 
    </div>
	<结束-->
</c:if>
 <c:if test="${sessionScope.userType==1}">
  <div class="collapsed">
 
  <span>收到的简历</span>
         <a target="manFrame" href="<%=path %>/sqlist">收到的简历</a> 
    </div>
 <div class="collapsed">
 <span>招聘职位管理</span>
         <a target="manFrame" href="<%=path %>/positionmy">招聘职位管理</a> 
      <a target="manFrame" href="<%=path %>/positionadd">招聘职位添加</a> 
    </div>
	<!--结束-->
 <div class="collapsed">
 <span>修改个人资料</span>
         <a target="manFrame" href="<%=path %>/businessinfo?id=${sessionScope.loginid}">修改个人资料</a> 
    </div>
	<!--结束-->
	<!--结束-->
</c:if>
 <c:if test="${sessionScope.userType==2}">
  <div class="collapsed">
 <span>简历管理</span>
         <a target="manFrame" href="<%=path %>/resumemy">简历管理</a> 
      <a target="manFrame" href="<%=path %>/resumeadd">简历添加</a> 
    </div>
     <div class="collapsed">
 <span>我投出的简历</span>
         <a target="manFrame" href="<%=path %>/sqmy">我投出的简历</a> 
    </div>
         <div class="collapsed">
 <span>我的投诉</span>
         <a target="manFrame" href="<%=path %>/tousumy">我的投诉</a> 
    </div>
	<!--结束-->
	 <div class="collapsed">
 <span>修改个人资料</span>
         <a target="manFrame" href="<%=path %>/memberinfo?id=${sessionScope.loginid}">修改个人资料</a> 
    </div>
	<!--结束-->


</c:if>
	</div>
     </div>
     <div class="Switch"></div>
     <script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 
		});
});
</script>

     <div class="right"  id="mainFrame">
     
     <div class="right_cont">
  <iframe scrolling="auto" frameborder="0" src="right.jsp" name="manFrame" style="margin:0 auto;" width="100%" height="820"></iframe>

 
</div>
     
     
     </div>     
     </div>
    </div>
    
<!-- 底部 -->

</body>
</html>

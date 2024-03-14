<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="generator" content=""  data-variable=",cn,10001,,10001,M1156015" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <title>学生实习与就业管理系统</title>
        <link rel='stylesheet' href='<%=path %>/css/bootstrap.css'>
        <script src="<%=path %>/js/index.js">
        </script>
        </head>

        <body class=" nav-header">
        <header class=""><div class="head-box">
    <div class="container">
              <div class="head-left">
        <div class="head-left-wrapper">
                  <div class="head-left-slide">
            <p> 欢迎来到学生就业管理系统</p>
            </div>
                </div>
      </div>
              <div class="head-right">
        <div class="head-other"> <span>
          <c:if test="${sessionScope.userType eq null}">
          <a href="<%=path %>/pages/login.jsp"><i class="fa fa-book"></i>用户登录</a> </span>
                  <hr />
                  <span> <a href="<%=path %>/pages/member/memberreg.jsp"><i class="fa fa-book"></i>用户注册</a> </span> <span>
          <hr />
          <a href="<%=path %>/pages/business/businessreg.jsp"><i class="fa fa-book"></i>企业注册</a> </span>
                  </c:if>
                  <span>
          <c:if test="${sessionScope.userType ne null}"> 欢迎您回来 ${sessionScope.loginname } </c:if>
          </span>
                  <c:if test="${sessionScope.userType == 1 || sessionScope.userType == 2 || sessionScope.userType == 3}"> <span>
                    <hr />
                    <a href="<%=path %>/pages/adminindex.jsp">个人中心</a>
                    <hr />
                    <a href="<%=path %>/userLogout">退出</a> </span> </c:if>
                </div>
            </div>
            </div>
  </div>
        </header>
<nav class="navbar navbar-default met-nav " role="navigation">
          <div class="container">
    <div class="navbar-header">
              <button type="button" class="navbar-toggle hamburger hamburger-close collapsed"
                    data-target="#navbar-default-collapse" data-toggle="collapse"> <span class="sr-only"> Toggle navigation </span> <span class="hamburger-bar"> </span> </button>
              <a href="<%=path %>/" class="navbar-brand navbar-logo vertical-align" title="校园招聘">
      <h1 class='hide'> 校园招聘 </h1>
      <div class="vertical-align-middle"> <img src="<%=path %>/picture/tubiao.jpg" alt="校园招聘" title="校园招聘"/> </div>
      </a>
              <h2 class='hide'> </h2>
            </div>

    <div class="collapse navbar-collapse navbar-collapse-toolbar" id="navbar-default-collapse">
              <ul class="nav navbar-nav navbar-right navlist">
        <li class="margin-right-20"> <a href="<%=path %>/" title="首页" class="link active"> 首页 </a> </li>
        <li class="dropdown margin-right-20"> <a class="link  " href="<%=path %>/noticeAll"> 新闻公告 </a>
  <ul style="display:none">
          </ul>
          </li>
          <c:if test="${sessionScope.userType==2||sessionScope.userType==3}">
        <li class="dropdown margin-right-20"> <a class="link  " href="<%=path %>/positionAll">招聘信息 </a> </li>
      <li class="dropdown margin-right-20"> <a class="link  " href="<%=path %>/businessAll">企业信息 </a> </li>
        </c:if>
        <c:if test="${sessionScope.userType==1||sessionScope.userType==3}">
        <li class="dropdown margin-right-20"> <a class="link  " href="<%=path %>/resumeAll">简历信息</a> </li>
         <li class="dropdown margin-right-20"> <a class="link  " href="<%=path %>/memberAll">学生信息</a> </li>
        </c:if>
      </ul>
      </div>
  </div>
        </nav>

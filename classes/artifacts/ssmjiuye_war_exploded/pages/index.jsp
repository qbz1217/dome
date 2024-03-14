<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
%>

<jsp:include page="header.jsp"></jsp:include>
<div class="met-banner" data-height='' style=''>
  <div class="slick-slide"> <img class="cover-image" src="picture/IMG20231226130222.jpg" >
    <div class="banner-text p-1">
      <div class='container'>
        <div class='banner-text-con'>
          <div>
            <h4 class="animation-slide-top" style='color:#eeeeee'> 湖南工业职业技术学院 </h4>
            <p class="animation-slide-bottom animation-delay-300"> 祝你找到称心如意的工作 </p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="slick-slide"> <img class="cover-image" src="picture/IMG20231226130221.jpg" alt="梦想从这里起航">
    <div class="banner-text p-2">
      <div class='container'>
        <div class='banner-text-con'>
          <div>
            <h4 class="animation-slide-top" style='color:#eeeeee'> 梦想从这里起航 </h4>
            <p class="animation-slide-bottom animation-delay-300"> 校园招聘 </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="info-cut">
  <div class="container">
    <div class="title-box">
      <h2> 信息中心 </h2>
      <p> 兼职招聘 </p>
    </div>
    <div class="row">
      <div class="info-box">
        <ul class="info-wraper">
          <li class="info-slide"> <span>
            <h3> 招聘信息 </h3>
            <a href="<%=path %>/positionAll" title="查看更多">
            <hr>
            <hr>
            <hr>
            </a> </span>
            <ol>
              <c:forEach items="${requestScope.pcs}" var="c"  varStatus="ss">
                <li>
                  <h4> <a href="<%=path %>/positionview?id=${c.id}" > ${c.name} </a> </h4>
                  <p> ${c.price} </p>
                  <b><i>${c.stime} </i> <em class="fa fa-tag"> </em>
                  <strong>学历：${c.xyaoqiu} </strong> </b> </li>
              </c:forEach>

            </ol>
          </li>

          <li class="info-slide"> <span>
            <h3>会员企业</h3>
            <a href="<%=path %>/businessAll" title="查看更多">
            <hr>
            <hr>
            <hr>
            </a> </span>
            <ol>
               <c:forEach items="${requestScope.qcs}" var="c"  varStatus="ss">
              <li>
                <h4> <a href="<%=path %>/businessview?id=${c.id}" > ${c.name}</a> </h4>

                <b>  <em class="fa fa-tag"> </em> 电话：${c.tel}<strong> </strong> </b>
              </li>
               </c:forEach>
            </ol>
          </li>

        </ul>
      </div>
    </div>
  </div>
</div>

<jsp:include page="foot.jsp"></jsp:include>

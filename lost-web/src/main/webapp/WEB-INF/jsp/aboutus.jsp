<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>川理寻物招领平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href='https://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body style="background-image:url(${pageContext.request.contextPath}/image/bg.png);">
<div class="tab">
<jsp:include page="shortcut.jsp"></jsp:include>
<table width="100%">
    <tr>
    <td class="tab2">
    	<div class="tab2">
        	<img src="${pageContext.request.contextPath}/image/index.png" width="1280" height="250">
        </div>
    	
    </td>
  </tr>
 
  <tr>
  	<td class="tab3">
		<div class="tab3_left">
        	<div class="top-nav">
            	<span class="menu"> </span>
				<ul>
					<li><a href="${pageContext.request.contextPath}/index">首页</a></li>
					<li><a href="${pageContext.request.contextPath}/lost/list">寻物启事</a></li>
					<li><a href="${pageContext.request.contextPath}/pack/list">失物招领</a></li>
 					<li><a href="${pageContext.request.contextPath}/user/lostthing">发布失物</a></li>
					<li><a href="${pageContext.request.contextPath}/user/packupthing">发布招领</a></li>        
 					<li><a href="${pageContext.request.contextPath}/see/leifeng">雷锋榜</a></li>
					<li><a href="${pageContext.request.contextPath}/to/page/aboutus">关于我们</a></li>
				</ul>
			</div><!--top-nav-->
        </div><!--tab3_left-->
        <div class="tab3_right">
			<form class="navbar-form navbar-left" id="from1" action="${pageContext.request.contextPath}/search" method="post">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="请输入关键词" id="search" name="keywords">
				</div>
				<button type="submit" class="btn btn-default" id="bt1">搜索</button>
			</form>
        </div>
    </td>
  </tr>
  

  <tr><td class="aboutus">
<h2>关于我们：</h2>
<span>川理寻物招领平台是由团队自发建立的公益网站，成立于2018年10月，是为四川理工学院服务的失物招领平台。目的是用网络作为一个媒体，“撮合”拾物者和失物者。社会需要和谐，人人需要互助，人们迫切需要这样的一个平台，让遗失物品的主人能有失而复得的惊喜。</span>

<h2>团队成员：</h2>
<span>蒲潘圣：网站创始人之一，主要负责后端开发，四川理工学院计算机学院物联网工程2016级学生</span></br>
<span>贾思亮：网站创始人之一，主要负责前端开发，四川理工学院计算机学院物联网工程2016级学生</span></br>
<span>刘   鹏：网站创始人之一，主要负责网站美化，四川理工学院计算机学院物联网工程2016级学生</span>

<h2>网站宗旨：</h2>
<span>免费、纯公益</span>

<h2>联系我们：</h2>
<span>新浪微博：四川理工寻物招领平台</span></br>
<span>官方QQ：xxxxxxxxx</span>
  </td></tr>
  
  <tr>
    <td class="tab6">
    	<div class="nav2">
        	<li><a href="">免责声明</a></li>
            <li><a href="">关于我们</a></li>
            <li><a href="">网站合作</a></li>
            <li><a href="">联系我们</a></li>
		</div>
    </td>
  </tr>
  <tr>
    <td class="tab7">
    	<div class="tab7_text">
        	<p>Copyright 2018 Likun Network Technology Limited, All Rights Reserved  <a href="">梦之队</a> 版权所有</p>
            <p>地址：四川省宜宾市. 违法和不良信息举报电话：12377 举报邮箱：<a href="">jubao@12377.cn</a></p>
            <p>提醒：禁止发布任何违反国家法律、法规的言论与图片等内容；本站内容均来自个人观点与网络等信息，非本站认同之观点.权所有</p>
            
            
        </div>    	
    </td>
  </tr>
  
</table>
</div><!--tab-->
</body>
<script type="text/javascript">
$(function(){
	
	  $("#bt1").click(function(){
		  
		
		   
		$("#form1").submit();
		  
		  
	  })
	
	
})
</script>
</html>
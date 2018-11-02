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
  

  <tr>
    <td class="tab5">
    	<div class="tab5_left">
 			<h2>寻物启事</h2>
 			<table class="tab5_left_xw">	
                <tr>
                	<td class="td1" width="35%">物品名称</td>  
                    <td class="td1" width="40%">丢失地点</td>			
                    <td class="td1" width="25%">丢失时间</td>    	
                </tr>	
				<c:forEach items="${item}" var="s">
            	<tr>
                	<td class="td2"><a href="${pageContext.request.contextPath}/detail/lost?id=${s.id}&uid=${s.uid}&type=2">${s.title}</a></td>
                    <td class="td2">${s.location}</td>
                    <td class="td2"><fmt:formatDate value="${s.losttime}" pattern="yyyy-MM-dd"/></td>             
                </tr>
				</c:forEach>
			</table>
        </div>
		
        <div class="tab5_right">
    		<h2>失物招领</h2>
    		<table class="tab5_left_xw">
                <tr>
                	<td class="td1" width="35%">物品名称</td>  
                    <td class="td1" width="40%">拾取地点</td>			
                    <td class="td1" width="25%">拾取时间</td>    	
                </tr>
				<c:forEach items="${packitem}" var="ss"> 
            	<tr>
                	<td class="td2"><a href="${pageContext.request.contextPath}/detail/pack?id=${ss.id}&uid=${ss.uid}&type=2">${ss.title}</a></td>
                    <td class="td2">${ss.location}</td>
                    <td class="td2"><fmt:formatDate value="${ss.losttime}" pattern="yyyy-MM-dd"/></td>            
                </tr>
				</c:forEach>
            </table>
	  	</div>
    </td>
  </tr>
  
  <tr>
		<td class="td3"><a href="${pageContext.request.contextPath}/lost/list">>>更多</a></td>
		<td class="td4"><a href="${pageContext.request.contextPath}/pack/list">>>更多</a></td>
  </tr>
  
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>雷锋榜-川理寻物招领平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href='https://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body style="background-image:url(${pageContext.request.contextPath}/image/bg_leifeng.jpg);positon:relative;">
<div class="leifeng_main">
<div class="leifeng" style="background-image:url(${pageContext.request.contextPath}/image/leifeng.png);"> 
<table class="leifeng_tab">
<tr>
<td><span>排名</span></td>
<td><span>名称</span></td>
<td><span>热心次数</span></td>
</tr>
<c:set var="n" value="${page.currentPageNum}" ></c:set>
<c:forEach  items="${page.records}" var="ss" varStatus="p">
<tr>
<td>${p.count+10*(n-1)}</td>
<td><a href="${pageContext.request.contextPath}/see/yonghu?id=${ss.id}&type=2">${ss.username }</a></td>
<td>${ss.score}</td>
</tr>
</c:forEach>
</table>
<jsp:include page="pageFile.jsp"></jsp:include>
</div>
</div>
</div><!---->
</body>
</html>
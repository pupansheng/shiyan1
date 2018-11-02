<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>个人中心</title>
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
<div class="infself">
<jsp:include page="shortcut.jsp"></jsp:include>
<table>
<tr>
<td style="width:170px;">
<div  class="nav_infself">
<ul>
  <li role="presentation" ><a href="${pageContext.request.contextPath}/user/liuyan" id="a1" name="liuyan.jsp" target="i">我的消息</a></a></li>
  <li role="presentation" ><a href="${pageContext.request.contextPath}/user/fabu" id="a2" name="fabu.jsp" target="i">我的寻物发布</a></li>
  <li role="presentation" ><a href="${pageContext.request.contextPath}/user/fabu/pack" id="a3" name="fabu/pack.jsp" target="i">我的拾物发布</a></li>
  <li role="presentation" ><a href="${pageContext.request.contextPath}/user/toupdate" id="a4" name="toupdate.jsp" target="i">修改个人资料</a></li>
  <li role="presentation" ><a href="${pageContext.request.contextPath}/index">返回首页</a></li>
</ul>
</div>
</td>
<td style="width:10px;"></td><!--设置间隔-->
<td style="width:1100px;">
<iframe src="${pageContext.request.contextPath}/user/liuyan"" id="iframe" name="i" class="ifnm" style="width:1100px;height:700px;"></iframe>
</td>
</tr>
</table>
</div> 
</body>
</html>
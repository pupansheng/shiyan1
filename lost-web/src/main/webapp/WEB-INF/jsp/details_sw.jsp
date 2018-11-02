<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>${packitem.title}-物品详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" type='text/css' href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type='text/css' href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href='https://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body style="background-image:url(${pageContext.request.contextPath}/image/bg.png);">
<div class="tab">
<table width="100%">

  <tr>
	<td class="tab8">
		<h2>${packitem.title}</h2>
		<p>发布时间：<fmt:formatDate value="${packitem.losttime}" pattern="yyyy-MM-dd"/>&emsp;&emsp;发布类型：失物招领</p>
		<div class="tab_sx"></div>
		<div class="tab8_1">发布详情：</div>
			
		<table class="tab8_2">
			<tr><td class="tab8-td1"><span>物品名称：</span></td>
			<td class="tab8-td4"><span>${packitem.title}</span></td></tr>
			<tr><td class="tab8-td1"><span>发布者：</span></td>
			<td class="tab8-td4"><span>${user.username}</span></td></tr>
			<tr><td class="tab8-td1"><span>丢失地点：</span></td>
			<td class="tab8-td4"><span>${packitem.location}</span></td></tr>
			<tr><td class="tab8-td1"><span>联系方式：</span></td>
			<td class="tab8-td4"><span>${user.phone}</span></td></tr>
			<tr><td class="tab8-td1"><span>联系邮箱：</span></td>
			<td class="tab8-td4"><span>${user.mail}</span></td></tr>
			<tr><td class="tab8-td1"><span>联系地点：</span></td>
			<td class="tab8-td4"><span>${user.address}</span></td></tr>
			<tr><td class="tab8-td1"><span>丢失时间：</span></td>
			<td class="tab8-td4"><span><fmt:formatDate value="${packitem.losttime}" pattern="yyyy-MM-dd"/></span></td></tr>
			<tr><td class="tab8-td2"><span>物品图片：</span></td>
			<td  class="tab8-td5">
			<table><tr>
				<c:forEach items="${packitem.images}" var="ww">
					<td >
						<a href="${ww}"><img src="${ww}" height="160px" width="160px" ></img></a>
					</td>
					<td style="width:5px;"></td>
				</c:forEach>
			</tr></table>
			</td></tr>
			
			<tr><td class="tab8-td3"><span>发布者留言：</span></td>
			<td class="tab8-td6"><span>${packitem.itemdesc}</span></td></tr>			
		</table>

	</td>
  </tr>

</table>
</body>
</html>
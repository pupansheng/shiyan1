<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>我的信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href='https://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<body style="background-color:#81BEF7;">
<div class="liuyan_main">
<table class="liuyan">
   <tr>
   <td class="liuyan_td1"><span>留言人</span></td>
   <td class="liuyan_td1"><span>留言物品</span></td>
   <td class="liuyan_td1"><span>留言内容</span></td>
   <td class="liuyan_td1"><span>留言日期</span></td>
   <td class="liuyan_td1"><span>操作</span></td>
  </tr>
  <c:forEach items="${page.records}" var="liuyan">
  <tr>
    <td>
    <c:if test="${liuyan.helpuser.username!=null}">
    <a href="${pageContext.request.contextPath}/see/yonghu?id=${liuyan.helpuser.id}&type=1">${liuyan.helpuser.username}</a>
    </c:if>
    <c:if test="${liuyan.helpuser.username==null}">
         <a href="#"> 游客</a>
    </c:if>
    </td>
   
    <td>
    <c:if test="${liuyan.type==1}">
	<a href="${pageContext.request.contextPath}/detail/lost?id=${liuyan.item.id}&uid=${liuyan.item.uid}&type=1">${liuyan.item.title}</a>
    </c:if>
    <c:if test="${liuyan.type==2}">
	<a href="${pageContext.request.contextPath}/detail/pack?id=${liuyan.item.id}&uid=${liuyan.item.uid}&type=1">${liuyan.item.title}</a>
    </c:if>
    </td>
    <td>
       <a href="#" data-toggle="popover" title="${liuyan.helpuser.username}" data-content="${liuyan.msg.msg}">点击查看</a>
    </td>
        
        
   <%--  <td>${liuyan.msg.msg}</td> --%>
    
    
    
    <td><fmt:formatDate value="${liuyan.msg.createtime}" pattern="yyyy-MM-dd"/></td>
	 
    <td><a href="javascript:void" onclick="fabu('${pageContext.request.contextPath}/liuyan/delete?id=${liuyan.msg.id}')">删除</a></td>
   </tr>
  </c:forEach>
</table>
<div class="fengye">
<jsp:include page="pageFile.jsp"></jsp:include>
</div>
</div><!--liuyan_main-->
</body>
<script type="text/javascript">
$(function () {
	  $('[data-toggle="popover"]').popover()
	})
function fabu(url)
{
	$.post(url);
	alert("删除成功")
	window.location.reload(true);
		
}

$().popover(options);
</script>

</html>
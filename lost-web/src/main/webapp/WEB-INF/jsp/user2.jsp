<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>用户信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href='https://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
</head>
<body style="background-color:#81BEF7;">
 <form id="updatemsg">
 <div class="user_main">
 <table class="user_tab ">
<tr>
<td class="user_td">用户信息</td>
</tr>

 <tr><table class="user_tab"><tr>
 <td class="user_td1">用&nbsp;户&nbsp;名</td>
 <td class="user_td2">${user.username}</td>
 </tr></table></tr>
 
 <tr><table class="user_tab"><tr>
 <td class="user_td1">邮&emsp;箱</td>
 <td class="user_td2">${user.mail}</td>
  </tr></table></tr>
 
 <tr><table class="user_tab"><tr>
 <td class="user_td1">电话号码</td>
 <td class="user_td2">${user.phone}</td>
 </tr></table> </tr>
 
 <tr><table class="user_tab"><tr>
 <td class="user_td1">联系地址</td>
 <td class="user_td2">${user.address}</td>
  </tr></table></tr>
 
</table>
</form>
</div>
<div class="user_back">
<input type="button" value="返回" class="user_back_nav" onclick="tz()"></input>
<script>
function tz(){
    window.location.href="${pageContext.request.contextPath}/return/page?type=2";
}
</script>
</div>
</body>
</html>
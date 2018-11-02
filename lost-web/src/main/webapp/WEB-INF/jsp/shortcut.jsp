<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	<body >
	<script>
	var E = {
	checkLogin : function(){
		$.ajax({
			url : "${pageContext.request.contextPath}/user/token/",
			dataType : "json",
			type : "POST",
			success : function(data){
				if(data.status == 200){
					var username = data.data.username;
				
					var html = username + ",欢迎您！ <a href=\"${pageContext.request.contextPath}/user/logout\" class=\"link-logout\">[退出]&nbsp;&nbsp;&nbsp;<span></a><a href=\"${pageContext.request.contextPath}/user/infself\" class=\"link-logout\">我的信息</a></span>";
				
					$("#loginbar").html(html);
				}
			}
		});
	}
}
$(function(){
	
	// 查看是否已经登录，如果已经登录查询登录信息
	E.checkLogin();
});		
		</script>
<div class="container-fluid">
  <div class="row">
  <div class="col-md-4 col-md-offset-10">
  	   <span id="loginbar" style="margin-right: 15px;">
	      <a href="${pageContext.request.contextPath}/page/login">请登录</a>
	      <a href="${pageContext.request.contextPath}/page/register">免费注册</a>
      	</span>
     
  </div>
</div>
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache,must-revalidate">
    <title>找回密码</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.1.min.js"></script>
</head>
<body>

	<h1 align="center">密码找回</h1>
	邮箱<input  type="text" id="pps" name="mail"/>
	<button id="p1" onclick="cl()">找回密码</button>
<script >
function cl(){
	var s=$("#pps").val();
	var ss="mail="+s
$.ajax({
			url :"${pageContext.request.contextPath}/zhaohui/password",
			 data: ss,
        	success : function(data) {
        		if (data.status=200) {
            		alert("发送成功！新的密码已经发送您的邮箱！！")
        		} else {
        			alert("不存在这个用户")
        		}
        	}
		});

}



</script>
</body>
</html>

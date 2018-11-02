<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
</head>
<body style="background-color: #F3F3F3">
    <div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false" style="width:400px;height:300px;padding:10px;">
       	<div style="margin-left: 50px;margin-top: 50px;">
       	<form id="from1">
       		<div style="margin-bottom:20px;">
	            <div>
	              用户名: <input name="username"   style="width:200px;height:32px" />
	            </div>
	        </div>
	        <div style="margin-bottom:20px">
	            <div>
	            	&nbsp;密&nbsp;&nbsp;码: <input name="password"  type="password" style="width:200px;height:32px"  />
	            </div>
	        </div>
	        <div>
	            <a id="login" href="javascript:void"  style="width:100px;height:32px;margin-left: 50px">登录</a>
	        </div>
	       </form>
       	</div>
    </div>
    
    <script type="text/javascript">
    	$("#login").click(function(){
    
    	
    		$.post("${pageContext.request.contextPath}/user/login",$("#from1").serialize(), function(data){
    			if(data.status ==200){
    				alert('登陆成功');
    				
    				window.location.href="${pageContext.request.contextPath}/user/index";
    			}
    			else
    			{
    				alert('登陆失败!');
    				window.location.reload();
    			}
    			
    			
    		});
    	});
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>修改个人信息</title>
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
 <table class="xiugai">
 <tr style="height:180px;"></tr>
 <tr>
 <td style="width:370px;"></td>
 <td><span>用&ensp;户&ensp;名</span></td><td style="width:5px;"></td>
 <td><span><input type="text"  name="username" id="username"  value="${user.username}" title="${user.username}"></span><span id="uErr"></span></td>
 </tr>
<!--  <tr>
  <td style="width:475px;"></td>
 <td>原密码</td>
 <td><input type="password" id="password" title="${user.password}"><span id="pwErr1"></span></td>
 </tr> -->
  <tr style="height:10px;"></tr>
 <tr>
 <td style="width:370px;"></td>
 <td><span>新&ensp;密&ensp;码</span></td><td style="width:5px;"></td>
 <td><span><input type="password" id="password2" name="password"></span><span id="pwErr"></span></td>
 </tr>
 <tr style="height:10px;"></tr>
 <tr>
 <td style="width:370px;"></td>
 <td><span>&ensp;邮&emsp;箱</span></td><td style="width:5px;"></td>
 <td><span><input type="text" name="mail"  id="mail" value="${user.mail}" title="${user.mail}"></span><span id="mErr"></span></td>
 </tr>
  <tr style="height:10px;"></tr>
  <tr>
 <td style="width:370px;"></td>
 <td><span>电话号码</span></td><td style="width:5px;"></td>
 <td><span><input type="text" name="phone"  id="phone"  value="${user.phone}"></span><span id="pErr"></span></td>
 </tr>
  <tr style="height:10px;"></tr>
  <tr>
 <td style="width:370px;"></td>
 <td><span><span>联系地址</span></td><td style="width:5px;"></td>
 <td><span><input type="text" name="address" id="address" value="${user.address}" ></span><span id="aErr"></span></td>
 </tr>
  <tr style="height:10px;"></tr>
 <tr>
 <td style="width:370px;"></td>
 <td class="xiugai_tdd"><div class="xiugai_tg"><a href="javascript:void" onclick="check()">提交</a></div></td>
 </tr>
</table>
</form>
<script type="text/javascript">
var mob_preg = /^1[3|4|5|7|8][0-9]{9}$/;
var ma_preg =/^\d+@qq\.com$/  
 function check()
 {
	 
	$("span").html('');
	var s=$("#password").attr("title")
	 if($("#username").val()=="")
		 {
		
		 $("#uErr").html('用户名不能为空');
		 return false
		 }
	 if($("#password2").val()=="")
		 {
		
		 $("#pwErr").html('密码不能为空')
		 return false
		
		 }
	/*  if($("#password").val()!=s)
	 {
		
		 $("#pwErr1").html('原密码错误')
		 return false
	 } */
	   if($("#mail").val()=="")
		 {
		
		 $("#mErr").html('邮箱不能为空')
		return false
		 }
	   if(!ma_preg.test($("#mail").val())){
			 $("#mErr").html('邮箱格式不正确')
			return false;
		}
	   
	   
	if($("#phone").val()=="")
		{
		 $("#pErr").html('电话号码不能为空')
	   return false
		}
	 if(!mob_preg.test($("#phone").val())){
		 $("#pErr").html('电话格式不正确')
		return false;
	}
	  if($("#address").val()=="")
		  {
		
		  $("#aErr").html('地址不能为空')
		return false
	 
		  }
	  update();
 }
function  update() {
	
	if($("#username").val()==$("#username").attr("title")&&$("#mail").val()==$("#mail").attr("title"))
		{
		
		 tijiao();
		
	 }
	else if($("#username").val()==$("#username").attr("title")&&$("#mail").val()!=$("#mail").attr("title"))
	{
		
		$.ajax({
			url :"${pageContext.request.contextPath}/regester/check/"+$("#mail").val()+"/2?r=" + Math.random(),
        	success : function(data) {
        		if (data.data) {
            		tijiao()
        		} else {
        			 $("#mErr").html('邮箱已被注册')
        		}
        	}
		});
		
		
		
	}
	else if($("#username").val()!=$("#username").attr("title")&&$("#mail").val()==$("#mail").attr("title"))
	{
		
		$.ajax({
	    	url :"${pageContext.request.contextPath}/regester/check/"+$("#username").val()+"/1?r=" + Math.random()+'.action',
	    	success : function(data) {
	    		if (data.data) {
	    			tijiao()
	    		
	    		} else {
	    			 $("#uErr").html('用户名已存在');
	    		}	
	    	}
		});
		
		
		
	}
	else{
	$.ajax({
    	url :"${pageContext.request.contextPath}/regester/check/"+$("#username").val()+"/1?r=" + Math.random()+'.action',
    	success : function(data) {
    		if (data.data) {
    			//检查qq邮箱是否存在
    			$.ajax({
    				url :"${pageContext.request.contextPath}/regester/check/"+$("#mail").val()+"/2?r=" + Math.random(),
	            	success : function(data) {
	            		if (data.data) {
		            		tijiao()
	            		} else {
	            			 $("#mErr").html('邮箱已被注册')
	            		}
	            	}
    			});
    		} else {
    			 $("#uErr").html('用户名已存在');
    		}	
    	}
	});
	
	}
	
}
function  tijiao()
{
	$.post("${pageContext.request.contextPath}/user/update.action",$("#updatemsg").serialize(), function(data){
		if(data.status == 200){
			alert('提示:修改成功!');
			window.location="${pageContext.request.contextPath}/user/liuyan";
			
		}
		else
			{
			alert('提示:修改失败!');
			window.location.reload();
			}
	})
	
}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>${item.title}-物品详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.1.min.js"></script>
<link rel="stylesheet" type='text/css' href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type='text/css' href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href='https://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>

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
	<td class="tab8">
		<h2>${item.title}</h2>
		<p>发布时间：<fmt:formatDate value="${item.losttime}" pattern="yyyy-MM-dd"/>&emsp;&emsp;发布类型：寻物启事</p>
		<div class="tab_sx"></div>
		<div class="tab8_1">发布详情：</div>
			
		<table class="tab8_2">
			<tr><td class="tab8-td1"><span>物品名称：</span></td>
			<td class="tab8-td4"><span>${item.title}</span></td></tr>
			<tr><td class="tab8-td1"><span>发布者：</span></td>
			<td class="tab8-td4"><span>${user.username}</span></td></tr>
			<tr><td class="tab8-td1"><span>丢失地点：</span></td>
			<td class="tab8-td4"><span>${item.location}</span></td></tr>
			<tr><td class="tab8-td1"><span>联系方式：</span></td>
			<td class="tab8-td4"><span>${user.phone}</span></td></tr>
			<tr><td class="tab8-td1"><span>联系邮箱：</span></td>
			<td class="tab8-td4"><span>${user.mail}</span></td></tr>
			<tr><td class="tab8-td1"><span>联系地点：</span></td>
			<td class="tab8-td4"><span>${user.address}</span></td></tr>
			<tr><td class="tab8-td1"><span>丢失时间：</span></td>
			<td class="tab8-td4"><span><fmt:formatDate value="${item.losttime}" pattern="yyyy-MM-dd"/></span></td></tr>
			<tr><td class="tab8-td2"><span>物品图片：</span></td>
			<td  class="tab8-td5">
			<table><tr>
				<c:forEach items="${item.images}" var="ww">
					<td >
						<a href="${ww}"><img src="${ww}" height="160px" width="160px" ></img></a>
					</td>
					<td style="width:5px;"></td>
				</c:forEach>
			</tr></table>
			</td></tr>
			
			<tr><td class="tab8-td3"><span>发布者留言：</span></td>
			<td class="tab8-td6"><span>${item.itemdesc}</span></td></tr>			
		</table>
	<div class="tab_sx2"></div> 

	 	<div class="tab8_3"> 
	    
			<p>游客留言：</p>
			 <form action="${pageContext.request.contextPath}/help/lost" id="helpmsg" method="post">
				<input type="hidden" value="${user.id}" name="uid"></input>
				<input type="hidden" value="${item.id}" name="iid"></input>
				<textarea id="editor" name="msg" class="form-control" rows="5"></textarea>
			</form>
			<span><button type="button" class="btn btn-success" id="help" onclick="help()">畅言一下</button></span>

		</div>
	</td>
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
<script>
$(function(){
	
	  $("#bt1").click(function(){
		  
		
		   
		$("#form1").submit();
		  
		  
	  })
	
	
})
function help()
{
	if($("#editor").val()== "")
		{
		alert("留言不能为空！")
		return false
		}
	if(confirm("确认提交？"))
	{
		$.post("${pageContext.request.contextPath}/help/lost",$('#helpmsg').serialize(), function(data){
			if(data.status == 200){
				alert('提示:提交成功!');
				window.location.reload();
				
			}
			else
				{
				alert('提示:提交失败!');
				window.location.reload();
				}
		});
		
		  
		
		
	
	}
}
</script>
</body>
</html>

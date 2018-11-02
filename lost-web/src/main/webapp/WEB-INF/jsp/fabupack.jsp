<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>我的发布</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href='https://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.1.min.js"></script>
<body style="background-color:#81BEF7;"> 
<table class="fabupack">
<tr>
<td class="fabupack_td1"><span>物品名称</span></td>
<td class="fabupack_td1"><span>发布日期</span></td>
<td class="fabupack_td1"><span>状态</span></td>
<td class="fabupack_td1"><span>操作</span></td>
<td class="fabupack_td1"><span>操作</span></td>
</tr>
<c:forEach items="${page.records}" var="f">
<tr>
<td>${f.title }</td>
<td><fmt:formatDate value="${f.createtime}" pattern="yyyy-MM-dd"/></td>
<td>
<c:if test="${f.itemstatus==1}">
未找到失主
</c:if>
<c:if test="${f.itemstatus!=1}">
已找到
</c:if>
</td>
<td><a href="javascript:void" onclick="fabu('${pageContext.request.contextPath}/pack/delete?type=1&id=${f.id}')" >取消发布</a></td>
<td><a href="javascript:void" onclick="fabu('${pageContext.request.contextPath}/pack/delete?type=2&id=${f.id}')" >已经帮助找到主人</a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="pageFile.jsp"></jsp:include>


</body>
<script type="text/javascript">
function fabu(url)
{
	
	if(confirm("确定?将会删除此数据！！")){
		
	$.post(url,function(data){
		if(data=200)
			{
			alert("成功")
			window.location.reload();
			}
		else
			{
			alert("失败")
			
			}
	    }
         )
	
    }


}

</script>


</html>
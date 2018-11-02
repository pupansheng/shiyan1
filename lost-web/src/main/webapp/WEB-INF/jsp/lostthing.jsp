<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<title>遗失物品登记-川理寻物招领平台</title>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.1/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/e3.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<link href="${pageContext.request.contextPath}/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
</head>
<body>
<div class="loth">
<div class="loth_main">
<jsp:include page="shortcut.jsp"></jsp:include>
<h2>遗失物品登记</h2>
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>丢失物品名称:</td>
	            <td><input id="p1" class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	  
             <tr>
	            <td>丢失地点</td>
	            <td><input id="p2" class="easyui-textbox" type="text" name="location" data-options="min:1,max:99999999,precision:2,required:true" />
	     
	            </td>
	        </tr>
	         
	      
	            <tr>
	             <td>丢失时间</td>
	            <td><input id="p3" type="date" name="losttime"/>
	            
	            </td>
	            </tr>
	            
	            
	            
	        <tr>
	            <td>数量:</td>
	            <td><input id="p4" class="easyui-numberbox" type="text" name="num" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr>
	        <tr>
	            <td>丢失物品图片:</td>
	            <td>
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	       	  
	            	   <input type="hidden" name="image"/>
	            	 
	            </td>
	        </tr>
	        <tr>
	            <td>你的留言:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
	</form>
	<div class="thing_btn">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    
	</div>
</div><!--loth_main-->
</div><!--loth-->
</body>
<script type="text/javascript">
	var itemAddEditor ;
	
	function imageup()
	{
		
		
		
	}
	
	
	$(function(){
		
		itemAddEditor = E3.createEditor("#itemAddForm [name=desc]");
		
		E3.init({fun:function(node){
			
		
		}});
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if($("#p1").val()== ""){
			alert("请填写完表单！");
			return ;
		}
		if($("#p2").val()== ""){
			alert("请填写完表单！");
			return ;
		}
		if($("#p3").val()== ""){
			alert("请填写完表单！");
			return ;
		}
		if($("#p4").val()== ""){
			alert("请填写完表单！");
			return ;
		}
		
		itemAddEditor.sync();
	
		$.post("${pageContext.request.contextPath}/item/save",$("#itemAddForm").serialize(), function(data){
			if(data.status == 200){
				alert('提示:提交成功!');
				window.location="${pageContext.request.contextPath}/index"
				
			}
			else
				{
				alert('提示:提交失败!');
				window.location.reload();
				}
		});
	}
	
	function clearForm(){
		window.location=reload();
	
		
		
	}
</script>
</html>
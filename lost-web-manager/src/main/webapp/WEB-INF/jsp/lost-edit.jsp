<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="lostEditForm" class="itemForm" method="post">
		<input type="hidden" name="id"/>
	      <table cellpadding="5">
	        <tr>
	            <td>失物名称</td>
	            <td><input class="easyui-textbox" name="title" data-options="required:true" style="width: 280px;" ></input></td>
	        </tr>
	        <tr>
	            <td>丢失地点:</td>
	            <td><input class="easyui-textbox" type="text" name="location" data-options="required:true" style="width: 280px;" />
	            </td>
	        </tr>
	        <tr>
	            <td>丢失数量:</td>
	            <td><input class="easyui-textbox" type="text" name="num" /></td>
	        </tr>
	       
	         </table>
	           <input type="hidden" name="id"/>
	           <input type="hidden" name="uid"/>
	 
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitForm(){
		if(!$('#lostEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
	
		
		$.post("${pageContext.request.contextPath}/rest/lost/update",$("#lostEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改用户信息成功!','info',function(){
					$("#itemEditWindow1").window('close');
					$("#itemList1").datagrid("reload");
				});
			}
		});
	}
</script>

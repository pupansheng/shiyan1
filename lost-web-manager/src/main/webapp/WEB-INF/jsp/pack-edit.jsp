<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="packEditForm" class="itemForm" method="post">
		<input type="hidden" name="id"/>
	      <table cellpadding="5">
	        <tr>
	            <td>拾物名称</td>
	            <td><input class="easyui-textbox" name="title" data-options="required:true" style="width: 280px;" ></input></td>
	        </tr>
	        <tr>
	            <td>拾物地点:</td>
	            <td><input class="easyui-textbox" type="text" name="location" data-options="required:true" style="width: 280px;" />
	            </td>
	        </tr>
	        <tr>
	            <td>拾物数量:</td>
	            <td><input class="easyui-textbox" type="text" name="num" /></td>
	        </tr>
	          <input type="hidden" name="id"/>
	           <input type="hidden" name="uid"/>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm2()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitForm2(){
		if(!$('#packEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
	
		
		$.post("${pageContext.request.contextPath}/rest/pack/update",$("#packEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改用户信息成功!','info',function(){
					$("#itemEditWindow2").window('close');
					$("#itemList2").datagrid("reload");
				});
			}
		});
	}
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemeEditForm" class="itemForm" method="post">
		<input type="hidden" name="id"/>
	      <table cellpadding="5">
	        <tr>
	            <td>用户名:</td>
	            <td><input class="easyui-textbox" type="text" name="username" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>用户密码:</td>
	            <td><input name="passwordd" data-options="required:false" style="width: 280px;" id="p11"></input></td>
	        </tr>
	        <tr>
	            <td>用户状态:</td>
	            <td><input class="easyui-textbox" type="text" name="status" data-options="min:1,max:99999999,precision:2,required:true" />
	            
	            </td>
	        </tr>
	        <tr>
	            <td>用户邮箱:</td>
	            <td><input class="easyui-textbox" type="text" name="mail" max-length="20" /></td>
	        </tr>
	        <tr>
	            <td>用户电话:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="phone" data-options="validType:'length[1,30]'" />
	            </td>
	        </tr>
	        <tr>
	            <td>用户地址:</td>
	            <td>
	            <input class="easyui-textbox" type="text" name="address" style="width: 280px;" data-options="validType:'length[1,60]'" />
	            </td>
	        </tr>
	        <tr>
	            <td>用户分数:</td>
	            <td>
	  
	            <input class="easyui-numberbox" type="text" name="score" data-options="validType:'length[1,30]'" />
	              </td>
	        </tr>
	    </table>
	    <input type="hidden" name="id"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitForm(){
		if(!$('#itemeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
	
		
		$.post("${pageContext.request.contextPath}/rest/item/update",$("#itemeEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改用户信息成功!','info',function(){
					$("#itemEditWindow").window('close');
					$("#itemList").datagrid("reload");
				});
			}
		});
	}
</script>

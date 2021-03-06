<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemList1" title="失物列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'${pageContext.request.contextPath}/user/lost/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">ID</th>
            <th data-options="field:'title',width:150">失物名称</th>
            <th data-options="field:'location',width:100">丢失地点</th>
            <th data-options="field:'num',width:70,align:'right'">丢失数量</th>
            <th data-options="field:'uid',width:70,align:'right'">丢失人</th>
            <th data-options="field:'itemstatus',width:60,align:'center'">状态</th>
  
            <th data-options="field:'losttime',width:130,align:'center',formatter:E3.formatDateTime">丢失日期</th>
            <th data-options="field:'createtime',width:130,align:'center',formatter:E3.formatDateTime">创建日期</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow1" class="easyui-window" title="编辑失物" data-options="modal:true,closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath}/rest/lost/lost-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
       
    	var itemList = $("#itemList1");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    var toolbar = [{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个物品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个物品!');
        		return ;
        	}
        	
        	$("#itemEditWindow1").window({
        		
        		onLoad :function(){
        			//回显数据
        			var data = $("#itemList1").datagrid("getSelections")[0];
        		
        			$("#lostEditForm").form("load",data);
        			
        			
        			
        			
        		;
        			
        		
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中物品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的物品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("${pageContext.request.contextPath}/rest/lost/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除用户成功!',undefined,function(){
            					$("#itemList1").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }]
        
  
            			
</script>
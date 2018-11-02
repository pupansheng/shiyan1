
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
	 if($("#password").val()!=s)
	 {
		 alert("11")
		 $("#pwErr1").html('原密码错误')
		 return false
	 }
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
			window.location='${pageContext.request.contextPath}/index';
			
		}
		else
			{
			alert('提示:修改失败!');
			window.location.reload();
			}
	})
	
}
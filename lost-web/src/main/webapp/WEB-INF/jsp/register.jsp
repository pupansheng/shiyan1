<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache,must-revalidate">
    <title>注册-川理寻物招领平台</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/headerfooter.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.alerts.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/headerfooterindex.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reg.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/passport.common.js?v20140531"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.alerts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/png.js?v20140521"></script>
</head>
<body>
		<!-- header -->
		<div class="header">
			<img src="${pageContext.request.contextPath}/image/register_min.png">
		</div>
		<!--mainStart-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reg.css?v20140432" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/allMail.js?v20140430"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/reg.js?v20150122"></script>
<!-- reg_main -->
<div class="tabBox clear">
   
      <div class="login">已有账号，立即 <a href="${pageContext.request.contextPath}/page/login">登录</a></div>
</div>
<!--个人用户-->
<div class="reg_main reg_border regTab" id="perDiv">
	<div class="reg_left">
    <ul class="individualUserBg">
        <form id="regForm_mod" name="regForm_mod" method="post"  >

           <!--  <li class="regMb30">
                <label><font>*</font> 账户名：</label>
            <span class="regM defaultBorder">
            	<input id="regName" name="username"  class="regInput" type="text" onkeyup="mail_div(event);" onfocus="showtip('regName','userMamErr',8);" onblur="ckmem();" autocomplete="off" maxlength="80"/>
				<em></em>
            </span>
                <span class="regInput" id="userMamErr"></span>
            </li>
            <div node-type="layer" class="accountSearch" style="display:none;" id="person_mail"></div> -->
            <li class="regMb30">
               <label><font>*</font> 账户名：</label>
            <span class="regM defaultBorder">
            	<input id="regName" name="username" autocomplete="off" class="regInput" type="text" maxlength="11" onfocus="showtipa();" onblur="$('#userMamErr').html('')"/>
            	<em></em>
            </span>
                 <span class="regInput" id="userMamErr"></span>
            </li>
            <li>
                <label><font>*</font> 登录密码：</label>
            <span class="regM defaultBorder">
            	<input id="pwd" name="password" class="regInput" autocomplete="off" type="password" onfocus="showPwdtip('password','passwordErr',2);"  onkeyup="ckpwd(0,1);" onblur="ckpwd(0,0);"/>
            	<em ></em>
            </span>
                <span class="regInput" id="passwordErr"></span>
            </li>
            <li class="safetyLayer regPl191" id="pwdStrong">
                <!-- <font style="font-size:12px;">安全程度：</font><em class="default">弱</em><em class="default">中</em><em class="default">强</em> -->
            </li>

            <li class="regMb30">
                <label><font>*</font> 确认密码：</label>
            <span class="regM defaultBorder">
            	<input id="pwdRepeat" name="password2" autocomplete="off" class="regInput" type="password" onfocus="showtip('password2','password2Err',3);" onblur="ckpwd2();"/>
            	<em></em>
            </span>
                <span class="regInput" id="password2Err"></span>
            </li>
          
             <li class="regMb30">
                <label><font>*</font> qq邮箱：</label>
            <span class="regM defaultBorder">
            	<input id="mail" name="mail" autocomplete="off" class="regInput" type="text"  onfocus="showtip11()" onblur="$('#mailErr').html('')"/>
            	<em></em>
            </span>
                <span class="regInput" id="mailErr"></span>
            </li>
            
              <li class="regMb30">
                <label><font>*</font> 联系地址：</label>
            <span class="regM defaultBorder">
            	<input id="address" name="address" autocomplete="off" class="regInput" type="text" maxlength="11" onfocus="showtip22();" onblur="$('#addErr').html('')"/>
            	<em></em>
            </span>
                <span class="regInput" id="addErr"></span>
            </li>
            
            
            
               <li class="regMb30">
                <label><font>*</font> 手机号码：</label>
            <span class="regM defaultBorder">
            	<input id="phone" name="phone" autocomplete="off" class="regInput" type="text" maxlength="11" onfocus="showtip33();" onblur="$('#phoneErr').html('')"/>
            	<em></em>
            </span>
                <span class="regInput" id="phoneErr"></span>
            </li>

            <li class="regPl88">
			<span  class="regM" style="margin-left:29px">
				<input id="AgreeId" name="AgreeId" type="checkbox" checked="" onclick="ckAgree();">
				<a href="#" target="_blank"  class="checkTitle">我已阅读并同意<font style="font-size:12px;">《注册协议》</font></a>
			</span>
                <span  id="AgreeIdErr" ></span>
            </li>
            <li class="register regPl88 regMt10" id="sub_per" style="margin-left:29px">
                <input type="hidden" id="tjuid" name="tjuid" value="">
                <a href="javascript:void(0);" class="registerNow" id="reg_per_data" onclick="REGISTER.reg()">立即注册</a>
            </li>
            <br /><br />
        </form>
    </ul>
	</div>
	<div class="reg_right">
		<img src="${pageContext.request.contextPath}/image/register.jpg"" class="img_reg">
	</div>
</div>

<!--mainOver-->
<!--footerStart-->
<div class="footer">
		<span> <a href="#" rel="nofollow" class="footerlink1">免责声明</a> | 
		<a href="#" rel="nofollow" class="footerlink1">关于我们</a> | 
		<a href="#" rel="nofollow" class="footerlink1">网站合作</a> |
		<a href="#" rel="nofollow" class="footerlink1">联系我们</a>
		</span>
		<p>
			四川理工学院寻物招领平台<br> <a href="#" target="_blank" rel="nofollow" class="footerlink1"></a>Copyright© 
			梦之队 版权所有<br>
		</p>
</div>
<!-- /footer -->
<script type="text/javascript">
var mob_preg1 = /^1[3|4|5|7|8][0-9]{9}$/;
var ma_preg1 =/^\d+@qq\.com$/  
   function showtip11(){
	 
	   $("#mailErr").html(' 请输入QQ邮箱  (这很重要 用于激活)');
   }
   function showtip22(){
		 
	   $("#addErr").html(' 请输入地址');
   }
   function showtip33(){
		 
	   $("#phoneErr").html(' 请输入电话');
   }
   function showtipa(){
		 
	   $("#userMamErr").html(' 请输入用户名');
   }
   
	var REGISTER={
		param:{
			
			surl:""
		},
		inputcheck:function(){
			var flag = true;
			//不能为空检查
			if ($("#regName").val() == "") {
				showError("regName","userMamErr",defaultArr[8]);
				flag = false;
			}
			if ($("#pwd").val() == "") {
				showError("pwd","passwordErr",pwdArr[0]);
				flag = false;
			}
			if ($("#mail").val() == "") {
				showError("mail","mailErr","请输入qq邮箱 这很重要");
				flag = false;
			}
			
			  if(!ma_preg1.test($("#mail").val())){
					 $("#mailErr").html('邮箱格式不正确')
					 flag = false;
				}
			
			
			if ($("#phone").val() == "") {
				 $("#phoneErr").html('请输入电话')
				flag = false;
			}
			if(!mob_preg1.test($("#phone").val())){
				 $("#phoneErr").html('电话格式不正确')
				 flag = false;
			}
			
			
			
			if ($("#address").val() == "") {
				 $("#addErr").html(' 请输入联系地址');
				flag = false;
			}
			
			
			
			/*if ($("#phone").val() == "") {
				showError("phone","phoneErr",memArr[0]);
				flag = false;
			}*/
			//密码检查
			if ($("#pwd").val() != $("#pwdRepeat").val()) {
				showError("pwdRepeat","password2Err",pwd2Arr[1]);
				flag = false;
			}
			return flag;
		},
		beforeSubmit:function() {
				//检查用户是否已经被占用
				$.ajax({
	            	/* url : REGISTER.param.surl + "${pageContext.request.contextPath}/regester/check/"+escape($("#regName").val())+"/1?r=" + Math.random()+'.action', */
	            			url : REGISTER.param.surl + "${pageContext.request.contextPath}/regester/check/"+$("#regName").val()+"/1?r=" + Math.random()+'.action',
	            	success : function(data) {
	            		if (data.data) {
	            			//检查qq邮箱是否存在
	            			$.ajax({
	            				url : REGISTER.param.surl + "${pageContext.request.contextPath}/regester/check/"+$("#mail").val()+"/2?r=" + Math.random(),
				            	success : function(data) {
				            		if (data.data) {
					            		REGISTER.doSubmit();
				            		} else {
				            			showError("mail","mailErr",'qq邮箱已经被注册');
				            		}
				            	}
	            			});
	            		} else {
	            			showError("regName","userMamErr",defaultArr[10]);
	            		}	
	            	}
				});
	            	
		},
		doSubmit:function() {
			$.post("${pageContext.request.contextPath}/reg/register.action",$("#regForm_mod").serialize(), function(data){
				if(data.status == 200){
					jAlert('用户注册成功，请进入自己邮箱完成验证！若没收到请稍等片刻！',"提示", function(){
						REGISTER.login();
					});
				} else {
					jAlert("注册失败！","提示");
				}
			});
		},
		login:function() {
			 location.href = "https://mail.qq.com/";
			 return false;
		},
		reg:function() {
			if (this.inputcheck()) {
				this.beforeSubmit();
			}
		}
	};
</script>
	</body>
</html>

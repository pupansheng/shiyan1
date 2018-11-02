package lost.found.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lost.found.pojo.Result;
import lost.found.pojo.User;
import lost.found.sevice.LogAndReService;
import lost.found.utils.DrawImage;
import lost.found.utils.JsonUtils;

@Controller
public class LoginController {
	@Autowired
	private LogAndReService logAndReService;
	
	/*
	 * 用户注销
	 * 
	 * 
	 * */
	@RequestMapping("/user/logout")
	public String loginout(HttpServletRequest request)
	{
		
	
	 request.getSession().removeAttribute("user");
	 
	 return "redirect:/index";

	}
	
	/*
	 * 检查数据
	 * 
	 * */
	@RequestMapping("/regester/check/{data}/{type}")
	@ResponseBody
	public  Result get(@PathVariable String data,@PathVariable String type)
	{
		
		
		
		 Result checkUser = logAndReService.checkUser(data, type);
		 String s=JsonUtils.objectToJson(checkUser);
		 return checkUser;
		
	}
	/*
	 * 将用户激活
	 * 
	 * */
	@RequestMapping("/mailcheck")
	public String get(String code)
	{	
		logAndReService.relative(code);
		
		return "msg";
		
	}
	
	/*
	 * 找回密码
	 * 
	 * */
	@RequestMapping("/forget/password")
	public String forget()
	{	
		
		
		return "msg_password";
		
	}
	@RequestMapping("/zhaohui/password")
	@ResponseBody
	public Result getpass(String mail)
	{
	Result r=logAndReService.zhaohui(mail);
	return r;
	}
	
	
	
	@RequestMapping(value={"/reg/register"})
	@ResponseBody
	public Result get(User user)
	{
	
	return logAndReService.addUser(user);
		
	}
	
	
	@RequestMapping("/user/login")
	@ResponseBody
	public Result login1(User u,HttpServletRequest request)
	{
	Result r=logAndReService.login(u,request);
	return r;
	}
	 /*
	  * 检测是否登陆 并给出相应结果
	  * 
	  * */
	@RequestMapping("/user/token/")
	@ResponseBody
	public Result checklogin(Model model,HttpServletRequest request)
	{
		Result r=new Result();
     	User u=(User) request.getSession().getAttribute("user");
     	if(u!=null)
     	{
    	r.setData(u);
    	r.setStatus(200);
         return r;
     	}
	     return r;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 产生验证码
	 * 
	 * */
	@RequestMapping("/make/yanzhengma")
	public void makeYan(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		
		DrawImage d=new DrawImage();
		d.doPost(request, response);
		
	}
	@RequestMapping("/make/ya")
	public void makeYana(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		
		DrawImage d=new DrawImage();
		d.doPost(request, response);
		
	}
	
	/*
	 * 
	 * 验证验证码
	 * 
	 * */
	@RequestMapping("/check/yanzhengma")
	public void yanzheng(HttpServletRequest request,HttpServletResponse response)
	{ 
	
				response.setContentType("text/html;charset=utf-8");
				String validateC = (String) request.getSession().getAttribute("checkcode");
				//从前台传来的用户输入的验证码
				String veryCode = request.getParameter("c");
				PrintWriter out;
				try {
					out = response.getWriter();
				
				if (veryCode == null || "".equals(veryCode)) {
					out.println("请输入验证码！");
				} else {
//					if (validateC.equals(veryCode)) {
					//忽略大小写处理：
					if (validateC.equalsIgnoreCase(veryCode)) {
						out.println(1);
					} else {
						out.println("验证码输入错误！");
					}
					out.flush();
					out.close();
					
				}
			} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		}
		 


	
	
	
		
}
	
	



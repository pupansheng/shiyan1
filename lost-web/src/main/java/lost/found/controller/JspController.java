package lost.found.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lost.found.mapper.ItemMapper;
import lost.found.mapper.PackitemMapper;
import lost.found.pojo.Item;
import lost.found.pojo.Packitem;
import lost.found.pojo.User;

@Controller
public class JspController {
	
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private PackitemMapper packItemMapper;
	@RequestMapping("/user/lostthing")//返回发布遗失物品页面
	public String  f()
	{
		 return "lostthing";
	}
	
	@RequestMapping("/return/page")//返回发布遗失物品页面
	public String  f(int  type)
	{
		if(type==1)
		 return "redirect:/user/infself";
		else
		 return "redirect:/see/leifeng";
	}
	
	
	
	@RequestMapping("/user/packupthing")//返回拾取物品登陆页面
	public String  f2()
	{
		 return "packupthing";
	}
	
	@RequestMapping("/index")//打开主页面
	public String getIndex(Model model)
	{
		
		 List<Item> selectIndex10 = itemMapper.selectIndex10();
		 List<Packitem> selectIndex102 = packItemMapper.selectIndex10();
		 
		
	    model.addAttribute("item",selectIndex10);
	    model.addAttribute("packitem",selectIndex102);
		return "index";
		
	}
	
	@RequestMapping("/page/login")//返回登陆页面
	public String get(String redirect,Model model)
	{
		model.addAttribute("tourl", redirect);
		return "login";
		
	}
	
	@RequestMapping("/page/register")//返回注册页面
	public String getResger()
	{
	
		return "register";
		
	}
	
	@RequestMapping("/user/login/chuli")//返回登陆页面
	public String  login(User u,HttpServletRequest request)
	{
		 return "login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

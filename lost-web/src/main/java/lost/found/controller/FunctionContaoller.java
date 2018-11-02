package lost.found.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lost.found.mapper.UserMapper;
import lost.found.pojo.Item;
import lost.found.pojo.Liuyan;
import lost.found.pojo.Packitem;
import lost.found.pojo.Page;
import lost.found.pojo.Result;
import lost.found.pojo.User;
import lost.found.sevice.FunctionService;

@Controller
public class FunctionContaoller {
	@Autowired
	private FunctionService functionService;
	
	/*
	 * 
	 * 将发布丢失物品留言插入数据库
	 * 
	 * 
	 * */
	
	@RequestMapping("/help/lost")
	@ResponseBody
	public Result helpLost(int iid,int uid,String msg,HttpServletRequest request)
	{

		return functionService.addMsg(iid, uid, msg,request);
	
	}
	/*
	 * 
	 * 将发布拾取物品的留言信息插入数据库
	 * 
	 * */
	@RequestMapping("/help/pack")
	@ResponseBody
	public Result helpPack(int pid,int uid,String msg,HttpServletRequest request)
	{

		return functionService.addMsgPack(pid, uid, msg,request);
	
	}
	
	
	
	
	/*
	 * 
	 * 
	 * 查看留言
	 * 
	 * */
	@RequestMapping("/user/liuyan")
	public String liuyan(Model model,HttpServletRequest request,@RequestParam(name="num",defaultValue="1")int num)
	{
		
		int pagesize=10;
		
        Page<Liuyan> page = functionService.getPageLiuyan(request,num, pagesize);
		
		model.addAttribute("page", page);
		
		return "liuyan";
		
	}
	/*
	 * 查看发布失物信息
	 * 
	 * */
	@RequestMapping("/user/fabu")
	public String fabu(Model model,HttpServletRequest request,@RequestParam(name="num",defaultValue="1")int num)
	{
		
		User u=(User) request.getSession().getAttribute("user");
		int uid=u.getId();
		int pagesize=10;
		Page<Item> fabuItem = functionService.getFabuItem(num, pagesize, uid);
		
		model.addAttribute("page",fabuItem);
		
		return "fabu";
		
	}
	
	/*
	 * 查看发布拾取物信息
	 * 
	 * */
	@RequestMapping("/user/fabu/pack")
	public String fabupake(Model model,HttpServletRequest request,@RequestParam(name="num",defaultValue="1")int num)
	{
		
		User u=(User) request.getSession().getAttribute("user");
		int uid=u.getId();
		int pagesize=10;
		Page<Packitem> fabuItem = functionService.getFabuPackItem(num,pagesize, uid);
		model.addAttribute("page",fabuItem);
		
		return "fabupack";
		
	}
	

	/*
	 * 修改个人资料
	 * 
	 * */
	@RequestMapping("/user/toupdate")
	public String toupdateacunt(Model model,HttpServletRequest request)
	{
		
		User u=(User) request.getSession().getAttribute("user");
		model.addAttribute("user", u);
		return "xiugai";
		
	}
	@RequestMapping("/user/update")
	@ResponseBody
	public Result update(Model model,HttpServletRequest request,User user)
	{
	
		User u=(User) request.getSession().getAttribute("user");
		user.setId(u.getId());
		return  functionService.updateUser(user);
	
		
	}
	@RequestMapping("/see/leifeng")
	public String seeleifeng(Model model,@RequestParam(name="num",defaultValue="1")int num)
	{
		
		Page<User> leifengbang = functionService.getLeifengbang(num,10);
		
		model.addAttribute("page",leifengbang);
		
		
	    return "leifeng";
		
	}
	/*
	 * 查看用户
	 * 
	 * 
	 * */
	@RequestMapping("/see/yonghu")
	public String seeyonghu(Model model,int id,int type)
	{
		User u=functionService.getUserMsg(id);
		model.addAttribute("user",u);
		if(type==1)
	    return "user";
		else
		return "user2";
		
	}
	
	/*
	 * 取消发布失物
	 * 
	 * */
	@RequestMapping("/lost/delete")
	@ResponseBody
	public Result delete(int id)
	{
	 
	return 	functionService.deleteLost(id);
	
		
	}
	/*
	 * 拾物处理
	 * 
	 * */
	@RequestMapping("/pack/delete")
	@ResponseBody
	public Result deletePack(int type,int id)
	{
	 
		
	return 	functionService.deletePack(id,type);
	
		
	}
	/*
	 * 删除留言
	 * 
	 * */
	@RequestMapping("/liuyan/delete")
	public void deleteLIuyan(int id)
	{
		
		functionService.deleteLiuyan(id);
		
	}
	
	
	
	
	
}

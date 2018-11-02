package lost.found.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lost.found.pojo.EasyUIDataGridResult;
import lost.found.pojo.Item;
import lost.found.pojo.Manager;
import lost.found.pojo.Packitem;
import lost.found.pojo.Result;
import lost.found.pojo.User;
import lost.found.sevice.Houtaiservice;


@Controller
public class IndexController {
	
	@Autowired
	private Houtaiservice houtaiService;
	
	@RequestMapping("/user/index")
	public String index()
	{	
		return "index";
	}
	
	@RequestMapping("/index")
	public String index2()
	{	
		return "redirect:/user/index";
	}
	
	
	@RequestMapping("/page/login")
	public String index11()
	{	
		
		return "login";
		
	}
	
	
	@RequestMapping("/user/{page}")
	public String page(@PathVariable String page)
	{
		return page;
	}

	
	
	@RequestMapping("/user/item/list")
	@ResponseBody
	public EasyUIDataGridResult itempageList(Integer page,Integer rows)
	{	
	  EasyUIDataGridResult  result=houtaiService.findUsers(page, rows);
		return result;	
	}
	@RequestMapping("/user/lost/list")
	@ResponseBody
	public EasyUIDataGridResult itempageList2(Integer page,Integer rows)
	{	
	  EasyUIDataGridResult  result=houtaiService.findLost(page, rows);
		return result;	
	}
	@RequestMapping("/user/pack/list")
	@ResponseBody
	public EasyUIDataGridResult itempageList3(Integer page,Integer rows)
	{	
	  EasyUIDataGridResult  result=houtaiService.findPack(page, rows);
		return result;	
	}
	
	
	
	
	
	@RequestMapping("/rest/page/item-edit")
	public String edit1()
	{	
		return "item-edit";
	
	}
	
	@RequestMapping("/rest/pack/pack-edit")
	public String edit2()
	{	
		return "pack-edit";
	
	}
	@RequestMapping("/rest/lost/lost-edit")
	public String edit3()
	{	
		
		return "lost-edit";
	
	}
	
	
	@RequestMapping("/rest/item/update")
	@ResponseBody
	public Result edit2(User u,String passwordd)
	{
	if(StringUtils.isNotBlank(passwordd));
	 u.setPassword(passwordd);
	
	 return houtaiService.updateUser(u);
	}
	
	@RequestMapping("/rest/lost/update")
	@ResponseBody
	public Result edit3(Item u)
	{
	return houtaiService.updateItem(u);
	}
	
	@RequestMapping("/rest/pack/update")
	@ResponseBody
	public Result edit4(Packitem u)
	{
	
	return houtaiService.updatePackitem(u);
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public Result deleteuser(int [] ids)
	{	
		return houtaiService.deleteUser(ids);
	
	}
	
	
	
	
	
	
	
	
	/////
	@RequestMapping("/rest/lost/delete")
	@ResponseBody
	public Result deleteLost(int [] ids)
	{	
		return houtaiService.deletelOST(ids);
	
	}
	
	@RequestMapping("/rest/pack/delete")
	@ResponseBody
	public Result deletePack(int [] ids)
	{	
		return houtaiService.deletepack(ids);
	
	}
	
	
	@RequestMapping("/index/item/import")
	@ResponseBody
	public Result impsolr()
	{	
		return houtaiService.impoortSolr();
	
	}
	
	@RequestMapping("/user/login")
	@ResponseBody
	public Result login(Manager u,HttpServletRequest request)
	{	
	
		return houtaiService.login(u,request);
	
	}

}

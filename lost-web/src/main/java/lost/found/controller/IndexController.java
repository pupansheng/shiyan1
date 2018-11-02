package lost.found.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lost.found.mapper.ItemMapper;
import lost.found.pojo.Page;
import lost.found.sevice.IndexService;


@Controller
public class IndexController {
	
	
	@Autowired
	private  IndexService  indexService;
	
	/*
	 * 
	 * 直接返回指定的页面 不处理
	 * 
	 * */
@RequestMapping("/to/page/{name}")
public String toPage(@PathVariable String name)
{
	
   return name;
}


@RequestMapping("/lost/list")
public String toPageLost(Model model,@RequestParam(defaultValue="1") int num)
{
	
    Page p=indexService.getItemPage(num,10);
   
    model.addAttribute("page",p);
    return "lostlist";
    
    
}
@RequestMapping("/user/infself")
public String toinf()
{
	
   
    return "infself";
    
    
}

@RequestMapping("/pack/list")
public String toPagePackup(Model model,@RequestParam(defaultValue="1") int num)
{
	
    Page p=indexService.getPackitemPage(num,10);
   
    model.addAttribute("page",p);
    return "packlist";
    
    
}
/*
 * 查找数据发到拾取物品页面
 * 
 * */
@RequestMapping("/detail/pack")
public String detail(int id,int uid,Model model,int type)
{
	
	Map detail = indexService.getDetail(id, uid);
	model.addAttribute("user",detail.get("user"));
	model.addAttribute("packitem",detail.get("packitem"));
	if(type==1)
	return "details_sw";
	else
	return "detailpack";
}
/*
 * 查找数据发到拾取物品页面
 * 
 * */
@RequestMapping("/detail/lost")
public String detaillost(int id,int uid,Model model,int type)
{
	
	Map detail = indexService.getDetaillost(id, uid);
	model.addAttribute("user",detail.get("user"));
	model.addAttribute("item",detail.get("item"));
	if(type==1)
	return "details_xw";
	else
	return "detail";
}



@RequestMapping("/detail/search")
public String  getSearchDetasils(String id,Model model){
	if(id.contains("pack:"))
	{
		String id2=id.substring(5);
		Map detail = indexService.getSearchDetail(Integer.parseInt(id2),1);
		model.addAttribute("user",detail.get("user"));
		model.addAttribute("packitem",detail.get("packitem"));
		return "detailpack";
		
	}
	else if(id.contains("lost:"))
	{
	String id2=id.substring(5);
	Map detail = indexService.getSearchDetail(Integer.parseInt(id2),2);
	model.addAttribute("user",detail.get("user"));
	model.addAttribute("item",detail.get("item"));
	return "detail";
	}
	else{
	 return "err";
		
	}

	
	

}
	
	

}

package lost.found.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;

import lost.found.pojo.Item;
import lost.found.pojo.Packitem;
import lost.found.pojo.Result;
import lost.found.pojo.User;
import lost.found.sevice.ItemService;
import lost.found.utils.FastDFSClient;


@Controller
public class ItemFileUplodadController {

	
	
	@Value("${IMAGE_SERVERIP}")
	private String IMAGE_SERVERIP;
	
	@Autowired
	private ItemService itemService;
	
	/*
	 * 对于时间类型 需要对它进行一些配置  不然Spring的自动映射参数会发生错误
	 * */
	@InitBinder 
	public void initBinder(WebDataBinder binder) { 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		dateFormat.setLenient(true); 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); 
	}

	@RequestMapping(value="/pic/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String fileUploda(MultipartFile uploadFile)
	{
		//System.out.println("进入图片上传模块");
		try {
		// 1 获取上传文件的后缀 方式1
		String ext=FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		//获取上传文件的后缀 方式2
		//String originalFilename = uploadFile.getOriginalFilename();
		//String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);由于直接截取会包括.所有+1
		
		//2  创建FastDFSClient客户端
		FastDFSClient f=new FastDFSClient("classpath:conf/client.conf");
		//3  执行上传处理 并返回存取路径 这里返回的路径不包括图片服务器的IP地址 所以要加上他  为防止写死代码 所有用配置文件方式
		String url0= f.uploadFile(uploadFile.getBytes(), ext);
		
		//4 拼装图片地址
		
		String url=IMAGE_SERVERIP+url0;
		//System.out.println(url+"地址");
		Map result=new HashMap();
		result.put("error", 0);
		result.put("url",url);
		
		return JSONUtils.toJSONString(result);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Map result=new HashMap();
			result.put("error", 1);
			result.put("message","图片上传失败");
			System.out.println(e.getMessage()+"失败");
			return JSONUtils.toJSONString(result);
		}
		
		
	}
	/*
	 * 
	 * 插入丢失的物品
	 * */
	@RequestMapping("/item/save")
	@ResponseBody
	public Result addProduct(Item e,String desc,HttpServletRequest request)
	{
    User u=(User)request.getSession().getAttribute("user");
   
    e.setUid(u.getId());
	e.setItemdesc(desc);
	return  itemService.insertLost(e);	
	}
	
	
	/*
	 * 
	 * 插入拾取的物品
	 * */
	@RequestMapping("/item/save/packup")
	@ResponseBody
	public Result addPackThing(Packitem e,String desc,HttpServletRequest request)
	{
     User u=(User)request.getSession().getAttribute("user");
	 e.setUid(u.getId());
	 e.setItemdesc(desc);
	return  itemService.insertPack(e,u.getId());	
	}
	

}

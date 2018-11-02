package lost.found.serviceim;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import lost.found.mapper.UserMapper;
import lost.found.pojo.Result;
import lost.found.pojo.User;
import lost.found.pojo.UserExample;
import lost.found.pojo.UserExample.Criteria;
import lost.found.sevice.LogAndReService;
import lost.found.utils.IDUtils;
import lost.found.utils.MailSentTherd;
import lost.found.utils.QQMailUtils;
@Service
public class LogAndReServiceIm implements LogAndReService {
	
	
     @Autowired
	private UserMapper userMapper;
	@Value("${MAILIP}")
	private String MAILIP;
	@Value("${QQCLIENT2}")
	private String QQCLIENT;
	@Value("${QQPASSWD2}")
	private String QQPASSWD;
	@Override
	public Result checkUser(String data, String type) {
		
		
		
		
		//System.out.println(data+"   "+type);
		Result r=new Result();
		
		String c=null;
		try
		{
		 c = new String(data.getBytes("iso8859-1"),"utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
		e.printStackTrace();
		r.setData(false);
		return  r;
		}
		
		if(type.equals("1")){//检查用户名是否存在
			
			//System.out.println("检测用户");
			UserExample example=new UserExample();
			
			Criteria createCriteria = example.createCriteria();
			createCriteria.andUsernameEqualTo(c);
			List<User> selectByExample = userMapper.selectByExample(example);
			
			if( selectByExample!=null&& selectByExample.size()>0){
				r.setData(false);
				return  r;
			
			}
			else{
				r.setData(true);
				return  r;
				
			}
			
		}
		else{
			//System.out.println("检测邮箱");
            UserExample example2=new UserExample();
			Criteria createCriteria2 = example2.createCriteria();
			createCriteria2.andMailEqualTo(data);
			List<User> selectByExample2 = userMapper.selectByExample(example2);
			
			if( selectByExample2!=null&& selectByExample2.size()>0){
				r.setData(false);
				return  r;
			
			}
			else{
				r.setData(true);
				return  r;
				
			}
			
		}
		
	}


	@Override
	public Result addUser(User user) {
		Result r=new Result();
		try
		{
			
		user.setCreatetime(new Date());
		user.setUpdatetime(new Date());
		String uuid=IDUtils.genImageName();
		user.setUuid(uuid);
		
		//对密码加密
		
		String Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		
		user.setPassword(Pass);
		
		
		
		userMapper.insertSelective(user);
		r.setStatus(200);
		String url="mailcheck?code="+uuid;
		url=MAILIP+url;
		String content="<h1>请点击连接完成验证!</h1><h3><a href='"+url+"'>"+url+"</a></h3><tr/><h2>若打开失败则请将连接复制到浏览器打开！！！</h2>";
		new MailSentTherd(content,user.getMail(),QQCLIENT,QQPASSWD).start();;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			r.setStatus(100);
		}
		// TODO Auto-generated method stub
		return r;
	}

/*
 * 激活用户
 * */
	@Override
	public void relative(String code) {
		UserExample example=new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUuidEqualTo(code);
		List<User> selectByExample = userMapper.selectByExample(example);
		if( selectByExample!=null&&selectByExample.size()>0){
			
			User u=selectByExample.get(0);
			u.setStatus(1);
			userMapper.updateByPrimaryKey(u);
		}
		
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public Result login(User u,HttpServletRequest request) {
		Result r=new Result();
		UserExample example=new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(u.getUsername());
		
		List<User> aa = userMapper.selectByExample(example);
		if(aa!=null&&aa.size()>0){
			
			User pp=aa.get(0);
			
			if(!pp.getPassword().equals(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()))){
				
				r.setStatus(100);
				 r.setMsg("密码错误！！");
				return r;
				
			}
			else{
				
				int q=pp.getStatus();
				
				if(q==1)
				{
					r.setStatus(200);
					//验证通过 则存入session
			    	
			    	HttpSession session = request.getSession();
			    	session.setAttribute("user",pp);
					
					 return r; 
				}
				else{
					r.setStatus(100);
					  r.setMsg("用户没有激活");
					return r;
					
				}
				
				
				
				
			}
			
		}
		else{
			
			r.setStatus(100);
			 r.setMsg("用户不存在");
			return r;
			
		}
		
		
		
	/*	createCriteria.andPasswordEqualTo(u.getPassword());
		List<User> selectByExample = userMapper.selectByExample(example);
     if( selectByExample!=null&&selectByExample.size()>0){
			
			User uu=selectByExample.get(0);
			int q=uu.getStatus();
			if(q==1)
			{
				r.setStatus(200);
				//验证通过 则存入session
		    	
		    	HttpSession session = request.getSession();
		    	session.setAttribute("user",uu);
				
				 return r; 
			}
			else{
				r.setStatus(100);
				  r.setMsg("用户没有激活");
				return r;
				
			}
			
		}
		
     r.setStatus(100);
     r.setMsg("用户或者密码错误");
     return r;
     */
		// TODO Auto-generated method stub
		
	}


	@Override
	public Result zhaohui(String mail) {
		Result r=new Result();
		UserExample example=new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andMailEqualTo(mail);
		List<User> s = userMapper.selectByExample(example);
		if(s!=null&&s.size()>0){
			
		User u=s.get(0);
		String pass=IDUtils.genImageName();
		String content="<h2>您的新密码为："+pass+   " 您可以用这个密码登陆<a href=\"http://120.79.204.37:8080/lost/index\">官网</a><然后修改改为自己容易记住的密码</h2>";
		new MailSentTherd(content,mail,"四川理工学院失物招领 密码找回",QQCLIENT,QQPASSWD).start();
		u.setPassword(DigestUtils.md5DigestAsHex(pass.getBytes()));
		userMapper.updateByPrimaryKeySelective(u);
		r.setStatus(200);
		return r;
		}
		else{
			r.setStatus(100);
			return r;
			
		}
	
	}

}

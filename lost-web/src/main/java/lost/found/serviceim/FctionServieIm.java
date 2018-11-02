package lost.found.serviceim;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import lost.found.mapper.ItemMapper;
import lost.found.mapper.MsgMapper;
import lost.found.mapper.PackitemMapper;
import lost.found.mapper.UserMapper;
import lost.found.pojo.Item;
import lost.found.pojo.Liuyan;
import lost.found.pojo.Msg;
import lost.found.pojo.MsgExample;
import lost.found.pojo.MsgExample.Criteria;
import lost.found.pojo.Packitem;
import lost.found.pojo.Page;
import lost.found.pojo.Result;
import lost.found.pojo.User;
import lost.found.sevice.FunctionService;
import lost.found.utils.MailSentTherd;
@Service
public class FctionServieIm implements FunctionService {

	@Autowired
	private MsgMapper msgMapper;
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private PackitemMapper packItemMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SolrServer solrServer;
	
	@Value("${QQCLIENT}")
	private String QQCLIENT;
	@Value("${QQPASSWD}")
	private String QQPASSWD;
	
	
	
	@Override
	public Result addMsg(int iid, int uid, String msg,HttpServletRequest request) {
		 Result r=new Result();
		Msg record=new Msg();
		User u = userMapper.selectByPrimaryKey(uid);
		Item e=itemMapper.selectByPrimaryKey(iid);
	    User helpuser=(User)request.getSession().getAttribute("user");
		if(helpuser!=null)
		record.setHid(helpuser.getId());
		record.setIid(iid);
		try {
			record.setCreatetime(new Date());
			record.setMsg(msg);
			record.setUid(uid);
			msgMapper.insertSelective(record);
			r.setStatus(200);
		} catch (Exception ee) {
			r.setStatus(100);
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		//发送邮件提醒
		String title=e.getTitle();
		String  add="<h2>您发布的失物：'"+title+"'有人给你留言了!!留言内容：<br>'"+msg+"'<br/>详情请登陆<a href='http://120.79.204.37:8080/lost/index'>四川理工失物招领网站查看！</a></h2>";
	    new MailSentTherd(add,u.getMail(),"四川理工失物招领网站留言提醒",QQCLIENT,QQPASSWD).start();;
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public Result addMsgPack(int pid, int uid, String msg, HttpServletRequest request) {
		
		
		   Result r=new Result();
		 
			Msg record=new Msg();
			User u = userMapper.selectByPrimaryKey(uid);
			
			Packitem e=packItemMapper.selectByPrimaryKey(pid);
			
		    User lostuser=(User)request.getSession().getAttribute("user");//丢失人或者游客
			if(lostuser!=null)
			record.setHid(lostuser.getId());
			
			record.setPid(pid);//发布的拾取物品的id
			
			
			try {
				record.setCreatetime(new Date());
				record.setMsg(msg);
				record.setUid(uid);//发布人的id
				msgMapper.insertSelective(record);
				r.setStatus(200);
			} catch (Exception ee) {
				r.setStatus(100);
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
			//发送邮件提醒
			String title=e.getTitle();
			String  add="<h2>您发布的拾取物品：'"+title+"'有人给你留言了!!留言内容：<br>'"+msg+"'<br/>详情请登陆<a href='http://120.79.204.37:8080/lost/index'>四川理工失物招领网站查看！</a></h2>";
		    new MailSentTherd(add,u.getMail(),"四川理工失物招领网站留言提醒",QQCLIENT,QQPASSWD).start();;
			// TODO Auto-generated method stub
			return r;
	}
	
	
	
	@Override
	public List<Liuyan> getLiuyan(HttpServletRequest request) {
		 System.out.println("进入留言模块");
		List<Liuyan> liuyan=new ArrayList<Liuyan>();
		
		User u=(User) request.getSession().getAttribute("user");
		
		MsgExample example=new MsgExample();
		Criteria createCriteria = example.createCriteria();
	
		createCriteria.andUidEqualTo(u.getId());
		
		List<Msg> msg= msgMapper.selectByExampleWithBLOBs(example);
		
		if(msg!=null&&msg.size()>0)
		{
			 System.out.println("进入if模块");
			for(Msg g:msg)
			{
				Liuyan l=new Liuyan();
				Object item=null;
				 System.out.println("进入for模块");
				if(g.getIid()!=null){
					 System.out.println("进入if-if模块");
			    item=itemMapper.selectByPrimaryKey(g.getIid());
			    //此处未知BUG
			    System.out.println(g.getIid());
				}
				else{
					 System.out.println("进入if-else模块");
				item=packItemMapper.selectByPrimaryKey(g.getPid());
				   //此处未知BUG
				System.out.println(item);
				}
				User  helpuser=userMapper.selectByPrimaryKey(g.getHid());
				
				 l.setHelpuser(helpuser);
				 l.setItem(item);
				 l.setMsg(g);
				liuyan.add(l);
			}
		}
		
		
		
		
		
		
		
		return liuyan;
	}


	@Override
	public Page<Item> getFabuItem(int num, int pagesize, int uid) {

	    int totalCount=itemMapper.getSumCountByUid(uid);
	    
		Page<Item> page=new Page<Item>(num,totalCount,pagesize);
		
		
		 page.setUrl("user/fabu");
		
		 List<Item> records = itemMapper.getItemPageFabu((num-1)*pagesize, pagesize, uid);
		  
		 page.setRecords(records);
		
		return page;
	}


	@Override
	public Page<Liuyan> getPageLiuyan(HttpServletRequest request, int num, int pagesize) {
		
		
        List<Liuyan> liuyan=new ArrayList<Liuyan>();
		
		User u=(User) request.getSession().getAttribute("user");
		
		int totalRecords=msgMapper.getSumCount(u.getId());
		
		Page<Liuyan> page=new Page<Liuyan>(num, totalRecords, pagesize);
		
	
		List<Msg> msg= msgMapper.getPageMsg((num-1)*pagesize, pagesize,u.getId());
		
		if(msg!=null&&msg.size()>0)
		{
			for(Msg g:msg)
			{
				Liuyan l=new Liuyan();
				
				Object item=null;
				if(g.getIid()!=null){
	             l.setType(1);
			     item=itemMapper.selectByPrimaryKey(g.getIid());
				}
				else{
					l.setType(2);
				  item=packItemMapper.selectByPrimaryKey(g.getPid());
				}
				
				
				User  helpuser=userMapper.selectByPrimaryKey(g.getHid());
				
				 l.setHelpuser(helpuser);
				 l.setItem(item);
				 l.setMsg(g);
	
				liuyan.add(l);
			}
		}
		
		
		page.setRecords(liuyan);
		page.setUrl("user/liuyan");
		
		// TODO Auto-generated method stub
		return page;
	}


	@Override
	public Page<Packitem> getFabuPackItem(int num, int pagesize, int uid) {
		
		
		   int totalCount=packItemMapper.getSumCountByUid(uid);
		    
			Page<Packitem> page=new Page<Packitem>(num,totalCount,pagesize);
			
			
			 page.setUrl("user/fabu/pack");
			
			 List<Packitem> records = packItemMapper.getPackitemPageFabu((num-1)*pagesize, pagesize, uid);
			  
			 page.setRecords(records);
			
			return page;
		
	
	}


	@Override
	public Result updateUser(User u) {
		Result r=new Result();
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		try{
		userMapper.updateByPrimaryKeySelective(u);
		r.setStatus(200);
		
		}
		catch(Exception e)
		{
			
			r.setStatus(100);
			
		}
		// TODO Auto-generated method stub
		return r;
	}


	@Override
	public Page<User> getLeifengbang(int num,int pagesize) {
		int totalRecords=userMapper.getSumCount();
		
		Page<User> page=new Page<User>(num, totalRecords, pagesize);
		
		List<User> pageUser = userMapper.getPageUser((num-1)*pagesize, pagesize);
		
		page.setRecords(pageUser);
		
		page.setUrl("see/leifeng");
		
		// TODO Auto-generated method stub
		return page;
	}


	@Override
	public User getUserMsg(int id) {
		
		
		User u=userMapper.selectByPrimaryKey(id);
		
		
		
		
		return u;
	}

	@Override
	public Result deleteLost(int id) {
		
		Result r=new Result();
		try{
			
			itemMapper.deleteByPrimaryKey(id);
			
			//删除索引库数据
			
			
		
		
			solrServer.deleteById("lost:"+id);
			
			solrServer.commit();

			
			r.setStatus(200);
			
			
		}
		catch(Exception e)
		{
			r.setStatus(100);
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public Result deletePack(int id, int type) {
		Result r=new Result(); 
		if(type==1)
		{
			
			try {
				packItemMapper.deleteByPrimaryKey(id);
				//删除索引库
				solrServer.deleteById("pack:"+id);
				
				solrServer.commit();

				r.setStatus(200);
			} catch (Exception e) {
				r.setStatus(100);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			
			try {
				Packitem p= packItemMapper.selectByPrimaryKey(id);
				User u= userMapper.selectByPrimaryKey(p.getUid());
				int score=u.getScore();
				u.setScore(score+2);
				userMapper.updateByPrimaryKeySelective(u);
				packItemMapper.deleteByPrimaryKey(id);
				//删除索引库
				solrServer.deleteById("pack:"+id);
				
				solrServer.commit();

				
				r.setStatus(200);
			} catch (Exception e) {
				r.setStatus(100);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public void deleteLiuyan(int id) {
		
		
		try {
			msgMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		
	}


	

}

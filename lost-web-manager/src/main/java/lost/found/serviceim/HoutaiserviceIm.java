package lost.found.serviceim;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lost.found.mapper.ItemMapper;
import lost.found.mapper.ManagerMapper;
import lost.found.mapper.PackitemMapper;
import lost.found.mapper.UserMapper;
import lost.found.pojo.EasyUIDataGridResult;
import lost.found.pojo.Item;
import lost.found.pojo.ItemExample;
import lost.found.pojo.Manager;
import lost.found.pojo.ManagerExample;
import lost.found.pojo.ManagerExample.Criteria;
import lost.found.pojo.Packitem;
import lost.found.pojo.PackitemExample;
import lost.found.pojo.Result;
import lost.found.pojo.User;
import lost.found.pojo.UserExample;
import lost.found.sevice.Houtaiservice;
@Service
public class HoutaiserviceIm implements Houtaiservice {
    @Autowired
	private UserMapper userMapper;
    
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private PackitemMapper packItemMapper;
    @Autowired
    private SolrServer solrServer;
    
    @Autowired
    private ManagerMapper managerMapper;
    
	@Override
	public EasyUIDataGridResult findUsers(Integer page, Integer rows) {
		
		PageHelper.startPage(page,rows);
		
		//查询
		UserExample example=new UserExample();
		
	
		List<User>list = userMapper.selectByExample(example);
		
		
		
		//将查询结果包装到页面上
	    PageInfo<User> pageinfo =new PageInfo<User>(list);
		EasyUIDataGridResult easyUi=new EasyUIDataGridResult(pageinfo.getTotal(),list);
		return easyUi;
		
		
	}
	@Override
	public User findUser(int id) {	
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public Result updateUser(User u) {
		Result r=new Result();
		
		try {
			String pass=u.getPassword();

			if(StringUtils.isNotBlank(pass));
			{
				u.setPassword(DigestUtils.md5DigestAsHex(pass.getBytes()));
				
			}
			userMapper.updateByPrimaryKeySelective(u);
			r.setStatus(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			r.setStatus(100);
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return r;
	}
	@Override
	public Result deleteUser(int[] ids) {
		Result r=new Result();
		
		
		try {
			for(int i:ids)
			{
				
				userMapper.deleteByPrimaryKey(i);
				r.setStatus(200);
			}
		} catch (Exception e) {
			r.setStatus(100);
			e.printStackTrace();
		}
		
		
	
		return r;
	}
	@Override
	public EasyUIDataGridResult findLost(Integer page, Integer rows) {
		
		
	   PageHelper.startPage(page,rows);
		
		//查询
		
		
	
		ItemExample example=new ItemExample();
		
		List<Item>list = itemMapper.selectByExample(example);
		
		
		
		//将查询结果包装到页面上
	    PageInfo<Item> pageinfo =new PageInfo<Item>(list);
		EasyUIDataGridResult easyUi=new EasyUIDataGridResult(pageinfo.getTotal(),list);
		return easyUi;
		
		
	
	}
	@Override
	public EasyUIDataGridResult findPack(Integer page, Integer rows) {
		
		  PageHelper.startPage(page,rows);
			
			//查询
			
			
		
			PackitemExample example=new PackitemExample();
			
			List<Packitem>list = packItemMapper.selectByExample(example);
			
			
			
			//将查询结果包装到页面上
		    PageInfo<Packitem> pageinfo =new PageInfo<Packitem>(list);
			EasyUIDataGridResult easyUi=new EasyUIDataGridResult(pageinfo.getTotal(),list);
			return easyUi;
			
	}
	@Override
	public Result deletelOST(int[] ids) {
		
		
	Result r=new Result();
		
		
		try {
			for(int i:ids)
			{
				solrServer.deleteById("lost:"+i);
				
				solrServer.commit();

				
				itemMapper.deleteByPrimaryKey(i);
				r.setStatus(200);
			}
		} catch (Exception e) {
			r.setStatus(100);
			e.printStackTrace();
		}
		
		
	
		return r;
		

	}
	@Override
	public Result deletepack(int[] ids) {
	Result r=new Result();
		
		
		try {
			for(int i:ids)
			{
                solrServer.deleteById("pack:"+i);
				
				solrServer.commit();
				
				packItemMapper.deleteByPrimaryKey(i);
				r.setStatus(200);
			}
		} catch (Exception e) {
			r.setStatus(100);
			e.printStackTrace();
		}
		
		
	
		return r;
		
	}
	@Override
	public Result updateItem(Item u) {
	Result r=new Result();
		
		try {
			SolrInputDocument document = new SolrInputDocument();
			
			document.addField("id", "lost:"+u.getId());
			document.addField("ppstitle", u.getTitle());
			document.addField("ppslocation",u.getLocation());

			solrServer.add(document);
		
			solrServer.commit();
			
			itemMapper.updateByPrimaryKeySelective(u);
			
			
			
			
			r.setStatus(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			r.setStatus(100);
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return r;
	}
	@Override
	public Result updatePackitem(Packitem u) {
	Result r=new Result();
		
		try {
			
            SolrInputDocument document = new SolrInputDocument();
			
			document.addField("id", "pack:"+u.getId());
			document.addField("ppstitle", u.getTitle());
			document.addField("ppslocation",u.getLocation());

			solrServer.add(document);
		
			solrServer.commit();
			
			
			
			packItemMapper.updateByPrimaryKeySelective(u);
			
			
			
			
			r.setStatus(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			r.setStatus(100);
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return r;
	}
	@Override
	public Result impoortSolr() {
		Result r=new Result();
		ItemExample example=new ItemExample();
		List<Item> item=itemMapper.selectByExample(example);
		PackitemExample example2=new PackitemExample();
		List<Packitem> packItem=packItemMapper.selectByExample(example2);
		
		try {
			for(Item e:item)
			{
				
				
				SolrInputDocument document = new SolrInputDocument();
				
				document.addField("id", "lost:"+e.getId());
				document.addField("ppstitle", e.getTitle());
				document.addField("ppslocation",e.getLocation());
				if(e.getImages()!=null)
				document.addField("ppsimage",e.getImages()[0]);
				else
				document.addField("ppsimage",e.getImages());	
			
				solrServer.add(document);
			
				solrServer.commit();
				
				
				
			}
			
			for(Packitem e:packItem)
			{
				
				
				SolrInputDocument document = new SolrInputDocument();
				
				document.addField("id", "pack:"+e.getId());
				document.addField("ppstitle", e.getTitle());
				document.addField("ppslocation",e.getLocation());
				if(e.getImages()!=null)
				document.addField("ppsimage",e.getImages()[0]);
				else
				document.addField("ppsimage",e.getImages());	
			
				solrServer.add(document);
			
				solrServer.commit();
				
				
				
			}
			
			r.setStatus(200);
		} catch (SolrServerException e) {
			r.setStatus(100);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			r.setStatus(100);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return r;
	}
	
	@Override
	public Result login(Manager u,HttpServletRequest request) {
		
		
		 Result r=new Result();
		
		ManagerExample example=new ManagerExample();
	    Criteria createCriteria = example.createCriteria();
	    createCriteria.andUsernameEqualTo(u.getUsername());
	    createCriteria.andPasswordEqualTo(u.getPassword());
	    
		List<Manager> selectByExample = managerMapper.selectByExample(example);
	
		  if( selectByExample!=null&&selectByExample.size()>0){
				
				 Manager uu=selectByExample.get(0);
			
					r.setStatus(200);
					//验证通过 则存入session
			    	
			    	HttpSession session = request.getSession();
			    	
			    	session.setAttribute("user",uu);
			    	
					
					 return r; 
				}
			
		  
	     r.setStatus(100);
	     
	     return r;
	}

}

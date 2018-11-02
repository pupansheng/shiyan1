package lost.found.serviceim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lost.found.mapper.ItemMapper;
import lost.found.mapper.PackitemMapper;
import lost.found.mapper.UserMapper;
import lost.found.pojo.Item;
import lost.found.pojo.ItemExample;
import lost.found.pojo.ItemExample.Criteria;
import lost.found.pojo.Packitem;
import lost.found.pojo.Page;
import lost.found.pojo.User;
import lost.found.sevice.IndexService;
@Service
public class IndexServiceIm implements IndexService {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private PackitemMapper packitemMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<Item> getItems() {
		
		List<Item> selectIndex10 = itemMapper.selectIndex10();
		
		
		
		
		// TODO Auto-generated method stub
		return selectIndex10;
	}

/*
 * 查找分页数据
 * */
	@Override
	public Page<Item> getItemPage(int now,int pagesize) {
		int totalCount=itemMapper.getSumCount();
		
		Page<Item> page=new Page<Item>(now,totalCount,pagesize);
		
		page.setUrl("lost/list");
		
		
		List<Item> itemPage = itemMapper.getItemPage((now-1)*pagesize, pagesize);
		
		page.setRecords(itemPage);
		
		// TODO Auto-generated method stub
		return page;
	}

	@Override
	public Page<Packitem> getPackitemPage(int now, int pagesize) {
		
		//
        int totalCount=packitemMapper.getSumCount();
		
		Page<Packitem> page=new Page<Packitem>(now,totalCount,pagesize);
		
		page.setUrl("pack/list");
		
		
		List<Packitem> itemPage = packitemMapper.getPackitemPage((now-1)*pagesize, pagesize);
		
		page.setRecords(itemPage);
		
		// TODO Auto-generated method stub
		return page;
		
		
		// TODO Auto-generated method stub
	
	}

	@Override
	public Map getDetail(int id, int uid) {
		
		User u = userMapper.selectByPrimaryKey(uid);
		Packitem p=packitemMapper.selectByPrimaryKey(id);
		
		Map m=new HashMap<String,Object>();
		m.put("user", u);
		m.put("packitem",p);
		
		
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	public Map getDetaillost(int id, int uid) {
		
		
		User u = userMapper.selectByPrimaryKey(uid);
		Item p=itemMapper.selectByPrimaryKey(id);
		
		Map m=new HashMap<String,Object>();
		m.put("user", u);
		m.put("item",p);
		
		
		
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	public Map getSearchDetail(int id, int i) {
		
		if(i==1)
		{
			Packitem p=packitemMapper.selectByPrimaryKey(id);
			User u = userMapper.selectByPrimaryKey(p.getUid());
		
			
			Map m=new HashMap<String,Object>();
			m.put("user", u);
			m.put("packitem",p);
			
			
			// TODO Auto-generated method stub
			return m;
		}
		else
		{
			Item p=itemMapper.selectByPrimaryKey(id);
			User u = userMapper.selectByPrimaryKey(p.getUid());
			
			Map m=new HashMap<String,Object>();
			m.put("user", u);
			m.put("item",p);
			
			
			
			// TODO Auto-generated method stub
			return m;
			
			
			
			
			
			
			
		}
		
		
		
		
		
		// TODO Auto-generated method stub
	
	}

}

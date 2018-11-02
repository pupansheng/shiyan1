
package lost.found.serviceim;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lost.found.mapper.ItemMapper;
import lost.found.mapper.PackitemMapper;
import lost.found.mapper.UserMapper;
import lost.found.pojo.Item;
import lost.found.pojo.Packitem;
import lost.found.pojo.Result;
import lost.found.pojo.User;
import lost.found.sevice.ItemService;
@Service
public class ItemServiceIm implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private PackitemMapper packitemMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public Result insertLost(Item e) {
		
		Result r=new Result();
		
		try{
		e.setCreatetime(new Date());
		//System.out.println(e);
		
		itemMapper.insertSelective(e);
		
		
		
		
		//插入索引库
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


		
		
		
		r.setStatus(200);
		return r;
		}
		catch(Exception ee)
		{
			r.setStatus(100);
			ee.printStackTrace();
			
		}
		
		// TODO Auto-generated method stub
		return r;
	}
	@Override
	public Result insertPack(Packitem e,int id) {
		
Result r=new Result();
		
		try{
	   User u=userMapper.selectByPrimaryKey(id);
	   int score=u.getScore();
	    u.setScore(score+1);
	   userMapper.updateByPrimaryKeySelective(u);
		e.setCreatetime(new Date());
		//System.out.println(e);
		packitemMapper.insertSelective(e);
		
		//插入索引库
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
		
	
		
		r.setStatus(200);
		return r;
		}
		catch(Exception ee)
		{
			
			r.setStatus(100);
			ee.printStackTrace();
			
		}
		
		// TODO Auto-generated method stub
		return r;
	}

}

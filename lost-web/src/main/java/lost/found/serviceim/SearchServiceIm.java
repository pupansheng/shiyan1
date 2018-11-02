package lost.found.serviceim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lost.found.pojo.Page;
import lost.found.pojo.SearchItem;
import lost.found.pojo.SearchResult;
import lost.found.sevice.SearchService;
@Service
public class SearchServiceIm implements SearchService {

	@Autowired
	private SolrServer solrServer;

	
	@Override
	public Page getSearchResult(String keyWord, int num, int pagesize) {
		
		
		       //创建一个SolrQuery对象
		
				SolrQuery query = new SolrQuery();
				
				//设置查询条件
				query.setQuery(keyWord);
				//设置分页条件
				query.setStart((num - 1) * pagesize);
				//设置rows
				query.setRows(pagesize);
				//设置默认搜索域
				query.set("df","ppskeywords");
				//设置高亮显示
				query.setHighlight(true);
				query.addHighlightField("ppstitle");
				
				query.addHighlightField("ppslocation");
				
				
				query.setHighlightSimplePre("<em style=\"color:red\">");
				query.setHighlightSimplePost("</em>");
				//执行查询
				SearchResult searchResult=null;
				try {
					
					return this.search(query,num,pagesize);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				return null;
			

	}
	public Page search(SolrQuery query,int num,int pagesize) throws Exception {
		//根据查询条件查询索引库
		QueryResponse queryResponse = solrServer.query(query);
		//取查询结果总记录数
		
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		
		long numFound = solrDocumentList.getNumFound();
		
		
		Page<SearchItem> p=new Page<SearchItem>(num, (int) numFound, pagesize);
		
		
				
		//创建一个返回结果对象
		//SearchResult result = new SearchResult();
		
		//result.setRecourdCount((int) numFound);
		
		List itemList = new ArrayList<>();
		
		
		//取高亮后的结果
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		for (SolrDocument solrDocument : solrDocumentList) {
			
			SearchItem searchItem = new SearchItem();
			
			searchItem.setId((String)solrDocument.get("id"));
				
			searchItem.setPpsimage((String)solrDocument.get("ppsimage"));
			
			//searchItem.setPpslocation((String)solrDocument.get("ppslocation"));
			
		
			
			//丢失地址的高亮域
			List<String> list2 = highlighting.get(solrDocument.get("id")).get("ppslocation");
			
			String itemTitle2 = "";
			if (list2 != null && list2.size() > 0) {
				itemTitle2 = list2.get(0);
			} else {
				itemTitle2 = (String) solrDocument.get("ppslocation");
			}
			
			searchItem.setPpslocation(itemTitle2);
		
				
			
	      //丢失物品的高亮域
			
			List<String> list = highlighting.get(solrDocument.get("id")).get("ppstitle");
			
			String itemTitle = "";
			if (list != null && list.size() > 0){
				itemTitle = list.get(0);
			} else {
				itemTitle = (String) solrDocument.get("ppstitle");
			}
			
			searchItem.setPpstitle(itemTitle);
			
			
			itemList.add(searchItem);
			
			
			
		}
		
		
		
		
		
		
	
		
		//把列表添加到返回结果对象中
		
		p.setRecords(itemList);
		p.setUrl("search");
		
		//result.setList(itemList);
		
		
		return p;
	}


	

}

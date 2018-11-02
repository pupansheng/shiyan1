package lost.found.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lost.found.pojo.Page;
import lost.found.pojo.SearchResult;
import lost.found.sevice.SearchService;

@Controller
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	
	@RequestMapping("/search")
	public String  getSearchResult(String keywords,Model model,@RequestParam(defaultValue="1") int num,@RequestParam(defaultValue="10")int pagesize)
	{
		
		
	Page searchResult = searchService.getSearchResult(keywords,num,pagesize);
	
	model.addAttribute("page",searchResult);
		
		
    return "search";
	}
	
	
	
	

}

package lost.found.sevice;

import lost.found.pojo.Page;
import lost.found.pojo.SearchResult;

public interface SearchService {
	

	public Page getSearchResult(String keyWord, int page, int rows);
	
	

}

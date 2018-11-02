package lost.found.pojo;

import java.util.List;

public class SearchResult {
	
	private List<SearchItem> list;
	
	private int totalPages;
	
	private int recourdCount;
	
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<SearchItem> getList() {
		return list;
	}
	public void setList(List<SearchItem> list) {
		this.list = list;
	}
	public int getRecourdCount() {
		return recourdCount;
	}
	public void setRecourdCount(int recourdCount) {
		this.recourdCount = recourdCount;
	}

}

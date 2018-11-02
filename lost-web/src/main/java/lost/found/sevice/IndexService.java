package lost.found.sevice;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lost.found.pojo.Item;
import lost.found.pojo.Packitem;
import lost.found.pojo.Page;
public interface IndexService {
	public List<Item> getItems();
	public Page<Item> getItemPage(int now,int pagesize);
	public Page<Packitem> getPackitemPage(int now,int pagesize);
	public Map getDetail(int id,int uid);
	public Map getDetaillost(int id,int uid);
	public Map getSearchDetail(int parseInt, int i);

}

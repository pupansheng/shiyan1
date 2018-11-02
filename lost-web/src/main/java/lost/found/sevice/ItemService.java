package lost.found.sevice;

import javax.servlet.http.HttpServletRequest;

import lost.found.pojo.Item;
import lost.found.pojo.Packitem;
import lost.found.pojo.Result;

public interface ItemService {
	public Result insertLost(Item e);
	public Result insertPack(Packitem e,int id);
	
	
	

}

package lost.found.sevice;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lost.found.pojo.Item;
import lost.found.pojo.Liuyan;
import lost.found.pojo.Packitem;
import lost.found.pojo.Page;
import lost.found.pojo.Result;
import lost.found.pojo.User;

public interface FunctionService {

	public Result addMsg(int iid,int uid,String msg,HttpServletRequest request);
	public Result addMsgPack(int iid,int uid,String msg,HttpServletRequest request);
	
	public List<Liuyan> getLiuyan(HttpServletRequest request);
	public Page<Item> getFabuItem(int num,int pagesize,int uid);
	
	public Page<Packitem> getFabuPackItem(int num,int pagesize,int uid);
	public Page<Liuyan> getPageLiuyan(HttpServletRequest request,int num,int pagesize);
	public Result updateUser(User u);
	public Page<User> getLeifengbang(int num,int pagesize);
	public User getUserMsg(int id);
	public Result deleteLost(int id);
	public Result deletePack(int id, int type);
	public void deleteLiuyan(int id);
	
}

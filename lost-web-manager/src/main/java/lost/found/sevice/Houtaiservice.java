package lost.found.sevice;

import lost.found.pojo.User;

import javax.servlet.http.HttpServletRequest;

import lost.found.pojo.EasyUIDataGridResult;
import lost.found.pojo.Item;
import lost.found.pojo.Manager;
import lost.found.pojo.Packitem;
import lost.found.pojo.Result;

public interface Houtaiservice {

	EasyUIDataGridResult findUsers(Integer page, Integer rows);

	User findUser(int id);

	Result updateUser(User u);

	Result deleteUser(int[] ids);

	EasyUIDataGridResult findLost(Integer page, Integer rows);

	EasyUIDataGridResult findPack(Integer page, Integer rows);

	Result deletelOST(int[] ids);

	Result deletepack(int[] ids);

	Result updateItem(Item u);

	Result updatePackitem(Packitem u);

	Result impoortSolr();

	Result login(Manager u,HttpServletRequest request);

}

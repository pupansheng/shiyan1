package lost.found.sevice;

import javax.servlet.http.HttpServletRequest;

import lost.found.pojo.Result;
import lost.found.pojo.User;

public interface LogAndReService {
	
	public Result checkUser(String data,String type);
	public Result addUser(User user);
	public void  relative(String code);
	public Result login(User u,HttpServletRequest request);
	public Result zhaohui(String mail);
}

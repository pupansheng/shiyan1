package lost.found.intercept;

import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lost.found.pojo.User;


public class Interceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		
		if(!requestURI.contains("/user/login")){//不包括这个地址的 则表示没有申请用用户信息 则判断有没用户信息 有则直接回应 没有则返回登陆页面
			
		 User user = (User)request.getSession().getAttribute("user");
		if(user!=null){
		return true;
		}
		else{	
			
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path=request.getContextPath();
		String url=request.getRequestURI();
		out.print("<script language=\"javascript\">alert('请先登陆！');window.location.href='"+path+"/page/login?redirect="+url+"'</script>");
 
		out.close();
		/*response.sendRedirect(request.getContextPath()+"/user/login/chuli");//返回登陆页
*/		return false;	
		}
	}
	 else
	   {
		return true;
	   }
}
}

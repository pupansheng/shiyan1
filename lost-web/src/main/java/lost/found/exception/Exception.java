package lost.found.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class Exception implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			java.lang.Exception ex) {
		
         
		// 返回错误页面，给用户友好页面显示错误信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", ex.getMessage());
		modelAndView.setViewName("err");

		
	
		return  modelAndView;
	}

}

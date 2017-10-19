package cn.hr.ssm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.hr.ssm.po.ActiveUser;
import cn.hr.ssm.util.ResourcesUtil;


public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String url = request.getRequestURI();
		//判断是否是匿名访问地址
		//实际开发中需要公开地址在配置文件中配置
		//从配置文件中取匿名访问的url
		List<String> open_urls = ResourcesUtil.getkeyList("anonymousURL");
		for(String open_url:open_urls) {
			if(url.indexOf(open_url) >= 0) {
				return true;
			}
		}
		
		HttpSession session = request.getSession();
		ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
		if(activeUser != null) {
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}

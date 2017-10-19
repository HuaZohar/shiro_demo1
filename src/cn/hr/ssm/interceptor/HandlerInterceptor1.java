package cn.hr.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class HandlerInterceptor1 implements HandlerInterceptor {

	//执行Handler完成，执行此方法
	//应用场景：统一的异常处理，，还可以统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		System.out.println("HandlerInterceptor1.....afterCompletion");
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景：从ModelAndView出发思考，将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一制定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		System.out.println("HandlerInterceptor1.....postHandle");
	}

	//进入Handler方法之前执行
	//进行身份认证，身份授权
	//比如：身份认证，如果认证通过表示当前用户没有登录，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("HandlerInterceptor1.....preHandle");
		//return false 表示拦截，不再向下执行
		//return true 表示放行
		return true;
	}

}

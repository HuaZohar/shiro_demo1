package cn.hr.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hr.ssm.exception.CustomException;
import cn.hr.ssm.po.ActiveUser;
import cn.hr.ssm.service.SysService;

@Controller
public class LoginController {
	
	@Autowired
	private SysService sysService;
	
	//登录用户提交方法
	@RequestMapping("/login")
	public String login(HttpSession session,String randomCode,String usercode,String password) throws Exception{
		
		//校验验证码，防止恶性攻击
		String validateCode = (String) session.getAttribute("validateCode"); 
		//输入的验证码和session中的验证码比较
		if(!randomCode.equals(validateCode)) {
			throw new CustomException("验证码输入错误");
		}
		
		
		//校验service校验用户账户和密码的正确性
		ActiveUser activeUser = sysService.authenticat(usercode, password);
		
		
		session.setAttribute("activeUser", activeUser);
		return "redirect:/first.action";
	}
	//用户退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:/first.action";
	}
	
}

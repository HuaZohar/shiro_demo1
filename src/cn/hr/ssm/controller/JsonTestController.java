package cn.hr.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hr.ssm.po.ItemsCustom;

@Controller
public class JsonTestController {

	//请求json串，输出json串
	//@RequestBody 将请求的商品信息的json转为itemsCustom对象
	//@ResponseBody 将itemsCustom转成json串输出
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) {
		//@ResponseBody 将itemsCustom转成json串输出
		return itemsCustom;
	}
	
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) {
		//@ResponseBody 将itemsCustom转成json串输出
		return itemsCustom;
	}
	
}

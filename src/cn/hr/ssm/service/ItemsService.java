package cn.hr.ssm.service;

import java.util.List;

import cn.hr.ssm.po.ItemsCustom;
import cn.hr.ssm.po.ItemsQueryVo;

public interface ItemsService {
	
	//商品查询列表
	public List<ItemsCustom> findItemList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据ID查询商品信息  使用商品信息的扩展类
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
}

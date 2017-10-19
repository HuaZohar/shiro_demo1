package cn.hr.ssm.mapper;

import java.util.List;

import cn.hr.ssm.po.ItemsCustom;
import cn.hr.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
    public List<ItemsCustom> findItemList(ItemsQueryVo itemsQueryVo) throws Exception;
}
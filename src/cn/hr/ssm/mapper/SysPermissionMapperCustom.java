package cn.hr.ssm.mapper;

import java.util.List;

import cn.hr.ssm.po.SysPermission;

public interface SysPermissionMapperCustom {
    
	public List<SysPermission> findMenuListByUserid(String userid) throws Exception;
	
	public List<SysPermission> findPermissionListByUserid(String userid) throws Exception;
}
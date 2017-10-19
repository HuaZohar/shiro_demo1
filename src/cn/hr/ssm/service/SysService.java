package cn.hr.ssm.service;
/**
 * 认证授权服务接口
 */

import java.util.List;

import cn.hr.ssm.po.ActiveUser;
import cn.hr.ssm.po.SysPermission;
import cn.hr.ssm.po.SysUser;

public interface SysService {
	/**
	 * 根据用户的身份和密码进行认证  如果认证通过返回身份信息
	 * @param userCode 用户账号
	 * @param password 用户面膜
	 * @return 用户身份信息
	 * @throws Exception
	 */
	public ActiveUser authenticat(String userCode,String password) throws Exception;
	
	/**
	 * 根据用户账号查询用户信息
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public SysUser findSysUserByUserCode(String userCode)  throws Exception;
	/**
	 * 根据用户ID查询菜单
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findMenuListByUserid(String userid) throws Exception;
	/**
	 * 根据用户ID查询权限URL
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findPermissionListByUserid(String userid) throws Exception;
}

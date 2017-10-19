package cn.hr.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.hr.ssm.exception.CustomException;
import cn.hr.ssm.mapper.SysPermissionMapperCustom;
import cn.hr.ssm.mapper.SysUserMapper;
import cn.hr.ssm.po.ActiveUser;
import cn.hr.ssm.po.SysPermission;
import cn.hr.ssm.po.SysUser;
import cn.hr.ssm.po.SysUserExample;
import cn.hr.ssm.service.SysService;
import cn.hr.ssm.util.MD5;

/**
 * 认证授权服务接口实现类
 */
public class SysServiceImpl implements SysService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;
	
	@Override
	public ActiveUser authenticat(String userCode, String password) throws Exception {
		// TODO Auto-generated method stub
		
//		根据用户账号查询用户信息
		
		SysUser sysUser = this.findSysUserByUserCode(userCode);
		if(sysUser == null) {
			throw new CustomException("用户账号不存在");
		}
		
		//数据库密码 MD5加密过的
		String password_db = sysUser.getPassword();
		
		//对输入的密码和数据库密码 进行对比，如果一致，认证通过
		//对页面输入的密码进行 MD5加密
		String password_input_md5 = new MD5().getMD5ofStr(password);
		if(!password_input_md5.equalsIgnoreCase(password_db)) {
			throw new CustomException("用户或密码错误");
		}
		
		//得到用户ID
		String userid = sysUser.getId();
		List<SysPermission> menus = this.findMenuListByUserid(userid);		
		List<SysPermission> permissions = this.findPermissionListByUserid(userid);
		
		
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(sysUser.getId());
		activeUser.setUsercode(userCode);
		activeUser.setUsername(sysUser.getUsername());
		
		activeUser.setMenus(menus);
		activeUser.setPermissions(permissions);
		
		return activeUser;
	}
	
	//根据用户账号查询用户信息
	public SysUser findSysUserByUserCode(String userCode)  throws Exception{
		
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(userCode);
		
		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
		if(list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<SysPermission> findMenuListByUserid(String userid) throws Exception {
		// TODO Auto-generated method stub
		return sysPermissionMapperCustom.findMenuListByUserid(userid);
	}

	@Override
	public List<SysPermission> findPermissionListByUserid(String userid) throws Exception {
		// TODO Auto-generated method stub
		return sysPermissionMapperCustom.findPermissionListByUserid(userid);
	}

}

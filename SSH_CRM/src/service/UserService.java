package service;

import java.util.List;

import entity.SysUser;

public interface UserService {
	//登录
	public SysUser login(SysUser user);
	
	//注册用户
	public void addUser(SysUser user);
	
	//多条件分页查询
	public List<SysUser> findAll(SysUser user,int page,int num);
	
	//多条件查询——得到有多少条
	public int findCount(SysUser user);
}

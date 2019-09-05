package service.imp;

import java.util.List;

import entity.SysUser;
import entity.SysUserDAO;
import service.UserService;

public class Imp_UserService implements UserService{
	SysUserDAO userDao;	//用户Dao
	
	public SysUserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(SysUserDAO userDao) {
		this.userDao = userDao;
	}

	//登录
	public SysUser login(SysUser user) {
		List<SysUser> userList = userDao.findByProperty("usrName", user.getUsrName());
		if(userList!=null && userList.size()>0)
		{
			SysUser loginUser = userList.get(0);
			//判断密码是否相同
			if(loginUser.getUsrPassword().equals(user.getUsrPassword()))
			{
				return loginUser;
			}
		}
		return null;	//其他则返回空
	}
	
	//注册
	public void addUser(SysUser user) {
		userDao.save(user);
	}
	
	//多条件分页查询
	public List<SysUser> findAll(SysUser user, int page, int num) {
		List<SysUser>  list =userDao.findByAll(user, (page-1)*num, num);
		return list;
	}
	
	//多条件查询
	public int findCount(SysUser user) {
		return userDao.findCount(user);
	}
}


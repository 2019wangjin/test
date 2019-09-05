package service.imp;

import java.util.List;

import entity.SysUser;
import entity.SysUserDAO;
import service.UserService;

public class Imp_UserService implements UserService{
	SysUserDAO userDao;	//�û�Dao
	
	public SysUserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(SysUserDAO userDao) {
		this.userDao = userDao;
	}

	//��¼
	public SysUser login(SysUser user) {
		List<SysUser> userList = userDao.findByProperty("usrName", user.getUsrName());
		if(userList!=null && userList.size()>0)
		{
			SysUser loginUser = userList.get(0);
			//�ж������Ƿ���ͬ
			if(loginUser.getUsrPassword().equals(user.getUsrPassword()))
			{
				return loginUser;
			}
		}
		return null;	//�����򷵻ؿ�
	}
	
	//ע��
	public void addUser(SysUser user) {
		userDao.save(user);
	}
	
	//��������ҳ��ѯ
	public List<SysUser> findAll(SysUser user, int page, int num) {
		List<SysUser>  list =userDao.findByAll(user, (page-1)*num, num);
		return list;
	}
	
	//��������ѯ
	public int findCount(SysUser user) {
		return userDao.findCount(user);
	}
}


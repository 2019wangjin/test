package service.imp;

import java.util.List;

import entity.SysRole;
import entity.SysRoleDAO;
import service.RoleService;

public class Imp_RoleService implements RoleService{
	SysRoleDAO srDao;
	public SysRoleDAO getSrDao() {
		return srDao;
	}
	public void setSrDao(SysRoleDAO srDao) {
		this.srDao = srDao;
	}
	//²éÑ¯ËùÓÐ
	public List<SysRole> findAll() {
		return srDao.findAll();
	}
}

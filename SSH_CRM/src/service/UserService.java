package service;

import java.util.List;

import entity.SysUser;

public interface UserService {
	//��¼
	public SysUser login(SysUser user);
	
	//ע���û�
	public void addUser(SysUser user);
	
	//��������ҳ��ѯ
	public List<SysUser> findAll(SysUser user,int page,int num);
	
	//��������ѯ�����õ��ж�����
	public int findCount(SysUser user);
}

package service;

import java.util.List;

import entity.SysRole;

public interface RoleService {
	//��ѯ����
	public List<SysRole> findAll();

	//���
	public void add();

	//�޸�
	public void update();

	//����������
	//����ע��
}

package action;

import java.util.List;

import common.ResultData;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import entity.SysRole;
import service.RoleService;

public class RoleAction extends BaseAction{
	RoleService rs;
	List<SysRole> srList;

	public List<SysRole> getSrList() {
		return srList;
	}
	public void setSrList(List<SysRole> srList) {
		this.srList = srList;
	}
	public RoleService getRs() {
		return rs;
	}
	public void setRs(RoleService rs) {
		this.rs = rs;
	}
	
	
	//��ѯ����
	public void ajaxFindAll()
	{
		srList = rs.findAll();
//		//����json������,���ñ��ų������Ժͷ���,������Ϊ���������Ի�����á�����ѭ��
		ResultData rd = ResultData.SeccessResult(null, srList);
		//����json�����ö���������Ҫ���ų�ת��������
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"sysUsers","sysRoleRights"});
		//ת����json���
		writeJson(JSONObject.fromObject(rd, jsonConfig).toString());
	}
	
}

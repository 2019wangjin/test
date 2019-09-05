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
	
	
	//查询所有
	public void ajaxFindAll()
	{
		srList = rs.findAll();
//		//设置json的配置,设置被排除的属性和方法,这是因为这两个属性互相调用——死循环
		ResultData rd = ResultData.SeccessResult(null, srList);
		//创建json的配置对象，设置需要被排除转换的属性
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"sysUsers","sysRoleRights"});
		//转换成json输出
		writeJson(JSONObject.fromObject(rd, jsonConfig).toString());
	}
	
}

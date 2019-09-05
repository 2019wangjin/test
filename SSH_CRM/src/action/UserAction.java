package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import common.Constants;
import common.ResultData;

import entity.SysRole;
import entity.SysUser;
import service.UserService;

public class UserAction extends BaseAction{
	UserService userService;	//�û��ӿ�
	SysUser u;	//�û�����
	SysUser byUser = new SysUser();	//������ѯ�Ķ���
	int page=1;	//��ǰҳ��
	int num=3;	//��ʾ����
	List<SysUser> userList;
	int count;	//�ܹ�������
	int maxPage;	//�ܹ�����ҳ
	
	public SysUser getByUser() {
		return byUser;
	}
	public void setByUser(SysUser byUser) {
		byUser.setUsrName("");
		this.byUser = byUser;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<SysUser> getUserList() {
		return userList;
	}
	public void setUserList(List<SysUser> userList) {
		this.userList = userList;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public SysUser getU() {
		return u;
	}
	public void setU(SysUser u) {
		this.u = u;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	//�������ͨ��¼
	public String login()
	{
		SysUser user = userService.login(u);
		if(user!=null)
		{
			//�洢��session��
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(Constants.SESSION_LOGIN, user);
			return "LoginSuccess";
		}
		else
		{
			return "LoginFial";
		}
	}
	
	//��ת����¼ҳ��
	public String toLogin()
	{
		return "toLogin";
	}
	public String LoginSuccess()
	{
		return "LoginSuccess";
	}
	public String toIndex()
	{
		return "toIndex";
	}
	
	//�����ajax��¼ ����û�з���ֵ
	public void ajaxLogin()
	{
		//�õ�response
		HttpServletResponse response = ServletActionContext.getResponse();
		//���ñ���
		response.setCharacterEncoding("utf-8");
		//���ø�ʽ
		response.setContentType("application/json");
		
		SysUser user = userService.login(u);
		String result;
		if(user!=null)
		{
			//�洢��session��
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(Constants.SESSION_LOGIN, user);
			//����¼�ɹ�״̬��Ϣʹ��json���س�ȥ
			result = JSONObject.fromObject(ResultData.SeccessResult("��¼�ɹ�", null)).toString();
		}
		else
		{
			result = JSONObject.fromObject(ResultData.FAILResult("��¼ʧ�ܣ��˺��������", null)).toString();
		}
		try {
			PrintWriter out= response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ʹ��ajaxע���û�
	public void ajaxAddUser()
	{
		SysRole sr = new SysRole();
		if(u.getSysRole() == null)
		{
			sr.setRoleId(Long.parseLong("1"));
			u.setSysRole(sr);
			//�����û�Ĭ�ϵ�״̬
			u.setUsrFlag(Long.parseLong("1"));	//Ĭ������
		}
		
		ResultData resultData = null;
		try{
			userService.addUser(u);
			resultData = ResultData.SeccessResult("ע��ɹ�", null);
		}
		catch(Exception e)
		{
			resultData = ResultData.FAILResult("ע��ʧ��", null);
		}finally{
			String result = JSONObject.fromObject(resultData).toString();
			writeJson(result);
			u = null;
		}
	}
	
	//�˳���¼
	public String exitLogin()
	{
		//�õ�session���������
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "toLogin";
	}
	
	//��������ҳ��ѯ
	public String findByAll()
	{
		
		//�õ�������
		count = userService.findCount(byUser);
		//�õ���ҳ��
		maxPage = count%num==0?count/num:count/num+1;
		
		if(page<=1)
		{
			page= 1;
		}
		if(page>=maxPage)
		{
			page = maxPage;
		}
		
		//�õ�����
		userList = userService.findAll(byUser, page, num);
		byUser.setUsrName("");	//���ò�ѯ����
		return "findByAll";
	}
}

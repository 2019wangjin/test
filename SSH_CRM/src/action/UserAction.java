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
	UserService userService;	//用户接口
	SysUser u;	//用户对象
	SysUser byUser = new SysUser();	//条件查询的对象
	int page=1;	//当前页数
	int num=3;	//显示几行
	List<SysUser> userList;
	int count;	//总共多少条
	int maxPage;	//总共多少页
	
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
	
	
	//这个是普通登录
	public String login()
	{
		SysUser user = userService.login(u);
		if(user!=null)
		{
			//存储到session中
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(Constants.SESSION_LOGIN, user);
			return "LoginSuccess";
		}
		else
		{
			return "LoginFial";
		}
	}
	
	//跳转到登录页面
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
	
	//这个是ajax登录 ——没有返回值
	public void ajaxLogin()
	{
		//得到response
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置编码
		response.setCharacterEncoding("utf-8");
		//设置格式
		response.setContentType("application/json");
		
		SysUser user = userService.login(u);
		String result;
		if(user!=null)
		{
			//存储到session中
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(Constants.SESSION_LOGIN, user);
			//将登录成功状态信息使用json返回出去
			result = JSONObject.fromObject(ResultData.SeccessResult("登录成功", null)).toString();
		}
		else
		{
			result = JSONObject.fromObject(ResultData.FAILResult("登录失败，账号密码错误！", null)).toString();
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
	
	//使用ajax注册用户
	public void ajaxAddUser()
	{
		SysRole sr = new SysRole();
		if(u.getSysRole() == null)
		{
			sr.setRoleId(Long.parseLong("1"));
			u.setSysRole(sr);
			//设置用户默认的状态
			u.setUsrFlag(Long.parseLong("1"));	//默认正常
		}
		
		ResultData resultData = null;
		try{
			userService.addUser(u);
			resultData = ResultData.SeccessResult("注册成功", null);
		}
		catch(Exception e)
		{
			resultData = ResultData.FAILResult("注册失败", null);
		}finally{
			String result = JSONObject.fromObject(resultData).toString();
			writeJson(result);
			u = null;
		}
	}
	
	//退出登录
	public String exitLogin()
	{
		//得到session，并且情况
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "toLogin";
	}
	
	//多条件分页查询
	public String findByAll()
	{
		
		//得到总行数
		count = userService.findCount(byUser);
		//得到总页数
		maxPage = count%num==0?count/num:count/num+1;
		
		if(page<=1)
		{
			page= 1;
		}
		if(page>=maxPage)
		{
			page = maxPage;
		}
		
		//得到集合
		userList = userService.findAll(byUser, page, num);
		byUser.setUsrName("");	//重置查询姓名
		return "findByAll";
	}
}

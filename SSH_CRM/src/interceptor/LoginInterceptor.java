package interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import common.Constants;
import entity.SysUser;

public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//�ж�Session���Ƿ��¼
		HttpSession session = ServletActionContext.getRequest().getSession();
		SysUser loginUser = (SysUser) session.getAttribute(Constants.SESSION_LOGIN);
		if(loginUser != null)
		{
			return invocation.invoke();	//ִ�з���
		}
		return "toLogin";
	}
}

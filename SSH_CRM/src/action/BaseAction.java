package action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

public class BaseAction {
	public void writeJson(String result)
	{
		//得到response
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置编码
		response.setCharacterEncoding("utf-8");
		//设置格式
		response.setContentType("application/json");
		try {
			PrintWriter out= response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//跳转到首页
	public String toIndex()
	{
		return "toIndex";
	}
	//跳转到登录失败页面
	public String LoginFial()
	{
		return "LoginFial";
	}
	//跳转到登录页面
	public String toLogin()
	{
		return "toLogin";
	}
}

package action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

public class BaseAction {
	public void writeJson(String result)
	{
		//�õ�response
		HttpServletResponse response = ServletActionContext.getResponse();
		//���ñ���
		response.setCharacterEncoding("utf-8");
		//���ø�ʽ
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
	
	//��ת����ҳ
	public String toIndex()
	{
		return "toIndex";
	}
	//��ת����¼ʧ��ҳ��
	public String LoginFial()
	{
		return "LoginFial";
	}
	//��ת����¼ҳ��
	public String toLogin()
	{
		return "toLogin";
	}
}

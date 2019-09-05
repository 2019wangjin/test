package common;

public class ResultData {
	int code;	//״̬��
	String message;		//���ص���Ϣ
	Object data;	//���ص�����
	
	public static final int SUCCESS = 200;
	public static final int FAIL = 201;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	//����һ����̬�ĳɹ�����
	public static ResultData SeccessResult(String message,Object data)
	{
		ResultData rd = new ResultData();
		rd.setCode(SUCCESS);
		rd.setMessage(message);
		rd.setData(data);
		return rd;
	}
	
	//����һ����̬��ʧ�ܷ���
	public static ResultData FAILResult(String message,Object data)
	{
		ResultData rd = new ResultData();
		rd.setCode(FAIL);
		rd.setMessage(message);
		rd.setData(data);
		return rd;
	}
}

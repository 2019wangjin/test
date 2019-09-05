package common;

public class ResultData {
	int code;	//状态码
	String message;		//返回的消息
	Object data;	//返回的数据
	
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

	//创建一个静态的成功方法
	public static ResultData SeccessResult(String message,Object data)
	{
		ResultData rd = new ResultData();
		rd.setCode(SUCCESS);
		rd.setMessage(message);
		rd.setData(data);
		return rd;
	}
	
	//创建一个静态的失败方法
	public static ResultData FAILResult(String message,Object data)
	{
		ResultData rd = new ResultData();
		rd.setCode(FAIL);
		rd.setMessage(message);
		rd.setData(data);
		return rd;
	}
}

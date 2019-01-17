package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	
	
	//提供setter方法 ,拦截器会给调用方法给属性设置 值
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		System.out.println("ojbk");
		System.out.println(username + "," + password);
		//将参数设置到session作用域中
		ActionContext.getContext().getSession().put("USER_IN_SESSION", username);
		return SUCCESS;
	}
}

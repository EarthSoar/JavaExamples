package parameter;

import com.opensymphony.xwork2.ActionSupport;

//Action获取请求参数三种方式:
//第一种:Action本身作为Model对象，通过setter方法封装(属性注入)
public class LoginAction1 extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		System.out.println(username + "," + password);
		return NONE;
	}
}

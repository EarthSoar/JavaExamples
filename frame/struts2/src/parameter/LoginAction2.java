package parameter;

import com.opensymphony.xwork2.ActionSupport;

//第二种:创建独立Model对象，页面通过ognl表达式封装(属性注入)使用最多的方式;
public class LoginAction2 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	
	/**
	 *	jsp中的 user.username 用action对象调用getUser()得到user对象然后给属性设置值
	 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}

package validation;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	//覆盖校验方法，编写校验规则
	public void validate() {
		System.out.println("校验");
		if(username == null || username.length() < 6) {
			//把错误的信息存起来，此时默认需要跳转到input视图
			super.addFieldError("username", "账号不能少于6位");
		}
		if(password == null || password.length() < 6) {
			super.addFieldError("password", "密码不能少于6位");
		}
	}
	
	//需要做校验
	@InputConfig(resultName="edit")//校验失败跳到"edit"视图
	public void save() {
		System.out.println("保存...");
	}
	
	@Override
	@SkipValidation//不需要做校验
	public String execute() throws Exception {
		System.out.println("giao~~");
		return NONE;
	}
}

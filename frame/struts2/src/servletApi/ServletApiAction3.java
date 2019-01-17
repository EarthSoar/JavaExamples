package servletApi;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//方式三：使用ActionContext类,本身是Struts2对Servlet API的封装.
public class ServletApiAction3 extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		//获取请求参数
		Map<String, Object> parameters = ActionContext.getContext().getParameters();
		System.out.println(parameters);
		
		//request作用域
		ActionContext.getContext().put("requestName", "requestValue");
		//Session作用域
		ActionContext.getContext().getSession().put("sessionName", "sessionValue");
		//application作用域
		ActionContext.getContext().getApplication().put("applicationName", "applicationValue");
		return SUCCESS;
	}
}

package servletApi;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

//访问Servlet api的方式
//方式一:  Action类实现感知接口
public class ServletApiAction1 extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
 	@Override
	public String execute() throws Exception {
 		//获取请求参数
		System.out.println("HHH" + request.getParameter("name"));
		return SUCCESS;
	}
	//注意这里依赖于servlet-api.jar
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}
	
}

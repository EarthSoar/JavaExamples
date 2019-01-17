package servletApi;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//方式二;使用ServletActionContext 静态方法调用获取api
public class ServletApiAction2 extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		System.out.println("objk" + ServletActionContext.getRequest().getParameter("name"));
		ServletActionContext.getRequest().getSession().setAttribute("sessionKey", "我是session");
		ServletActionContext.getResponse().sendRedirect("/view/welcome.jsp");
		return NONE;
	}
}

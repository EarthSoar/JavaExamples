package inherit;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author 15626
 *	处理一般的请求和响应，只需要继承这个类，并且覆盖类中的service方法
 */
abstract public class MyGenericServlet implements Serializable,ServletConfig,javax.servlet.Servlet{
	private static final long serialVersionUID = 1L;
	
	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		init();
	}
	
	//提供一个方法，子类覆盖这个方法，专门供子类初始化。
	public void init() {
		//NOOP
	}

	//把ServletConfig对象暴露给子类访问
	public ServletConfig getServletConfig() {
		return this.config;
	}
	//定义一个抽象方法，让子类必须覆盖service方法
	abstract public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;
	
	public String getServletInfo() {
		return null;
	}

	public void destroy() {
	}

	
	
	//下面的几个方法都是ServletConfig接口中的方法
	public String getServletName() {
		return getServletConfig().getServletName();
	}

	public ServletContext getServletContext() {
		return getServletConfig().getServletContext();
	}

	public String getInitParameter(String name) {
		return getServletConfig().getInitParameter(name);
	}

	public Enumeration<String> getInitParameterNames() {
		return getServletConfig().getInitParameterNames();
	}
	
}

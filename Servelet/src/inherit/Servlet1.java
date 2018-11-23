package inherit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends MyHttpServlet{
	private static final long serialVersionUID = 1L;
	
/*	public void init(ServletConfig config) throws ServletException {
		//覆盖父类的初始化方法，但是根据Servlet的生命周期，此时子类需要初始化化必须先调用父类的初始化
		//super.init(config);
		System.out.println("子类的初始化操作");
	}*/
	public void init() {
		
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		/*String name = super.getInitParameter("name");
		System.out.println(name);*/
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}
}

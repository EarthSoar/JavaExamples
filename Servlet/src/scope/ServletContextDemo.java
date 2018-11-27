package scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context")
public class ServletContextDemo extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 常用获取ServletContext对象方法：
		 * 	 第一种. req.getServletContext  (Tomcat7开始支持)
		 * 	 第二种. super.getServletContext  (这是ServletConfig中的方法,这里调用父类方法)
		 * 	 第三种. req.getSession().getServetContext();
		 */
		
		ServletContext sc = req.getServletContext();
		
		//返回当前资源的绝对路径
		String realPath = sc.getRealPath("/WEB-INF/test.html");
		System.out.println(realPath);
		
		//返回当前响应的上下文路径,也就是<Context path="">中path属性的值.不配置的话，没有打印结果
		String path = sc.getContextPath();
		System.out.println(path);

		//获取全局的初始化参数,但是不能获取局部的初始化参数，同样局部初始化也不能获取全局参数化的参数值
		String initParameter = sc.getInitParameter("name");
		System.out.println(initParameter);
	}
}

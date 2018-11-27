package scope;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	三大作用域对象，包括request,session,servletcontext(application)
 *	作用域的目的：共享数据
 *
 *
 * 共享数据:
 * 	设置共享数据：作用域对象.setAttribute(String name,Object value);
 * 	获取共享数据：Object value = 作用域对象.getAttribute(String name);
 * 	删除共享数据: 作用域对象.removeAttribute(String name);
 */

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		
		/**
		 * request作用域对象
		 * 每一次请求都是一个request对象,需要共享同一请求的数据，只能使用请求转发
		 */
		Integer rnum = (Integer) req.getAttribute("IN_REQUEST");
		if(rnum == null) {
			req.setAttribute("IN_REQUEST", 1);
		} else {
			req.setAttribute("IN_REQUEST", rnum + 1);
		}
		//===================================================
		/**
		 * session作用域对象
		 * 每一次回话是一个session对象,再一次回话中共享数据需要使用session
		 */	
		Integer num = (Integer) req.getSession().getAttribute("IN_SESSION");
		if(num == null) {
			req.getSession().setAttribute("IN_SESSION", 1);
		} else {
			req.getSession().setAttribute("IN_SESSION", num + 1);
		}
		//====================================================
		/**
		 * servletcontext  (application)
		 * Tomcat从启动到关闭表示一个应用,application是应用作业域对象，作用域整个WEB应用,可以实现多个回话共享数据
		 * 
		 * 常用获取ServletContext对象方法：
		 * 	 第一种. req.getServletContext  (Tomcat7开始支持)
		 * 	 第二种. super.getServletContext  (这是ServletConfig中的方法,这里调用父类方法)
		 * 	 第三种. req.getSession().getServetContext();
		 */
//		ServletContext sc = req.getServletContext();
//		ServletContext sc2 = super.getServletContext();
//		ServletContext sc3 =  req.getSession().getServeltContext();
		
		Integer cnum = (Integer) super.getServletContext().getAttribute("IN_CONTEXT");
		if(num == null) {
			super.getServletContext().setAttribute("IN_CONTEXT", 1);
		} else {
			super.getServletContext().setAttribute("IN_CONTEXT", cnum + 1);
		}
		//请求转发
		req.getRequestDispatcher("/result").forward(req, resp);;
	}
}

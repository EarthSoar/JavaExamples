package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求和响应参数编码格式为UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		String username = req.getParameter("username");
		
		/**
		//创建和获取Session对象
		 * getSession(boolean create);  
		 * true(缺省) ： 若当前请求中存在session对象，就直接返回，如果不存在就创建一个再返回
		 * false:  若当前请求中存在session对象，就直接返回，如果不存在返回null;
		 */
		HttpSession session = req.getSession();
		
		/**
		 * 	往session中存储数据
		 */
		session.setAttribute("USER_IN_SESSION", username);
		
		/**
		 * Session的超时管理
		 * 客户端和服务器没有交互会自动断开
		 */
		
		
		/**
		 * 删除session
		 * 1.删除指定属性名的值
		 * 2.销毁session
		 */
//		session.removeAttribute("USER_IN_SESSION");
//		session.invalidate();
		
		
		session.setMaxInactiveInterval(30);//30s
		writer.print("欢迎"+username+"<br/>");
		writer.println("<a href='/session/list'>收件箱</a>");
	}
}

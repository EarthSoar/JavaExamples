package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//方式1销毁session(推荐)
		req.getSession().invalidate();
		//方式2删除session的属性
		//req.getSession().removeAttribute("USER_IN_SESSION");
		
		
		//跳转到登录页面
		resp.sendRedirect("/login.jsp");
	}
}

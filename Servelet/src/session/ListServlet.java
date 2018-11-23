package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		String username = "";
		
		HttpSession session = req.getSession();
		//从session中取出数据
		username = (String)session.getAttribute("USER_IN_SESSION");
		writer.println("欢迎"+username + "<br/>");
		for(int i = 0; i < 6; i++) {
			writer.print("<a href='/session/get'>您有一封新邮件</a> <br/>");
		}
	}
}

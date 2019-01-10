package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import damain.User;
import dao.IUserDAO;
import dao.impl.UserDAOImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserDAO dao = null;
	public void init() throws ServletException {
		dao = new UserDAOImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//1.接收请求参数
		String randomCode = req.getParameter("randomCode");//验证码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//调用业务方法处理请求
		
		//====先检查验证码是否正确
		String randomCodeInSession = (String) req.getSession().getAttribute("RANDOMCODE_IN_SESSION");
		if(!randomCode.equalsIgnoreCase(randomCodeInSession)) {//比较用户输入和session中存在的是否相同,忽略大小写
			req.setAttribute("error", "对不起,验证码错误或者已经过期");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		req.getSession().removeAttribute("RANDOMCODE_IN_SESSION");//销毁session保留的验证码的值, 避免重复提交
		//检查账户是否存在
		User user = dao.getUserByUsername(username);
		if(user == null) {
			req.setAttribute("error", "账号不存在或者被禁止登录");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);;
			return ;
		}
		//检查密码是否正确
		if(!password.equals(user.getPassword())) {
			req.setAttribute("error", "密码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		//把登录用户的对象信息存储在session作用域中
		req.getSession().setAttribute("USER_IN_SESSION", user);
		resp.sendRedirect("/product");
	}
}

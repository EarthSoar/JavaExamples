package redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect/a")
public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String ret = req.getParameter("name");
		out.println("Servlet1网页显示");
		
		System.out.println("Servlet1URL重定向之前" + ret);
		
		//URL重定向
		//和请求转发相同里面的资源路径都是相对路径
		//resp.sendRedirect("/redirect/b");
		
		/**
		 * URL重定向跨域访问
		 */
		resp.sendRedirect("https://www.baidu.com/");
		
		/**
		 * 重定向就相当于把目标地址复制到浏览器地址栏中敲回车,是两次不同的请求，所以不能共享数据，也不能访问WEB-INF目录下的文件
		 */
		//resp.sendRedirect("/WEB-INF/test.html");
		
		System.out.println("Servlet1 URL重定向后" + ret);
	}
}

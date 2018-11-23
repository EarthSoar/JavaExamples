package forword;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制台结果：
 *  Servlet1控制台打印,转发前
 *  Servlet2的控制台打印
 *  Servlet1控制台打印,转发后
 * 浏览器结果:
 * 	Servlet2的内容 
 * 
 * @author 15626
 *
 */
@WebServlet("/forword/f2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("Servlet2的内容");
		System.out.println("Servlet2的控制台打印");
	}
}

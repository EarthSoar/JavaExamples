package forword;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forword/f1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		System.out.println("Servlet1控制台打印,转发前");
		writer.println("Hello");
		
		//请求转发
		/**
		 * 参数中如果写成forword/f2,少了/,会把当前url-pattern的最后一个/前面的一部分,如当前的 ：  /forword/ 作为相对路径,
		 * 去寻找/forword/forword/f2这个资源，找不到就会报404
		 * 
		 * 绝对路径/forword/f2 前面的 / 表示当前项目的根路径
		 */
		req.getRequestDispatcher("/forword/f2").forward(req, resp);
		
		/**
		 * 请求和转发只能在当前项目下,可以间接的访问WEB-INF下目录下的资源.     (WEB-INF下的资源不能直接访问)
		 */
		//req.getRequestDispatcher("/WEB-INF/test.html").forward(req, resp);;
		
		writer.println("Servlet1的内容");
		System.out.println("Servlet1控制台打印,转发后");
	}
}

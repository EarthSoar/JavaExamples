package response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ResponseServletDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 演示处理HTTP响应的方法
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 解决输出中文乱码问题
		 */
		resp.setCharacterEncoding("UTF-8");
		//设置输出的MIME类型,设置为html
		resp.setContentType("text/html");
		
		//上面两行代码也可以合并在一起写成：
		//resp.setContentType("text/html;charset=utf-8");
		
		/**
		 * 获取字节输出流对象，不能与字节输出流共存
		 */
		//OutputStream out = resp.getOutputStream();
		//out.write("Hello".getBytes());
		
		/**
		 * 获取符输出流对象
		 */
		PrintWriter p = resp.getWriter();
		p.println("你好");//这里的换行并不作用，在网页中是以html形式显示的，换行用br标签
		p.print("Hello");
	}
}

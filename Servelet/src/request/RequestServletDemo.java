package request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求的常用方法测试
 */
public class RequestServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//返回请求方式
		String way = req.getMethod();
		System.out.println(way);
		
		//返回请求行中的资源名称，也就是
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		//返回地址栏中的信息
		StringBuffer url = req.getRequestURL();
		System.out.println(url);
		
		//返回service.xml中 Context元素中的path属性值
		String path = req.getContextPath();
		System.out.println(path);
		
		//返回请求的ip地址
		String ip = req.getRemoteAddr();
		System.out.println(ip);
		
		//返回指定名称的请求头信息
		String ret = req.getHeader("User-Agent");
		System.out.println(ret);
		
	}
}

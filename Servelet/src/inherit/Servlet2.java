package inherit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		//自己的初始化操作
	}

	//编写Servlet方式一
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编写处理请求的代码
		//不能调用父类中 的service  :  super.service();
	}
	
	
	
	//编写Servlet方式二
	//处理POST请求
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	//处理GET请求
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理全部的请求
	}
}

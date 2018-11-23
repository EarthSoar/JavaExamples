package inherit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends MyGenericServlet {

	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//将一般的请求和响应转换为遵循http协议的请求和响应
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//处理http协议的请求和响应
		service(request,response);
	}
	public void service(HttpServletRequest req,HttpServletResponse res) {
		if("GET".equals(req.getMethod())) {
			doGet(req,res);
		}else {
			doPost(req,res);
		}
	}
	//处理POST请求
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		this.doPost(req, res);
	}
	//处理GET请求
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		//编写处理所请求的代码
	}
}

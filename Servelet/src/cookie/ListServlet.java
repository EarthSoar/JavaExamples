package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		String username = "";
		//Cookie存在请求头中，在请求中获取数据
		Cookie[] cs = req.getCookies();
		if(cs != null) {
			for (Cookie cookie : cs) {
				//获取当前cookie对象的名称
				if("currentName".equals(cookie.getName())) {
					//获取cookie的值   解码
					username = URLDecoder.decode(cookie.getValue(), "UTF-8");
				}
			}
		}
		writer.println("欢迎"+username + "<br/>");
		for(int i = 0; i < 6; i++) {
			writer.print("<a href='/cookie/get'>您有一封新邮件</a> <br/>");
		}
	}
}

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

@WebServlet("/cookie/get")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		String username = "";
		//从请求头中获取cookie对象
		Cookie[] cs = req.getCookies();
		if(cs != null) {
			for (Cookie cookie : cs) {
				if("currentName".equals(cookie.getName())){
					username = URLDecoder.decode(cookie.getValue(), "UTF-8");
				}
			}
		}
		writer.println("当前账户" + username +"<br/>");
		writer.print("众位大咖邀请您参加宴会");
	}
}

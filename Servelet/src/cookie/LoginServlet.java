package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求和响应参数编码格式为UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		String username = req.getParameter("username");
		
		//创建cookie对象
		//对中文的进行编码
		Cookie c = new Cookie("currentName", URLEncoder.encode(username, "UTF-8"));
		//把cookie对象添加到对浏览器的响应中，把数据存储在浏览器中
		resp.addCookie(c);
		
		
		/**
		 * 	修改cookie:
		 *	方法1：设置相同名称的key,覆盖上一个，还要把获取的cookie对象添加到响应中去
		 *	方法2：调用setValue();  此时还需要把对象重新加入到响应中
		 */
		//方法1：设置相同名称的key,覆盖上一个，还要把获取的cookie对象添加到响应中去
//		Cookie c2 = new Cookie("currentName","HHH");
//		resp.addCookie(c2);
//		//方法2：调用setValue();  此时还需要把对象重新加入到响应中
//		c.setValue("HHH");
//		resp.addCookie(c);
		
		/**
		 * 设置cookie的存活时间
		 */		
		//c.setMaxAge(-1); // 回话cookie,缺省.  浏览器关闭cookie也就消失
		//c.setMaxAge(0); // 删除cookie
		//c.setMaxAge(10); //设置cookie可以存活的时间是10s
		
		/**
		 * 设置cookie的path为"/"，设置整个根路径都可以共享这个cookie,
		 * 默认情况是最后一个 / ，  例如/cookie/login,只会对cookie/list共享并不会对 /xx/list共享
		 */
		c.setPath("/");
		
		
		writer.print("欢迎"+username+"<br/>");
		writer.println("<a href='/cookie/list'>收件箱</a>");
	}
}

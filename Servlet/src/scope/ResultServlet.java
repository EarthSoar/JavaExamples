package scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		Integer rnum = (Integer) req.getAttribute("IN_REQUEST");
		out.println("request="+rnum);//一直是1,因为每一次请求都是新的request对象
		
		
		//获取作用域的共享数据
		Integer num = (Integer) req.getSession().getAttribute("IN_SESSION");
		out.println("</br>session="+num);//从1开始，没请求一次增加1,当回话结束就会从1重新开始
		
		Integer cnum = (Integer) req.getServletContext().getAttribute("IN_CONTEXT");
		out.print("</br>servletcontext=" + cnum );
		
	}
}

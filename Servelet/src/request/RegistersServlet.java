package request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//默认是ISO-8859-1不支持中文，可以设置编码为UTF-8,这只适用于POST方式
		//req.setCharacterEncoding("UTF-8");
		// 获取请求参数的值
		String username = req.getParameter("username");
		
		/*
		 * 
		 * 方式一：解决中文乱码
			//1.按照ISO-8859-1把乱码恢复成二进制形式
			byte[] data = username.getBytes("ISO-8859-1");
			//2.对二进制形式重新编码为UTF-8
			username = new String(data,"UTF-8");
		*
		*	方式二(推荐)：可以调用req.setCharacterEncoding("UTF-8");//适用于POST方式
		*	方式三：修改service.xml配置文件中修改端口的的元素<Connector/>,修改GET方式的默认编码： URIcoding = "UTF-8";//适用于GET方式
		*/

		String password = req.getParameter("password");
		System.out.println(username + "," + password);
		// 参数有多个值会返回返回一个数组
		String[] hobby = req.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobby));
		// 返回参数-值的Map
		Map<String,String[]> map = req.getParameterMap();
		System.out.println(map);
		
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name);
		}
	}
}

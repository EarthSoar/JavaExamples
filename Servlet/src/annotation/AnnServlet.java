package annotation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * value属性是一个数组，所有可以传多个，以为url-pattern也可以有多个值
 * 
 *   初始化参数initParams的属性的类型还是个@WebInitParam注解，并且是一个数组
 */
@WebServlet(value = {"/test","/hello"} ,initParams = 
		{ @WebInitParam( name = "encoding" ,value = "UTF-8"),
		  @WebInitParam( name = "name" , value = "Willing")
		}
)
public class AnnServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取初始化参数
		String encoding = getInitParameter("encoding");
		String name = getInitParameter("name");
		System.out.println(encoding+","+name);
	}
}

package initparam;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author 15626
 *	获取初始化参数
 */
public class InitParamsServlet implements javax.servlet.Servlet{

	ServletConfig config;//把config对象定义为成员变量
	@Override  
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}


	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//String encoding = "GBK";
		//根据初始化参数名来获取初始化的参数值
		String encoding =  config.getInitParameter("encoding");
		
		Enumeration<String> en = config.getInitParameterNames();
		while(en.hasMoreElements()) {
			String name = en.nextElement();//获取初始化参数名称
			//获取初始化参数名称和值
			System.out.println(name + config.getInitParameter(name));
		}
		if("GBK".equals(encoding)) {
			System.out.println("你好世界");
		}else {
			System.out.println("Hello World");
		}
	}

	@Override
	public String getServletInfo() {
		return null;
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public void destroy() {
		
	}

	
}

package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {

	//初始化,启动Tomcat时候就执行该方法
	public void init(FilterConfig config) throws ServletException {
		System.out.println("初始化操作1");
	}

	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("执行拦截前1");
		chain.doFilter(req, rep);//放行
		System.out.println("执行拦截后1");
	}
	public void destroy() {
	}
}

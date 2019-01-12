package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginFilter implements Filter {

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//System.out.println("当前请求资源名称:" + req.getRequestURI());
		String requestUrl = req.getRequestURI();
		//如果请求资源是login.jsp或者login直接放行
		//如果不进行判别会进入重定向的死循环中
		if(!"/login.jsp".equals(requestUrl) && !"/login".equals(requestUrl)) {
			Object username = req.getSession().getAttribute("USER_IN_SESSION");
			if(username == null) {
				resp.sendRedirect("/login.jsp");
				return;
			}
		}
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

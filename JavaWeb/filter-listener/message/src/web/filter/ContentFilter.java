package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class ContentFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 把请求对象进行包装,使得请求对象就要过滤敏感字的功能
		HttpServletRequest requestWapper = new MessageRequestWapper(req);
		// 此时的requestWapper对象就是servlet 调用req.getParameter获取的对象
		chain.doFilter(requestWapper, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}

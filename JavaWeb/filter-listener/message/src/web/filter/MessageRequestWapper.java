package web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import util.FilterUtil;

//请求的包装类
public class MessageRequestWapper extends HttpServletRequestWrapper {

	public MessageRequestWapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		if ("title".equals(name) || "content".equals(name)) {
			return FilterUtil.filter(super.getParameter(name));
		}
		return super.getParameter(name);
	}
}

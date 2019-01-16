package core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//封装请求和响应对象
public class ActionContext {
	private HttpServletRequest request;
	private HttpServletResponse response;

	// private static ActionContext context;//线程不安全
	private static ThreadLocal<ActionContext> local = new ThreadLocal<>();// 为每一个线程都分配一个ActionContext对象的副本

	public static ActionContext getContext() {
		return local.get();
	}

	public static void setContext(ActionContext context) {
		local.set(context);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public ActionContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
}

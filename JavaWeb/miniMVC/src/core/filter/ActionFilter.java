package core.filter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import core.ActionConfig;
import core.ActionContext;
import core.ResultConfig;

//前端控制器
public class ActionFilter implements Filter {

	// key--action元素的name value--action元素封装的对象ActionConfig
	private Map<String, ActionConfig> actionConfigMap = new HashMap<>();
	// key--result元素的name value--action元素封装的对象ResultConfig
	private Map<String, ResultConfig> resultConfigMap = new HashMap<>();

	public void init(FilterConfig config) throws ServletException {
		Document doc = this.getDocument();
		NodeList nodeList = doc.getElementsByTagName("action");
		for (int i = 0; i < nodeList.getLength(); i++) {
			/**
			 * 获取action.xml文件中的所有action元素,把每个元素封装成一个ActionConfig对象
			 */
			Element actionElement = (Element) nodeList.item(i);
			String name = actionElement.getAttribute("name");
			String className = actionElement.getAttribute("class");
			String method = actionElement.getAttribute("method");
			ActionConfig actionConfig = new ActionConfig(name, className, method);
			actionConfigMap.put(name, actionConfig);
			// ----结果视图显示-----------
			/**
			 * 读取result元素中的属性值封装成ResultConfig对象
			 */
			NodeList resultList = actionElement.getElementsByTagName("result");
			for (int j = 0; j < resultList.getLength(); j++) {
				Element resultElement = (Element) resultList.item(j);
				String name2 = resultElement.getAttribute("name");
				String type = resultElement.getAttribute("type");
				String path = resultElement.getTextContent();// 获取文本内容
				ResultConfig resultConfig = new ResultConfig(name2, type, path);
				resultConfigMap.put(name2, resultConfig);
			}
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String requestUri = req.getRequestURI().substring(1);// 得到当前请求的资源名称
		// -----把请求和响应对象封装成对象-------
		ActionContext ctx = new ActionContext(req, resp);
		ActionContext.setContext(ctx);// 把封装成的对象设置给ActionContext的静态成员变量.在action类中可以获取到
		// -----------
		ActionConfig actionConfig = actionConfigMap.get(requestUri);
		if (actionConfig == null) {// 没有配置该资源,直接放行
			chain.doFilter(req, resp);
			return;
		}
		String className = actionConfig.getClassName();
		String methods = actionConfig.getMethod();
		try {
			Class<?> actionClass = Class.forName(className);
			Object actionObject = actionClass.newInstance();// 用反射创建对象，保证存在 公共无参数构造器
			Method method = actionClass.getMethod(methods);// 获取方法
			Object obj = method.invoke(actionObject);// 执行方法
			if (obj != null) {// 方法要有返回值
				String viewName = obj.toString();
				ResultConfig resultConfig = resultConfigMap.get(viewName);

				if (resultConfig != null) {// 方法返回值必须在xml文件中配置，才可以找到
					String type = resultConfig.getType();// 页面跳转方式
					String path = resultConfig.getPath();// 跳转到的资源名的路径

					if ("dispatcher".equals(type)) {
						resp.sendRedirect(req.getContextPath() + path);
					} else if ("redirect".equals(type)) {
						req.getRequestDispatcher(path).forward(req, resp);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//获取xml文档对象
	private Document getDocument() {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("actions.xml");
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void destroy() {

	}

}

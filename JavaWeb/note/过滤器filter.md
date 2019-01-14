## 一、过滤器概述

过滤器处在客户端和服务端资源之间，可以对请求或者响应做拦截操作

Filter以常规的方式调用资源，可以修改请求信息调用资源，在对客户端响应之前对响应做修改，更可以阻止当前资源的调用转向其他资源.

#### 1.Filter的使用

- 定义一个类实现于javax.servlet.Filter接口，有三个方法分别是init,doFilter,destroy
- 在init中写获取初始化参数的代码，在doFilter中写需要处理请求和响应信息
- 配置filter，一种是web.xml文件中，另一种是注解@WebFilter("/过滤的资源名");

#### 2.**Filter在web.xml文件中的配置:**

```xml
  <filter>
   		<!-- 别名 -->
   		<filter-name>FilterDemo1</filter-name>
   		<!-- Filter的全限定名称 -->
   		<filter-class>filter.FilterDemo1</filter-class>
   </filter>
  <filter-mapping>
   		<filter-name>FilterDemo1</filter-name>
   		<!-- Filter需要过滤资源的名称  可以是jsp,也可以是servlet -->
   		<url-pattern>/*</url-pattern>
   </filter-mapping>
```

#### 3.**FilterChain过滤器链:**

当程序中存在多个多个过滤器的时候，过滤器执行的先后顺序由配置的web.xml文件中<filter-mapping>配置的先后顺序来决定的。

## 二、过滤器Filter的应用

### 1.请求编码过滤器

在未使用过滤器之前，每个servlet程序中的第一行的必须设置请求编码代码req.setCharacterEncoding(“UTF-8”);避免中文乱码。代码有重复，并且设置请求编码本身不应该是servlet该做的事情.所以我们可以把设置请求编码的代码放在过滤器中，由于每一个请求都必须经过Filter所以，在Filter在做了设置编码的操作后，请求已经发生了改变，在servlet中不在需要设置编码了.

```java
public class CharacterEncodingFilter implements Filter {

	private String encoding;
	private Boolean forceEncoding = false;//强制使用设置编码
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		forceEncoding = Boolean.valueOf(config.getInitParameter("force"));
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//把请求和响应强制转化为HTTP协议
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//1.当前应用没有编码,自己可以设置编码
		//2.当前应用中存在编码. 看是否想要强制设置编码
		if(hasLength(encoding) && (req.getCharacterEncoding() == null || forceEncoding)) {
			//设置请求编码
			req.setCharacterEncoding(encoding);
		}
		
		chain.doFilter(req, resp);//放行操作
	}
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
	public void destroy() {
	}
}
```

### 2.登录检查过滤器

在web上的登录操作，浏览器向服务器会发出一个请求，在servlet中会获取请求参数，把参数信息放在session中，然后调用业务方法处理请求，接着就是控制界面的跳转到其他页面。在其他页面之前必须先检测是否session中是否存在登录信息，如果存在正常访问，相反说明用户并没有登录直接访问了，这样会直接重定向到登录页面。这种情况下每一个访问的资源都要判断session中是否存在登录信息，如：

```jsp
<%	
	Object username = session.getAttribute("USER_IN_SESSION");
	if(username == null){
		response.sendRedirect("/login.jsp");
	}
%>
```

代码重复很多，当然可以把这些也放在Filter中。

这里需要注意的问题是，对一些资源不需要过滤操作，防止产生重定向的死循环

```java
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
```

在servlet中需要把登录信息设置在session作用域中

```java
req.getSession().setAttribute("USER_IN_SESSION", username);
```

### 3.敏感字过滤器

过滤掉请求中不和谐的信息，浏览器发生请求先经过Filter,此时的请求request对象没有过滤敏感字的功能,对这个请求对象进行包装，让其具有过滤敏感字的能力，在servlet获取请求参数的request对象也就具有了过滤敏感字的能力，用覆盖父类getParameter()方法来完成。

```java
//请求的包装类
public class MessageRequestWapper extends HttpServletRequestWrapper {

	public MessageRequestWapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		if ("title".equals(name) || "content".equals(name)) {
			return FilterUtil.filter(super.getParameter(name));//返回经过过滤的请求参数
		}
		return super.getParameter(name);
	}
}
```

在Filter中

```java
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;
    // 把请求对象进行包装,使得请求对象就要过滤敏感字的功能
    HttpServletRequest requestWapper = new MessageRequestWapper(req);
    // 此时的requestWapper对象就是servlet 调用req.getParameter获取的对象
    chain.doFilter(requestWapper, resp);
}
```


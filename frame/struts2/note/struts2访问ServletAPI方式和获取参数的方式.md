### 一、访问ServletAPI的三种方式

#### 方式1:通过让Action类去实现感知接口.
此时项目依赖:`servlet-api.jar`.

- ServletRequestAware：感知HttpServletRequest对象；
- ServletResponseAware：感知HttpServletResponse对象；
- ServletSessionAware：感知HttpSession对象；

```java
public class ServletApiAction1 extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
 	@Override
	public String execute() throws Exception {
 		//获取请求参数
		System.out.println("HHH" + request.getParameter("name"));
		return SUCCESS;
	}
	//注意这里依赖于servlet-api.jar
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}
}
```

#### 方式二：使用ServletActionContext类,该类提供很多静态方法可以返回Servlet API对象

```java
public class ServletApiAction2 extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
        //获取请求参数
		System.out.println("objk" + ServletActionContext.getRequest().getParameter("name"));
		//通过请求得到session对象
        ServletActionContext.getRequest().getSession().setAttribute("sessionKey", "我是session");
        //得到响应对象
		ServletActionContext.getResponse().sendRedirect("/view/welcome.jsp");
		return NONE;
	}
}
```

#### 方式3.使用ActionContext类,本身是Struts2对Servlet API的封装

ActionContext使用了ThreadLocal模式,所以说是线程安全的

实际得到的都是map可以直接向map中添加数据或者获取数据

```java
public class ServletApiAction3 extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		//获取请求参数
		Map<String, Object> parameters = ActionContext.getContext().getParameters();
		System.out.println(parameters);
		
		//request作用域
		ActionContext.getContext().put("requestName", "requestValue");
		//Session作用域
		ActionContext.getContext().getSession().put("sessionName", "sessionValue");
		//application作用域
		ActionContext.getContext().getApplication().put("applicationName", "applicationValue");
		return SUCCESS;
	}
}
```

### 二、获取请求参数的三种方式

#### 方式一：第一种:Action本身作为Model对象，通过setter方法封装(属性注入)

对属性提供setter方法，拦截器会自动给调用方法把参数设置给属性

```java
public class LoginAction1 extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		System.out.println(username + "," + password);
		return NONE;
	}
}
```

#### 方式二：创建独立Model对象，页面通过ognl表达式封装(属性注入)

把请求参数先封装成一个对象,例如把username 和password封装成了User对象

```java
public class LoginAction2 extends ActionSupport {
	private static final long serialVersionUID = 1L;
    
	private User user;
	/**
	 *	jsp中的 user.username 用action对象调用getUser()得到user对象然后给属性设置值
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}
```

此时jsp界面这样写

```jsp
	<h3>登录页面  方式二</h3>
	<form action="/params/login2" method="post"> 
		账号 <input type="text" name="user.username"/><br/>		
		密码<input type="text" name="user.password"/><br/>
		<input type="submit" value=" 登录 ">
	</form>
```

#### 方式三：使用ModelDriven接口，对请求数据进行封装(模型驱动)

```java
public class LoginAction3 extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;

    //必须自己创建对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}
```


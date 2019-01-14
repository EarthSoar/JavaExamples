## 一、Servlet的请求流程

web项目中的web.xml文件配置为：

```xml
<servlet>
    <!--别名-->
    <servlet-name>Hello</servlet-name>
    <!--类的全限定名-->
    <servlet-class>hello.HelloServlet</servlet-class>
</servlet>
<!-- 向外暴露一个资源名称，供外界访问，资源名称前面必须有  / -->
<servlet-mapping>
    <servlet-name>Hello</servlet-name>	
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

- 1、**第一次**在浏览器地址栏输入http://localhost:80/test/hello  后回车**(第一次请求)**

- 2、此时servlet会解析这个请求信息，首先前面的localhost:80一般是域名信息，一般会交给DNS解析成ip，80是http协议的默认端口.这里主要讨论后面的一部分,test/hello

- 3、服务器会tomcat目录里的conf目录下寻找service.xml文件，在所有Context元素中寻找path内容为这里的test的，可以找到这个元素中属性docBase的内容，根据docBase中的路径找到这个web项目的根路径

- 4、在项目的根路径下寻找web.xml文件，也就是上面的文件，在这个文件中寻找url-patternd内容为hello的元素，如果没有就会报404错误，说明资源不存在。如果有，找到和他在一个元素中的servlet-name，根据这个名字它会去寻找上面servlet元素中的和它同名元素，最终找到servlet-class中的类的全限定名称。

- 5、利用反射去调用Serlvet类中的构造器从而创建对象(显然构造器必须是public的)。

  Servlet ser = ClassforName("hello.HelloServlet");

- 6、调用init方法，ser.init(ServletConfig config);

- 7、调用service方法 ser.service(...);

- 8、对浏览器做出响应，以html等形式

- 9、正常终止服务器，会执行destroy()  但是如果非正常终止并不会执行此方法。

**如果是非第一次请求，不会在第5步创建对象了，而是直接从servlet的实例缓冲池中直接获取对象。接着执行后续操作。**

注意：servlet的创建，初始化，运行和销毁等操作都是有服务器来负责调用的。

javax.servlet.Servlet接口中有四个方法：

```java
public void init(ServletConfig config) throws ServletException {
	//执行servlet的初始化操作
}

public ServletConfig getServletConfig() {
    //获取Servlet的配置信息对象
    return null;
}

public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    //服务，具体操作的方法
}

public String getServletInfo() {
    //获取servlet的信息，作者，版权
    return null;
}

public void destroy() {
    //销毁对象
}
```

### 二、Servlet的初始化参数

在web.xml文件中的Servlet元素下可以添加初始化参数<init-param>：

```xml
<servlet>
    <!--别名-->
    <servlet-name>Hello</servlet-name>
    <!--类的全限定名-->
    <servlet-class>hello.HelloServlet</servlet-class>
    <init-param>
        <param-name>name</param-name>
        <param-value>Willing</param-value>
	</init-param>
</servlet>
```

获取初始化参数就要用到ServletConfig接口中的方法

```java
String name =  config.getInitParameter("name");//根据参数名获取参数值
Enumeration<String> en = config.getInitParameterNames();//获取所有的参数名，返回一个迭代器
```

因为它们并不是static方法，所有要用ServletConfig的对象去调用，实际上对象服务器已经帮我们创建好了，在init方法init(ServletConfig config)的参数中，我们只需拿来用。方便起见可定义为成员变量.

```java
ServletConfig config;//把config对象定义为成员变量
@Override  
public void init(ServletConfig config) throws ServletException {
    this.config = config;
}
```

### 三、Servlet的继承体系

每次写一个servlet都得实现javax.servlet.Servlet肯定很痛苦。所有就有专门的来已经实现好了，自己只需要继承就行了。servlet的继承体系

![img](https://img2018.cnblogs.com/blog/1296856/201811/1296856-20181122213150173-1448869728.png) 

我们只要继承HttpServlet，

```java
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		//自己的初始化操作
	}

	//编写Servlet方式一
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编写处理请求的代码
		//不能调用父类中 的service  :  super.service();
	}
	//编写Servlet方式二
	//处理POST请求
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	//处理GET请求
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理全部的请求
	}
}
```

### 四、HttpSevletRequst的常用方法

HttpServletRequst是ServletRequest的子接口，封装了处理http协议请求的方法

```java
String getMethod();//返回请求方式GET 或 POST
String getRequestURI();//返回请求行中的资源名称
StringBuffer getRequestURL();//返回浏览器中地址栏中的信息
String getContextPath();  //返回上下文路径path属性值
String getHeader(String name) //返回请求头信息
String getParameter(String name);//返回指定参数名的参数值(一般是表单用户输入)
String getParameterValues(String name);//返回指定名称的多个参数值
```

#### 请求乱码处理

请求默认是ISO-8859-1，不支持中文

- 方式一：解决中文乱码	
  - 1.按照ISO-8859-1把乱码恢复成二进制形式byte[] data = username.getBytes("ISO-8859-1");
  - 2.对二进制形式重新编码为UTF-8，username = new String(data,"UTF-8");
- 方式二(推荐)：可以调用req.setCharacterEncoding("UTF-8");//适用于POST方式
- 方式三：修改service.xml配置文件中修改端口的的元素<Connector/>,修改GET方式的默认编码： URIcoding = "UTF-8";//适用于GET方式

### 五、HttpServletResponse的常用方法

HttpServletResponse是ServletResponse的子接口，封装了处理http协议请求的方法

```java
ServletOutputStream getOutputStream();//返回字节输出流对象
PrintWriter getWriter() //返回一个打印流对象，这是父接口HttpResponse中的方法
void addCookie(Cookie cookie)//把cookie对象响应给浏览器  
```

**注意：**这里字节输出流不能和字符输出流共存。

#### 响应乱码处理

```java
/**
* 解决输出中文乱码问题
*/
resp.setCharacterEncoding("UTF-8");
//设置输出的MIME类型,设置为html
resp.setContentType("text/html");

//上面两行代码也可以合并在一起写成：
//resp.setContentType("text/html;charset=utf-8");
```
```java
/**
* 获取字节输出流对象，不能与字节输出流共存
*/
//OutputStream out = resp.getOutputStream();
//out.write("Hello".getBytes());

/**
* 获取符输出流对象
*/
PrintWriter p = resp.getWriter();
p.println("你好");//这里的换行并不作用，在网页中是以html形式显示的，换行用br标签
p.print("Hello");
```
### 六、注解配置Servlet

JavaEE6(Servlet3)	可以用注解配置，代替了web.xml文件

```java
/**
 * value属性是一个数组，所有可以传多个，因为url-pattern也可以有多个值
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
```


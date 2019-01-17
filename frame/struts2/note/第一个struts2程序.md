### 一、Struts2的HelloWorld程序

 - 拷贝/apps/struts2-blank/WEB-INF/lib 中的jar包到项目的lib目录

 - 在web.xml文件中配置Struts2的前端控制器

   ```xml
   <filter>
     	<filter-name>StrutsPrepareAndExecuteFilter</filter-name>
     	<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
     </filter>
     <filter-mapping>
     	<filter-name>StrutsPrepareAndExecuteFilter</filter-name>
     	<url-pattern>/*</url-pattern>
     </filter-mapping>
   ```

 - 把struts.xml文件拷贝到source-folder目录

 - 定义一个POJO类，提供公共无参数的方法

 - 在struts.xml文件中配置action

 - 访问Action.格式:http://ip:port/contextPath/namespaceName/actionName[.action]

### 二、struts.xml文件的配置

```xml
<struts>
	<!-- 常量配置,修改default.properties资源文件的常量值 -->
	<constant name="struts.action.extension" value="action,wocao,"></constant>
	<!-- 开发者模式 -->
	<constant name="struts.devMode" value="true"></constant>
	<!-- 错误提示 -->
	<constant name="struts.configuration.xml.reload" value="true"></constant>
	<!-- 
		name:       表示<package>的名字,但是要保证不同的<package>元素的name不同. 可以通过该名字被其他的包所指代.
		extends:   表示当前<package>继承哪一个<package>,一般都是:struts-default. 
	           而struts-default其实就是struts-default.xml中<package>元素的名字.
	           继承struts-default之后,就拥有了该<package>定义的所有资源.(结果返回类型,拦截器..)
		namespace: 表示命名空间,一般的以"/"打头.,命名一般以模块名.如: /crm, /oa. 和<action>的name决定了一个Action类的访问路径.
		abstract:  抽象的,缺省值是false. 若一个<package>的abstract="true",那么该<package>中就不能再定义<action>元素,只能用来继承.
	 -->
	<package name="helloPkg" extends="struts-default" namespace="/crm">
	<!-- 
		class:一个Action类的全限定名.    缺省值:com.opensymphony.xwork2.ActionSupport类.
		method:当前Action动作访问的方法, 缺省值:execute.
	 -->
		<action name="hello" class="hello.HelloAction" method="execute">
	<!-- 
	局部结果视图：
		name:Action方法返回的逻辑视图名称. 缺省值:success.
		type:结果的跳转类型.该类型的值在struts-default.xml中已经预定义好了. 缺省值:dispatcher.
		常见的type值(结果类型):
		dispatcher:      表示从Action请求转发到页面(JSP).
		redirect:        表示从Action重定向到页面(JSP).
		chain:           表示从Action请求转发到另一个Action.
		redirectAction:  表示从Action重定向到另一个Action.
		stream:          表示返回流. 文件下载时使用.
		<param name="">表示参数:name缺省值:location(地址).
	 -->
			<result name="hi" type="dispatcher">
				<param name="location">/view/welcome.jsp</param>
			</result>
		</action>
	</package>
</struts>
```

### 三、Action类的编写方式

- 使用公共的POJO类作为Action. 提供公共的无参数的Action方法

  ```java
  public class Action1 {
  	public String execute() {
  		System.out.println("Hello");
  		return "success";
  	}
  }
  ```

- 实现com.opensymphony.xwork2.Action 接口 ,接口中有定义好的常量

  ```java
  public class Action2 implements com.opensymphony.xwork2.Action {
  	@Override
  	public String execute() throws Exception {
  		System.out.println("action2");
  		return SUCCESS;
  	}
  }
  ```

- **继承ActionSupport**(推荐)

  ```java
  public class Action3 extends ActionSupport{
  	private static final long serialVersionUID = 1L;
  	
  	@Override
  	public String execute() throws Exception {
  		System.out.println("action3");
  		return super.execute();
  	}
  }
  ```

### 四、Action多方法调用

**使用通配符的方式类配置**:`*`    通配符: {1}代表第一个* ，起着占位符作用

```xml
<struts>
    <package name="methodPkg" extends="struts-default" namespace="/">
            <!-- <action name="employee_*" class="more_method.EmployeeAction" method="{1}">		          </action> -->
            <action name="*_*" class="more_method.{1}Action" method="{2}"></action>
    </package>
</struts>
```

```java
	//Action多个方法
	public void save() {
		System.out.println("保存");
	}
	public void delete() {
		System.out.println("删除");
	}
	public void update() {
		System.out.println("更改");
	}
	public void list() {
		System.out.println("列表");
	}
```

浏览器请求:http://localhost/Employee_list,  进入list()方法
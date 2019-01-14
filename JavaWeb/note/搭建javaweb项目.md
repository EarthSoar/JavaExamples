## 一、安装配置Tomcat

### 1.下载

### 2.配置环境变量

配置JAVA_HOME环境变量,路径为JDK的根目录

### 3.测试Tomcat

![img](https://s1.ax1x.com/2018/11/19/FpEM8A.gif) 

打开浏览器，在地址栏输入http://localhost:8080可以访问，说明配置成功

### 4.Tomcat中的文件目录

- **bin：**存放启动和关闭Tomcat的工具
- **conf：**存放软件的配置文件
- **lib：**存放软件运行所依赖的jar包
- **logs**：存放 Tomcat日志信息
- **temp：**临时文件
- **webapps：**存放需要部署的项目
- **work：**工作目录，存放了jsp翻译成Servlet的java文件以及字节码文件。

### 5.Tomcat的使用

#### 5.1.修改Tomcat的默认端口

- 打开tomcat/conf/service.xml文件、

- 把默认端口8080修改端口port为80

  ![img](https://s1.ax1x.com/2018/11/19/FpVFiQ.png) 

- 重启Tomcat

#### 5.2.查看服务器状态

需要在Tomcat/conf/tomcat-users.xml添加

```xml
<role rolename="manager-gui"/>
<role rolename="admin-gui"/>
<user username="admin" password="123" roles="manager-gui,admin-gui"/>
```

在服务器配置成功页面可以查看当前系统的状态信息，用户名和密码需要在上述文件中如此配置

### 6.常见问题

- 还没启动Tomcat或者Tomcat启动失败,就去访问地址
- Tomcat还未关闭,又再次重新启动Tomcat
- 要保证XML内容编码和文件编码相同，一般把编码修改为utf-8

## 二、搭建JavaWeb项目

### 1.搭建javaweb项目的目录结构

![img](https://s1.ax1x.com/2018/11/19/FpEDK0.png) 

必须严格按照这个结构组成的，

### 2.eclipse下创建web项目

- 先创建一个java项目

- 在项目中创建一个文件夹(Folder)，这个目录为web项目的根目录，一般起名为webapp，当然名字无所谓。

- 在webapp中创建一个WEB-INF的目录，这个目录中的文件是由服务器负责调用的，外界无权访问。

- 在WEB-INF目录中创建一个classes目录和lib目录。

- 在WEB-INF目录中创建一个名为web.xml的文件。方便起见这个文件可以去Tomcat的WEB-INF目录下复制一个，并且把编码改为UTF-8。

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <web-app xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                        http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
    version="3.0"
    metadata-complete="true">
  </web-app>
  ```

  

- 把classes目录作为字节码的输出路径，默认是bin路径，改为这里的classes目录,此时classes目录会消失。

  ![img](https://s1.ax1x.com/2018/11/19/FpEtUg.gif) 

### 3.部署javaweb项目

部署项目有三种方法

#### 3.1 直接部署到Tomcat的webapps目录

访问：http://项目名/资源名

**缺点：**

- 不支持热部署，代码改变后需要重新部署。
- 后期项目越来越多，服务器启动变慢，维护起来很难。

#### 3.2 从service.xml文件中找到项目路径

- 打开Tomcat目录中的config目录下的service.xml文件
- 在Host元素里面添加一个子元素<Context doBase = ""  path = "" />
- Context表示的是上下文，也就是当前的项目环境，doBase为需要被部署的项目的根路径。path表示的是上下文路径

**注意：**多个Context元素的path属性值不能相同。

访问：http://ip:port/ContextPath/资源名称，例如：http://localhost:80/pss/index.html

#### 3.3 在Tomcat/conf/Catalina/localhost目录下创建xml文件

- 在在Tomcat/conf/Catalina/localhost目录下创建一个xml文件，这个xml文件的名称相当于是上面方法的path，比如abc.xml
- 文件内容为：<Context doBase = "" />，与上面方法相比就少了path，path其实是文件名，这两种方法本质是相同的

访问：http://ip:port/文件名/资源名称，例如http://localhost:8080/abc/index.html








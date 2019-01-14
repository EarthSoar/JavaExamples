## 一、HTTP协议的无状态性

WEB应用程序使用的是HTTP协议传输数据的，HTTP协议是一个无状态的协议，这次数据传输完毕，客户端会和服务端断开连接，再次传输数据就需要重新建立新的连接，这也就无法会话跟踪。可以理解为服务器是一个健忘症，这次你访问他和它交换数据，下次来他就不认识你了，这是一个很不友好的事情。这个问题有一个很直接的方法解决它，就是服务器你认识你，你每次都告诉它你的名字，也就是每次客户端访问的时候都需要带上自己的参数,可以采用GET请求每次带上自己的参数，但是这肯定是不可取的，应为GET请求会把参数信息放在浏览器的地址栏中，信息都暴露了，完全保证不了安全性。为了解决HTTP协议这个健忘症患者，cookie和session技术登上了历史舞台。

## 二、Cookie

既然每次GET请求的时候把数据带上保证安全的，cookie技术把数据放在请求头中了，这样就安全一点了吧。其实也不怎么安全..后面说。cookie技术是一种客户端技术，首先程序给客户端以cookie的形式把数据存放在了浏览器中，这样浏览器再次去请求的时候会带上这个数据，这样浏览器就认识这个请求了。访问过程就是客户端第一次访问服务器的时候浏览器会在响应头中加上`Set-Cookie`信息，当跳转到另外一个资源的时候也就是再次发送一个请求的时候，请求会在请求头上带上`Cookie:xxx`,也就是前面自己的数据，目的是让服务器认识自己。

### 1.cookie的操作

- 创建cookie对象并添加到响应中

  ```java
  Cookie cookie = new Cookie(String name,String value);
  response.addCookie(cookie);
  ```

- 从请求中获取cookie中的数据

  ```java
  Cookie[] cs = request.getCookies();//可以对cs，for-each迭代出每一个cookie对象
  String cookieName = cookie.getName();
  String value = cookie.getValue();
  ```

- 让cookie属性支持中文

  ```java
  Cookie cookie = new Cookie("cookieName",URLEncoder.encode(username,UTF-8));//创建cookie对象对属性的编码
  String value = URLDecoder.decode(cookie.getValue(),"UTF-8");//获取cookie中的数据对属性的解码
  ```

- 修改cookie中的属性

  ```java
  //方法1：设置相同名称的key,覆盖上一个，还要把获取的cookie对象添加到响应中去
  Cookie c2 = new Cookie("currentName","HHH");
  resp.addCookie(c2);
  //方法2：调用setValue();  此时还需要把对象重新加入到响应中
  c.setValue("HHH");
  resp.addCookie(c);
  ```

- 设置cookie的存活时间

  ```java
  c.setMaxAge(-1); // 设置负数表示-会话cookie,缺省.  浏览器关闭cookie也就消失
  c.setMaxAge(0); // 删除cookie
  c.setMaxAge(10); //持久化cookie，设置cookie可以存活的时间是10s
  ```

- 设置cookie的path

  ```java
  /**
   * 设置cookie的path为"/"，设置整个根路径都可以共享这个cookie,
   * 默认情况是最后一个 / ，  例如/cookie/login,只会对cookie/list共享并不会对 /xx/list共享,也就是只共享给以/cookie开始资源
   */
  c.setPath("/");
  ```

### 2.Cookie的缺点

虽然cookie把数据放在了请求头中，但是还是把数据存放在了浏览器中，浏览器都有一个可以查看cookie的选项，显然是有些不安全。另外浏览器和服务器一般会对cookie的大小做限制，还有写中文每次编码解码很麻烦。

## 三、Session

Cookie技术是把数据存放在了客户端浏览器中，与之相反，Session是把数据存放在了服务器中。session中文意思是会话，服务器为每一次会话创建了一块内存区域来存在数据，第一次请求服务器把数据存放在了服务器中，服务器给客户端响应一个编号，下次再来请求的时候拿着这个编号在服务器的内存空间中可以找到自己的数据。与cookie不同的是，session存放数据的时候是以key-value形式存放，这里的value是Object类型的，而cookie是String类型的。

浏览器第一次请求服务器，服务器会创建cookie对象并且把数据按照key-value的形式起来，然后在响应头中加上`Set-Cookie:xxx`（这里的xxx其实就是id,好让下一次在可以在服务器中找到）,下一次访问的时候，会在请求头中加上`Cookie:xxx`。其实可以看出，session本质上也是cookie。

**需要注意的是：**session会在回话结束后消失，也就是关闭浏览器或者关闭服务器session会失效。

### 1.Session的操作

- 创建和获取session对象

  第一次请求会创建对象，当再次请求当然就不会再创建了，除非当前会话结束。

  ```java
  HttpSession session = req.getSession();
  HttpSession session = getSession(boolean create);  
  / * true(缺省) ： 若当前请求中存在session对象，就直接返回，如果不存在就创建一个再返回
   * false:  若当前请求中存在session对象，就直接返回，如果不存在返回null;
   */
  ```

- 在session中存储数据

  ```java
  session.setAttribute(String key,Object value);//key的命名一般为大写
  ```

- 取数据

  ```java
  Object value = session.getAttribute(String key);//根据key，去取value
  ```

- 删除session

  ```java
   session.removeAttribute(String key);//可以根据key去删除
   session.invalidate();//销毁session对象
  ```

- 超时机制

  ```java
  //一段时间内浏览器与服务器没有交互会自动销毁session对象
  session.setMaxInactiveInterval(30);//30s
  ```

### 2.session的缺点

session会在一定时间内保存在服务器上。当访问增多，会比较占用服务器的性能。 
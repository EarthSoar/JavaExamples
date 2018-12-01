<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	//四大作用域
		pageContext.setAttribute("name","pageContext"); 
		request.setAttribute("name","Request");
		session.setAttribute("name","Session");
		application.setAttribute("name", "application");
	%>
	<h3>最low获取作用域的属性值</h3>
	pageContext:<%=pageContext.getAttribute("name") %>  </br>
	request:<%=request.getAttribute("name") %>  </br>
	session:<%=session.getAttribute("name") %>  </br>
	application:<%=application.getAttribute("name") %>  </br>
	<h3>用pageContext的findAttribute()方法获取属性值</h3>
	<%--
		用这个方法查找属性名是有顺序的,   pageContext,request,session,application
		判断返回的属性是否为NULL,如果为null返回一个空字符串,不为null直接返回
	 --%>
	<%=pageContext.findAttribute("name")==null?"" : pageContext.findAttribute("name") %>
	<h3>用el表达式获取属性值</h3>
	<%--
		从作用域中查找属性名是有顺序的,   pageContext,request,session,application
	 --%>
	${name}
	
	<h3>使用el获取不同作用域的属性值</h3>
	pageContext:${pageScope.name}</br>
	request:${requestScope.name}</br>
	session:${sessionScope.name}</br>
	application:${applicationScope.name}</br>
	
	<h3>获取对象的属性</h3>
	<%--
		1.把对象添加到作用域中
			pageContext().setAttribute("name",对象);
		2.获取对象的属性     (javabean的属性名)
			${p.属性名}  或者   ${p["属性名"]}
	--%>
	
	<h3>el获取上下文 属性</h3>
	${pageContext.request.contextPath}
	${pageContext.getRequest().getContextPath()}
	
	${1==1}
	可以判断集合是否为空
	//${empty list}
</body>
</html>
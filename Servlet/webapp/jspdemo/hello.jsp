<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    
    	jsp中的pag指令
    		语法：<% @  指令  属性名 = "属性值"  %>
    	属性：
    		language:表示当前jsp页面编写的脚本语言	
    		contentType:表示当前jsp页面输出的MIME类型和编码格式   翻译到Servlet代码中 就是：
    												response.setContentType("text/html; charset=UTF-8");
    												
    		pageEncoding:表示的还是jsp的编码.  当pagePage属性和contentType同时出现时 以contentType中的编码为准
    		
    		errorPage:  当前jsp代码出现错误会跳转到那个页面,  属性值是需要跳转到的资源路径
    		isErrorPage: 标注当前页面是不是处理错误的页面, 默认为false表示不是错误页面
    		session: 标注当前页面是是作用于一次回话当中,默认为true
    		import: 导入jsp中包含的java代码所依赖的类,相当于java中的import语句
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int a = 1/0;
	%>
	<%--输出表达式的值,调用out.print()方法将参数值输出在浏览器中 --%>
	北京时间：<%=new java.util.Date().toLocaleString() %>
	
	<%--在这里书写java代码,  服务器把里面的代码原封不动的拷贝到_jspService方法中 --%>
	<%
		String name = "Willing";
	%>
	
	<%--声明成员变量或者方法 --%>
	<%!
		private String name;
		private void doWork(){}
	%>
	
	<%--在jsp中写一个if-else条件的java代码 --%> 
	
	<%
		int num = 20;
		if(num < 10){
	%>
	小于10
	<%
		}
		else{
	%>
	大于10
	<%
		}
	%>
	
	
</body>
</html>
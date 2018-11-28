<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 动态包含
		在运行时期才把所包含的文件合并起来,
		动态包含可以传递数据,   静态包含不能
	 --%>
	<jsp:include page="top.jsp">
		<jsp:param value="" name=""/>
	</jsp:include>    </br>
	中间代码      </br>
	<jsp:include page="foot.jsp"></jsp:include>    </br> 
	
	<%--静态包含 
		在翻译成java代码时期就已经将包含的资源合并起来了
	--%>
<%-- 	<%@include file="top.jsp" %>  </br>
	中间代码						</br>
	<%@include file="foot.jsp" %>   --%>
</body>  
</html>
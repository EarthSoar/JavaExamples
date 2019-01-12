<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	Object username = session.getAttribute("USER_IN_SESSION");
	if(username == null){
		response.sendRedirect("/login.jsp");
	}
%> --%>
${USER_IN_SESSION}
	欢迎光临
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%--引入标签库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% pageContext.setAttribute("num",20); %>
	
	<%--单条件判断 --%>
	<c:if test="${num>20}">
		大于20
	</c:if>
	
	<c:if test="${num>20}" var="result" scope="page"/>
	${result}
	
	<%--多条件判断 --%>
	<c:choose>
		<c:when test="${num>20}">大于</c:when>
		<c:when test="${num<20}">小于</c:when>
		<c:otherwise>等于</c:otherwise>
	</c:choose>
	
	<%--for-each迭代   可以对集合迭代--%>
	<c:forEach begin="1" end="20" step="1" var="num">
	 ${num}
	</c:forEach>

	<%
		pageContext.setAttribute("list",java.util.Arrays.asList("A","B","C"));
	%>
	<c:forEach items="${list}" var="ele">
		${ele}
	</c:forEach>	
</body>
</html>
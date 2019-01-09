<%--
  Created by IntelliJ IDEA.
  User: Willing
  Date: 2019/1/8
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/product?cmd=save" method="POST">
        <input type="hidden" name="id" value="${pro.id}"/>
        名&nbsp;&nbsp;&nbsp;称:<input type="text" name="productName" value="${pro.productName}"/><br/>
        分&nbsp;&nbsp;&nbsp;类:
        <select name="dir_id">
            <c:forEach items="${dirs}" var="dir">
                <option value="${dir.id}"  ${dir.id == pro.dir_id ? "selected":""}>${dir.dirName}</option>
            </c:forEach>
        </select>		<br/>
        零售价: <input type="number" name="salePrice" value="${pro.salePrice}"><br/>
        供应商:<input type="text" name="supplier" value="${pro.supplier}"/><br/>
        制造商:<input type="text" name="brand" value="${pro.brand}" /><br/>
        折&nbsp;&nbsp;&nbsp;扣:<input type="text" name="cutoff" value="${pro.cutoff}"/><br/>
        成本价:<input type="number" name="costPrice" value="${pro.costPrice}"/><br/>
        <input type="submit" value='${pro == null ? "保存信息" : "修改信息"}' />
    </form>
</body>
</html>

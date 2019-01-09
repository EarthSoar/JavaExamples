<%--
  Created by IntelliJ IDEA.
  User: Willing
  Date: 2019/1/8
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        <%--把当前页数传进来赋值给currentPage,然后用js提交表单--%>
        function go(pageNum) {
            document.getElementById("currentPage").value = pageNum;
            document.forms[0].submit();
        }
    </script>
</head>
<body>
    <form action="/product" method="post">
        名称 <input type="text" name="productName" value="${qo.productName}">
        价格 <input type="number" name="minSalePrice" value="${qo.minSalePrice}"> --
        <input type="number" name="maxSalePrice" value="${qo.maxSalePrice}">
        商品分类
        <select name="dirId">
            <option value="-1">所有商品</option>
            <c:forEach items="${dirs}" var="dir">
                <option value="${dir.id}"  ${qo.dirId ==dir.id ? "selected":""}>${dir.dirName}</option>
            </c:forEach>
        </select>
        <input type="submit" value="查询"/>

    <%--关键字--%>
    <%--<input type="text" name="keyword" value="" placeholder="商品名称/供应商"/>--%>
        <br/> <br/><a href="/product?cmd=edit">添加</a>
<table border="1" width="80%" cellpadding="0" cellspacing="0" >
    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>分类编号</th>
        <th>零售价</th>
        <th>供应商</th>
        <th>制造商</th>
        <th>折扣</th>
        <th>成本价</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageResult.listData}" var="pro" varStatus="vs">
        <tr style="background-color: ${vs.count % 2 == 0 ? 'gray':'' }">
            <td align="center">${pro.id}</td>
            <td align="center">${pro.productName}</td>
            <td align="center">
                <c:choose>
                    <c:when test="${pro.dir_id == 1}">鼠标</c:when>
                    <c:when test="${pro.dir_id == 2}">无线鼠标</c:when>
                    <c:when test="${pro.dir_id == 3}">有线鼠标</c:when>
                    <c:when test="${pro.dir_id == 4}">游戏鼠标</c:when>
                </c:choose>
            </td>
            <td align="center">${pro.salePrice}</td>
            <td align="center">${pro.supplier}</td>
            <td align="center">${pro.brand}</td>
            <td align="center">${pro.cutoff}</td>
            <td align="center">${pro.costPrice}</td>
            <td align="center">
                <a href="/product?cmd=delete&id=${pro.id}">删除</a>
                <a href="/product?cmd=edit&id=${pro.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>

    <tr align="center">
        <td colspan="8">
            <a href="javascript:go(1)">首页</a>
            <a href="javascript:go(${pageResult.prevPage})">上一页</a>
            <c:forEach begin="${pageResult.beginIndex}" end="${pageResult.endIndex}" var="pageNumber" >
                <c:if test="${pageNumber == pageResult.currentPage}">
                    <span>${pageNumber}</span>
                </c:if>
                <c:if test="${pageNumber != pageResult.currentPage}">
                    <a href="javascript:go(${pageNumber})">${pageNumber}</a>
                </c:if>
            </c:forEach>
            <a href="javascript:go(${pageResult.nextPage})">下一页</a>
            <a href="javascript:go(${pageResult.totalPage})">末页</a>
            共${pageResult.totalCount}条数据||当前第${pageResult.currentPage}/${pageResult.totalPage}页
            ||
            每页显示<select name="pageSize" onchange="go()">
                    <c:forEach items="${pageResult.pageItems}" var="item">
                        <option ${item == pageResult.pageSize ? "selected":""}>${item}</option>
                    </c:forEach>
                </select>
            ||
            跳转到<input type="number" name="currentPage" id="currentPage" value="${pageResult.currentPage}" min="1" max="${pageResult.totalPage}">
            页
            <input type="submit" value="GO">
        </td>
    </tr>
    </form>
</table>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>
	<a href="/product?cmd=edit">添加</a>
	<table border="1" width="80%" cellpadding="0" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>名称</th>
			<th>分类编号</th>
			<th>零售价</th>
			<th>供应商</th>
			<th>制造商</th>
			<th>折扣</th>
			<th>成本价</th>
		</tr>
		<c:forEach items="${pageResult.listData}" var="p" varStatus="vs">
			<tr style="background-color: ${vs.count % 2 == 0 ? 'gray':'' }">
				<td>${p.id}</td>
				<td>${p.productName}</td>
				<td>${p.dir_id}</td>
				<td>${p.salePrice}</td>
				<td>${p.brand}</td>
				<td>${p.supplier}</td>
				<td>${p.cutoff}</td>
				<td>${p.costPrice}</td>
			</tr>
		</c:forEach>
		<%-- <tr align="center">
			<td colspan="8">
				<a href="/product?cmd='list'&& currentPage=1">首页</a>
				<a href="/product?cmd='list'&&currentPage=${pageResult.prevPage}">上一页</a>
				<c:forEach begin="${pageResult.beginIndex}" end="${pageResult.endIndex}" var="pageNumber" >
					<c:if test="${pageNumber == pageResult.currentPage}">
						<span>${pageNumber}</span>
					</c:if>
					<c:if test="${pageNumber != pageResult.currentPage}">
						<a href="/product?cmd='list'&&currentPage=${pageNumber}">${pageNumber}</a>
					</c:if>
				</c:forEach>
				<a href="/product?cmd='list'&&currentPage=${pageResult.nextPage}">下一页</a>
				<a href="/product?cmd='list'&&currentPage=${pageResult.totalPage}">末页</a>
				共${pageResult.totalCount}条数据,当前第${pageResult.currentPage}/${pageResult.totalPage}页
				<form action="/product?cmd='list'&&currentPage=${pageResult.currentPage}" method="POST">
					每页显示<input type="number" name="count"/>
					<input type="submit" value="Go"/>条数据
				</form>
			</td>
		</tr> --%>
	</table>
	<div align="center">
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<li ${pageResult.currentPage == 1 ? "class='disabled'" : ""}>
					<a href="/product?cmd='list'&&currentPage=1" aria-label="Previous"> <span
						aria-hidden="true">首页</span>
					</a>
				</li>
				<li ${pageResult.currentPage == 1 ? "class='disabled'" : ""}>
					<a href="/product?cmd='list'&&currentPage=${pageResult.prevPage}" aria-label="Previous"> <span
						aria-hidden="true">上一页</span>
					</a>
				</li>
				<c:forEach begin="${pageResult.beginIndex}" end="${pageResult.endIndex}" var="pageNumber">
					<li ${pageResult.currentPage == pageNumber ? "class='active'" :""}><a href="/product?cmd='list'&&currentPage=${pageNumber}">${pageNumber}</a></li>
				</c:forEach>
				<li ${pageResult.currentPage == pageResult.totalPage ? "class='disabled'" : ""}><a href="/product?cmd='list'&&currentPage=${pageResult.nextPage}" aria-label="Next"> <span aria-hidden="true">下一页</span>
				</a></li>
				<li ${pageResult.currentPage == pageResult.totalPage ? "class='disabled'" : ""}><a href="/product?cmd='list'&&currentPage=${pageResult.totalPage}" aria-label="Next"> <span aria-hidden="true">末页</span>
				</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>
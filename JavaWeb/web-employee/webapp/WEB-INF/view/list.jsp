<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 引入 My97DatePicker插件-->
	<script language="javascript" type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function go(pageNo){
			//把需要跳转的页码设置到<input type="number" name="currentPage"/>上
			if(pageNo){
				document.getElementById("currentPage").value = pageNo;
			}
			//提交表单
			document.forms[0].submit();
		}
	</script>
<body>
	<s:form namespace="/" action="employee">
		员工名字:<s:textfield name="qo.keyword"/>
		入职日期:<s:date name="qo.minEntryDate" format="yyyy-MM-dd" var="d"/>
					<input type="text" name="qo.minEntryDate" value="<s:property value="#d"/>"
						class="Wdate" onclick="WdatePicker();" />
						--
				<s:date name="qo.maxEntryDate" format="yyyy-MM-dd" var="d"/>
					<input type="text" name="qo.maxEntryDate" value="<s:property value="#d"/>"
						class="Wdate" onclick="WdatePicker();" />
		<s:submit value="查询"/>
		<br/>
	<s:a namespace="/" action="employee_input">添加员工</s:a>
	<table border="1" cellpadding="0" cellspacing="0" width="90%">
		<tr>
			<th>员工头像</th>
			<th>员工编号</th>
			<th>员工名称</th>
			<th>员工密码</th>
			<th>所在部门</th>
			<th>入职日期</th>
			<th>操&emsp;&emsp;作</th>
		</tr>
		<s:iterator value="#pageResult.listData">
		<tr>	
			<td><img src="<s:property value="headImg" default="/upload/default.png"/>" height="40"/></td>
			<td><s:property value="id"/></td>
			<td><s:property value="username"/></td>
			<td><s:property value="password"/></td>
			<td><s:property value="dept"/></td>
			<td><s:date name="entryDate" format="yyyy-MM-dd"/></td>
			<td>
				<s:a namespace="/" action="employee_input">
					<s:param name="employee.id" value="id"></s:param>
				编辑</s:a>
				<s:a namespace="/" action="employee_delete">
					<s:param name="employee.id" value="id"></s:param>
				删除</s:a>
			</td>
		</tr>
		</s:iterator>
		<tr align="center">
			<td colspan="7">
				<a href="javascript:go(1);">首页</a>
				<a href="javascript:go(${pageResult.prevPage});">上页</a>
				<a href="javascript:go(${pageResult.nextPage});">下页</a>
				<a href="javascript:go(${pageResult.totalPage});">末页</a>
				当前第${pageResult.currentPage}/${pageResult.totalPage}页,
				一共${pageResult.totalCount}条数据 跳转到
				<input type="number" min="1" max="${pageResult.totalPage}"
					id="currentPage" value="${pageResult.currentPage}" style="width: 50px"
					name="qo.currentPage" />
				页
				<input type="button" value="GO" onclick="go();" />
				每页
				<s:select name="qo.pageSize" list="{3,5,10}" onchange="go(1);" />条
			</td>
		</tr>
	</table>
	</s:form>	
</body>
</html>
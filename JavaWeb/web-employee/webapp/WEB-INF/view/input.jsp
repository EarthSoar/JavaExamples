<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 引入 My97DatePicker插件-->
	<script language="javascript" type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<s:property value="errors.headImg[0]"/>
	<s:form namespace="/" action="employee_save" method="post" enctype="multipart/form-data">
		<s:hidden name="employee.id"/>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>员工名称</td>
				<td><s:textfield name="employee.username"/></td>
			</tr>
			<tr>
				<td>初始密码</td>
				<td><s:textfield name="employee.password"/></td>
			</tr>
			<tr>
				<td>拉风头像</td>
				<td><%-- <s:textfield name="employee.headImg"/> --%>
					<s:file name="headImg"></s:file>
				</td>
			</tr>
			<tr>
				<td>所在部门</td>
				<td><s:textfield name="employee.dept"/></td>
			</tr>
			<tr>
				<td>入职日期</td>
				<td>
					<s:date name="employee.entryDate" format="yyyy-MM-dd" var="d"/>
					<input type="text" name="employee.entryDate" value="<s:property value="#d"/>"
						class="Wdate" onclick="WdatePicker();" />
			</tr>
			<tr>
				<td colspan="2"><s:submit value="保存"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
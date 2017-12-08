<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="tclass">
		<table>
			<tr>
				<td>Year</td>
				<td><sf:input type="text" path="year" value="2018" /><br /></td>
			</tr>
			<tr>
				<td>Semester</td>
				<td><sf:input type="text" path="semester" value="1" /><br /></td>
			</tr>
			<tr>
				<td>Code</td>
				<td><sf:input type="text" path="code" /><br /></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><sf:input type="text" path="title" /><br /></td>
			</tr>
			<tr>
				<td>Division</td>
				<td><sf:input type="text" path="division" /><br /></td>
			</tr>
			<tr>
				<td>credit</td>
				<td><sf:input type="text" path="credit" /><br /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="새 수강신청" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>
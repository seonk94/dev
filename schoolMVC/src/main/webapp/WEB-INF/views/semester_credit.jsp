<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>이수 학점</td>
			<td>상세 보기</td>
		</tr>
		
		<c:forEach var="ysc" items="${ysc}" >
			<tr>
				<td>
				<c:out value="${ysc.year}">
				</c:out>
				</td>
				<td>
				<c:out value="${ysc.semester}">
				</c:out>
				</td>
				<td>
				<c:out value="${ysc.credit}">
				</c:out>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/detail?year=${ysc.year}&semester=${ysc.semester}">상세보기</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>
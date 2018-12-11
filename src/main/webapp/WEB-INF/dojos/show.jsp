<%@ page language = "java" contentType="text/html; charset=UTF-8"
    pageEncoding = "UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Profile</title>
</head>
<body>
	<h1>Welcome to <c:out value="${dojo.name}"></c:out>! These are you ninjas:</h1>
	<%-- <p><c:out value="${dojo.ninjas}"></c:out></p> --%>
	
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojo.ninjas}" var="ninja">
					<tr>
						<td><c:out value="${ninja.firstName}"/></td>
						<td><c:out value="${ninja.lastName}"/></td>
						<td><c:out value="${ninja.age}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>

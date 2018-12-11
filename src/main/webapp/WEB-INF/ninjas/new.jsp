<%@ page language = "java" contentType="text/html; charset=UTF-8"
    pageEncoding = "UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<form:select path="dojo">
	    	<c:forEach items="${allDojos}" var="d">
	    		<form:option value="${d.id}" label="${d.name}"></form:option>
	    	</c:forEach>
	    </form:select>
	    
	     <p>
	        <form:label path="firstName">First Name:</form:label>
	        <form:errors path="firstName"/>
	        <form:input path="firstName"/>
	    </p>
	    
	     <p>
	        <form:label path="lastName">Last Name:</form:label>
	        <form:errors path="lastName"/>
	        <form:input path="lastName"/>
	    </p>
	    
	     <p>
	        <form:label path="age">Age:</form:label>
	        <form:errors path="age"/>
	        <form:input path="age"/>
	    </p>
	    
	    
	    
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<title>Trip User Demo</title>
</head>
<body>

	<div class="container mt-5">
		<h1> Create a User</h1>
		<form:form action="/users/new" method="POST" modelAttribute="newUser">
			<div>
				<form:label path="username"> User Name </form:label>
				<form:input path="username" class="form-control"/>
				<form:errors path="username"/>
			</div>
			<div>
				<form:label path="email"> Email </form:label>
				<form:input path="email" class="form-control"/>
				<form:errors path="email"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	
	</div>

</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>
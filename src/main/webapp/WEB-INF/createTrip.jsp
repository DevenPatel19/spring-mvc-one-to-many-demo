<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<title>Create Trip</title>
</head>
<body>
	<div class="container mt-5">
		<h1> Create a Trip</h1>
		<form:form action="/trips/new" method="POST" modelAttribute="newTrip">
			<div>
				<form:label path="location"> Location </form:label>
				<form:input path="location" class="form-control"/>
				<form:errors path="location"/>
			</div>
			<div>
				<form:label path="tripLength"> Length of Trip </form:label>
				<form:input type="number" path="tripLength" class="form-control"/>
				<form:errors path="tripLength"/>
			</div>
			<div>
				<form:label path="description"> Description </form:label>
				<form:input path="description" class="form-control"/>
				<form:errors path="description"/>
			</div>
			<div>
				<form:label path="owner">Owner</form:label>
				<form:select path="owner" class="form-control">
					<c:forEach var="eachUser" items="${userList}">
					<form:option value="${eachUser.id}">${eachUser.username} ${eachUser.email} </form:option>
					</c:forEach>
				</form:select>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	
	</div>
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>
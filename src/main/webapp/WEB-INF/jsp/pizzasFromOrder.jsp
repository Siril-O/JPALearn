<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizzas from Order</title>
</head>
<body>
<h1>Pizzas</h1>
		<a class="btn btn-primary" href="./account/">Back to Account</a>
<h3>Pizzas from Order</h3>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Price</td>
				<td>Type</td>
				<td>Quantity</td>
			</tr>
			<c:forEach var="entry" items="#{pizzas}">
				<tr>
					<td><c:out value="${entry.key.id}" /></td>
					<td><c:out value="${entry.key.name}" /></td>
					<td><c:out value="${entry.key.price}" /></td>
					<td><c:out value="${entry.key.type}" /></td>
					<td><c:out value="${entry.value}" /></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizzas List</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Pizzas List</h1>
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
		
		${userName} ${roles}
		
			<input class="btn btn-primary" type="submit" value="LogOut" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Price</td>
				<td>Type</td>
				<td>Edit</td>
				<td>Remove</td>
			</tr>
			<c:forEach var="pizza" items="${pizzasList}">
				<tr>
					<td><c:out value="${pizza.id}" /></td>
					<td><c:out value="${pizza.name}" /></td>
					<td><c:out value="${pizza.price}" /></td>
					<td><c:out value="${pizza.type}" /></td>
					<td>
						<form action="../pizza/editpizza">
							<input type="submit" value="Edit" class="btn btn-primary" /> <input
								type="hidden" name="pizzaId" value="${pizza.id}">
						</form>
					</td>
					<td><a class="btn btn-primary"
						href="../pizza/removepizza?pizzaId=${pizza.id}">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-primary" href="../pizza/addpizza">Add Pizza</a>

	</div>


</body>
</html>
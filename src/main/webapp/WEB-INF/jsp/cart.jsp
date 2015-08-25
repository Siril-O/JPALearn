<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div class="container">
		<h1>Pizzas to Order</h1>
		Hello: ${customer.name} You Are ${customer.role}
					<a class="btn btn-primary"href="./menu/">Menu</a>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Price</td>
				<td>Type</td>
				<td>Quantity</td>
			</tr>
			<c:forEach var="entry" items="#{pizzaMap}">
				<tr>
					<td><c:out value="${entry.key.id}" /></td>
					<td><c:out value="${entry.key.name}" /></td>
					<td><c:out value="${entry.key.price}" /></td>
					<td><c:out value="${entry.key.type}" /></td>
					<td><c:out value="${entry.value}" /></td>
					<td><form action="./remove" method="post">
					<input type="hidden" name="pizzaId" value="${entry.key.id}">
					<input class="btn btn-primary" type="submit" value="Remove from Cart" /></form></td>
				</tr>
			</c:forEach>
		</table>
		<form action="../cart/placeOrder" method="post">
		<fieldset>
  <legend>Customer info</legend>
		</fieldset>
		<input class="btn btn-primary" type="submit" value="Submit Order">
		</form>
	</div>
</body>
</html>
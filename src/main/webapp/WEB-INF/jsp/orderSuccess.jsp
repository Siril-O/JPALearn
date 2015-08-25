<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Order submited</title>
</head>
<body>
	<h2>Order</h2>
			<a class="btn btn-primary" href="/epamJPATest/jsp/cart/account/">Account</a>
	<h3>Order Submited, wait for our manager to call you!</h3>
	<table class="table table-hover">
		<tr>
			<td>Order Id</td>
			<td>Order Status</td>
			<td>Sum</td>
			<td>Discount</td>
			<td>Total</td>
		</tr>
		<tr>
			<td><c:out value="${order.id}" /></td>
			<td><c:out value="${order.status}" /></td>
			<td><c:out value="${order.totalSumm}" /></td>
			<td><c:out value="${order.discount}" /></td>
			<td><c:out value="${order.totalSumm-order.discount}" /></td>
		</tr>
	</table>
	<h3>Pizzas in order</h3>
	<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Price</td>
				<td>Type</td>
				<td>Quantity</td>
			</tr>
			<c:forEach var="entry" items="${order.pizzas}">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Account</title>
</head>
<body>
	<div class="container">
		<h1>Account</h1>
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			Hello: ${customer.name} You Are ${customer.role} <input
				class="btn btn-primary" type="submit" value="LogOut" /><input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<a class="btn btn-primary" href="../">Go to Cart</a> <a
				class="btn btn-primary" href="../menu/">Menu</a>
		</form>
		<h3>Orders</h3>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Status</td>
				<td>Sum</td>
				<td>Discount</td>
				<td>Total</td>
				<td></td>
			</tr>
			<c:forEach var="order" items="#{orders}">
				<tr>
					<td><c:out value="${order.id}" /></td>
					<td><c:out value="${order.status}" /></td>
					<td><c:out value="${order.totalSumm}" /></td>
					<td><c:out value="${order.discount}" /></td>
					<td><c:out value="${order.totalSumm-order.discount}" /></td>
					<td><form method="post" action="../viewPizzas">
							<input type="hidden" value="${order.id}" name="orderId">
							<input class="btn btn-primary" type="submit"
								value="Show ordered pizzas" /> <input type="hidden"
								name="orderId" value="${order.id}">
						</form></td>
				</tr>
			</c:forEach>
		</table>
		<h3>Accumulative Card</h3>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>TotalSumm</td>
				<td>Possible discount</td>
			</tr>
			<tr>
				<td>${customer.accumulativeCard.id}</td>
				<td>${customer.accumulativeCard.totalSumm}</td>
				<td>${customer.accumulativeCard.totalSumm*0.1}</td>
				<td></td>
			</tr>
		</table>
	</div>

</body>
</html>
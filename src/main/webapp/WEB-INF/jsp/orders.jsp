<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>All Orders</title>
</head>
<body>
<h1>Orders</h1>
Hello: ${customer.name} You Are ${customer.role}
		<a class="btn btn-primary" href="/epamJPATest/jsp/pizza/">Pizzas</a>
<h3>All Orders</h3>
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
					<td><form method="post" action="/epamJPATest/jsp/cart/viewPizzas">
					<input type="hidden" value="${order.id}" name="orderId">
					 <input	class="btn btn-primary" type="submit" value="Show ordered pizzas" />
							<input type="hidden" name="orderId" value="${order.id}">
						</form></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Edit Pizza</h1>
		<form:form action="../pizza/changepizza" method="get">
			<input type="hidden" name="id" value="${pizzaToEdit.id}" />
		Name: <input type="text" name="name" value="${pizzaToEdit.name}" />
			<br /> Price: <input type="text" name="price"
				value="${pizzaToEdit.price}" />
			<br /> Type :<input type="text" name="type"
				value="${pizzaToEdit.type}" />
			<br />
			<input type="submit" value="Change Pizza" />
		</form:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
		<h1>Add Pizza</h1>
		<form action="../pizza/create" class="form-horizontal" role="form"
			method="post">
			<div class="form-group">
				<label class="control-label" for="name">Name:</label><br/> <input type="text" name="name"
					id="name" class="form-control" />
			</div>
			<div class="form-group">
				<label class="control-label" for="price">Price:</label><br/> <input type="text" name="price"
					id="price" class="form-control" />
			</div>
			<div class="form-group">
				<label class="control-label" for="type">Type:</label><br/> <input type="text" name="type"
					id="type" class="form-control" />
			</div>
			<input type="submit" value="Add Pizza" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>
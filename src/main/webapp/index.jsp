<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create Product</h1>
	<form action="create">
		<input type="text" name="id">
		<input type="text" name="name">
		<input type="text" name="price">
		<input type="text" name="brand">
		<input type="text" name="description">
		<button type="submit">Create</button>
	</form>
	<br>
	<br>
	<hr>
	<br>
	<br>
	<br>
	<a href="allproducts">View All Products</a>
</body>
</html>
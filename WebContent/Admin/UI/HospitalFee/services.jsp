<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Dịch vụ</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<table class="table table-striped table-bordered text-center">
		<tr>
			<th>ID</th>
			<th>Tên dịch vụ</th>
			<th>Giá </th>
			<th>Ghi chú</th>
			<th>Hành động </th>
		</tr>
		<php:forEach items="${services }" var="s">
			<tr>
				<td><h3 style="color: red">${s.getId() }</h3></td>
				<td>${s.getServiceName()}</td>
				<td>${s.getPrice()}</td>
				<td>${s.getNote()}</td>
				<td><a class="btn btn-danger"
					href="./service/edit?id=${s.getId() }">Edit</a> <a
					class="btn btn-warning"
					href="./service/delete?id=${s.getId() }">Delete</a></td>
			</tr>
		</php:forEach>
	</table>
	
	<form action="service" method="post">
		<h2 class="text-danger text-center">Thêm vào các dịch vụ</h2>
		<div class="form-group">
			<label for="" style="font-size: 18px">Tên dịch vụ</label> <input
				name="name" type="text" class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Giá tiền (VND)</label> <input
				name="price" type="text" class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Ghi chú</label> <input
				name="notes" type="text" class="form-control">
		</div>
		<button>Submit</button>
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>
</body>
</html>
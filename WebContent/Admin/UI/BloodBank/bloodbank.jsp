<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Blood bank</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<table class="table table-striped table-bordered text-center">
		<tr>
			<th>ID</th>
			<th>Tên nhóm máu</th>
			<th>Địa chỉ</th>
			<th>Số điện thoại</th>
			<th>Còn lại</th>
			<th>Hành động</th>
		</tr>
		<php:forEach items="${bloods }" var="blood">
			<tr>
				<td><h3 style="color: red">${blood.getId() }</h3></td>
				<td>${blood.getBbname()}</td>
				<td>${blood.getAddress()}</td>
				<td>${blood.getPhoneNumber()}</td>
				<td>${blood.getRemain()}</td>
				<td><a class="btn btn-danger"
					href="./blood/edit?id=${blood.getId() }">Edit</a> <a
					class="btn btn-warning"
					href="./blood/delete?id=${blood.getId() }">Delete</a></td>
			</tr>
		</php:forEach>
	</table>
	
	<form action="bloodbank" method="post">
		<h2 class="text-danger text-center">Thêm vào ngân hàng máu</h2>
		<div class="form-group">
			<label for="" style="font-size: 18px">Tên nhóm máu</label> <input
				name="bbname" type="text" class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Địa chỉ</label> <input
				name="address" type="text" class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Số địện thoại</label> <input
				name="phone" type="text" class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Còn lại</label> <input name="remain"
				type="text" class="form-control">
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
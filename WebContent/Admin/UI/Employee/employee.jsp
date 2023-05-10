<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<table class="table table-striped table-bordered text-center">
		<tr>
			<th>ID</th>
			<th>Tên</th>
			<th>Vị trí</th>
			<th>Phòng ban</th>
			<th>Email</th>
			<th>Số điện thoại</th>
			<th>Tên đăng nhập</th>
			<th>Quản trị viên</th>
			<th>Hành động</th>
		</tr>
		<php:forEach items="${users }" var="user">
			<tr>
				<td><h3 style="color: red">${user.getId() }</h3></td>
				<td>${user.getName()}</td>
				<td><php:forEach items="${pos }" var="p">
						<php:if test="${p.getId() == user.getPosition()}">
						${p.getName() }
						</php:if>
					</php:forEach></td>

				<td>${user.getDepartment()}</td>
				<td>${user.getEmail()}</td>
				<td>${user.getPhone_number()}</td>
				<td>${user.getUsername()}</td>
				<td><php:if test="${user.getRole() == 1}">
						<input type="checkbox" checked>
					</php:if> <php:if test="${user.getRole() != 1}">
						<input type="checkbox">
					</php:if></td>
				<td><a class="btn btn-danger"
					href="./employee/editUser?id=${user.getId() }">Edit</a> <a
					class="btn btn-warning"
					href="./employee/deleteUser?id=${user.getId() }">Delete</a></td>
			</tr>
		</php:forEach>
	</table>

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
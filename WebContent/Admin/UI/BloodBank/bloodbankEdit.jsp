<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Blood Bank</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<form action="edit" method="post">
		<h2 class="text-danger text-center">Sửa Nhóm Máu</h2>
		<div class="form-group">
			<label for="" style="font-size: 18px">Tên nhóm máu</label> <input required
				name="bbname" type="text" value="${blood.getBbname() }"
				class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Địa chỉ</label> <input required
				name="address" type="text" value="${blood.getAddress() }"
				class="form-control">
		</div>
		
		<div class="form-group">
			<label for="" style="font-size: 18px">Số điện thoại</label> <input required
				name="phone" name="notes" type="text"
				value="${blood.getPhoneNumber() }" class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Còn lại</label> <input required
				name="remain" type="text" value="${blood.getRemain() }"
				class="form-control">
		</div>
		<input type="hidden" name="id" value="${blood.getId() }" />
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Service</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
	<form action="edit" method="post">
		<h2 class="text-danger text-center">Sửa dịch vụ</h2>
		<div class="form-group">
			<label for="" style="font-size: 18px">Tên dịch vụ</label> <input
				name="name" type="text" class="form-control" value="${service.getServiceName() }" required>
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Giá tiền (VND)</label> <input
				name="price" type="text" class="form-control" value="${service.getPrice() }" required>
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Ghi chú</label> <input
				name="notes" type="text" class="form-control" value="${service.getNote() }" required>
		</div>
		<input type="hidden" name="id" value="${service.getId() }"  />
		<button>Submit</button>
	</form>

	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>
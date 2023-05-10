<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Medication</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
	<form action="edit" method="post">
		<h2 class="text-danger text-center">Sửa thuốc</h2>
		<div class="form-group">
			<label for="" style="font-size: 18px">Tên thuốc</label> <input
				name="name" type="text" value="${medication.getName() }" class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Liều lượng</label> <input
				name="dosage" type="text" value="${medication.getDosage() }" class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Ghi chú</label> <input
				name="notes" type="text" value="${medication.getNotes() }" class="form-control">
		</div>
		<div class="form-group">
			<label for="" style="font-size: 18px">Giá</label> <input name="price"
				type="text" value="${medication.getPrice() }" class="form-control">
		</div>
		<input type="hidden" name="id" value="${medication.getId() }"  />
		<button>Submit</button>
	</form>

	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Fee</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link href=".././css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">
	<div id="wrapper">
		<%@include file="../../common/sidebar.jsp"%>
		<div id="content-wrapper">
			<%@include file="../../common/headerWrapper.jsp"%>
			<div>
				<form action="edit" method="post">
					<h2 class="text-danger text-center">Cập nhật tiền viện phí</h2>
					<div class="form-group">
						<label for="" style="font-size: 18px">Tên bệnh nhân</label> <select
							disabled required name="patient_id">
							<php:forEach items="${patients }" var="patient">
								<php:if test="${patient.getId() == feeTotal.getPatient_id()  }">
									<option value="${patient.getId() }" selected>${ patient.getName()}</option>
								</php:if>
								<php:if test="${patient.getId() != test.getPatient_id()  }">
									<option value="${patient.getId() }">${ patient.getName()}</option>
								</php:if>
							</php:forEach>
						</select>
					</div>

					<div class="form-group">
						<label for="" style="font-size: 18px">Tiền nội trú</label> <input
							required name="date" value="${feeTotal.getPriceInpatient() }"
							type="text" class="form-control">
					</div>
					<div class="form-group">
						<label for="" style="font-size: 18px">Ngày cập nhật</label> <input
							required name="note" value="${feeTotal.getDate() }" type="date"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="" style="font-size: 18px">Trạng thái</label> <select
							required name="status">
							<php:if test="${feeTotal.getStatus() == 1}">
								<option value="1" selected>Đã thanh toán</option>
								<option value="0">Chưa thanh toán</option>
							</php:if>
							<php:if test="${feeTotal.getStatus() != 1}">
								<option value="1">Đã thanh toán</option>
								<option value="0" selected>Chưa thanh toán</option>
							</php:if>

						</select>
					</div>
					<input type="hidden" name="id" value="${test.getId() }">
					<button class="btn btn-danger">Sửa</button>
				</form>
			</div>
		</div>
	</div>

	<%@include file="../../common/logoutModal.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>
	<script src=".././vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src=".././vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src=".././js/sb-admin-2.min.js"></script>
	<script src=".././vendor/jquery/jquery.min.js"></script>
</body>
</html>
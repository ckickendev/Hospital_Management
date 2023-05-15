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
			<a href="http://localhost:8080/Hospital_Management/feeTotal"
				class="btn btn-danger col-md-3">Trở về</a>
			<div class="border border-success bg-white mt-4 p-3">
				<div class="info">
					<p>Sở y tế Thành Phố Đà Nẵng</p>
					<p>BỆNH VIỆN FPT</p>
				</div>
				<h2 class="text-danger text-center">Chi tiết hóa đơn viện phí</h2>

				<p class="text-danger text-center">Ngày cấp: ${fee.getDate() }</p>
				<div class="container">
					<div class="d-flex justify-content-between">
						<div>
							<p class="text-danger">Tên bệnh nhân:
								${fee.getPatient().getName() }</p>
							<p class="text-danger">Giới tính:
								${fee.getPatient().getGender() }</p>
						</div>
						<div>
							<p>Ngày sinh: ${fee.getPatient().getDob() }</p>
							<p>Địa chỉ: ${fee.getPatient().getAddress() }</p>
							<p>Số điện thoại: ${fee.getPatient().getPhoneNumber() }</p>
						</div>
					</div>
					<div class="content">
						<php:if test="${fee.getPriceInpatient() != 0 }">
							<div
								class="border border-success p-4 d-flex justify-content-between">
								<h5 class="text-success">Tên dịch vụ: Tiền nội trú</h5>
								<p class="text-danger">Giá: ${fee.getPriceInpatient() } vnd
								
							</div>
						</php:if>
						<php:if test="${medicineFee != 0 }">
							<div class="border border-success p-4">
								<h5 class="text-success">Tên dịch vụ: Tiền thuốc</h5>

								<!-- ASDASD -->
								<table class="table table-striped table-bordered text-center">
									<tr>
										<th>Tên thuốc</th>
										<th>Liều lượng</th>
										<th>Ghi chú</th>
										<th>Đơn giá</th>
										<th>Số lượng</th>
										<th>Tổng</th>
									</tr>
									<php:forEach
										items="${dispenses.getListDispense_medications() }" var="medi">
										<tr>
											<td>${medi.getMedication().getName()}</td>
											<td>${medi.getMedication().getDosage()}</td>
											<td>${medi.getMedication().getNotes()}</td>
											<td>${medi.getMedication().getPrice()}</td>
											<td>${medi.getQtt()}</td>
											<td>${medi.getMedication().getPrice() * medi.getQtt() }</td>
										</tr>
									</php:forEach>

								</table>
								<p class="text-right text-danger">Tổng : ${medicineFee } vnd</p>
								<!-- ASDASD -->
							</div>
						</php:if>
						<php:if test="${testFee != 0 }">
							<div class="border border-success p-4">
								<h5 class="text-success">Tên dịch vụ: Tiền xét nghiệm</h5>

								<!-- ASDASD -->
								<table class="table table-striped table-bordered text-center">
									<tr>
										<th>Tên xét nghiệm</th>
										<th>Ngày xét nghiệm</th>
										<th>Ghi chú</th>
										<th>Kết quả</th>
										<th>Phí xét nghiệm</th>
									</tr>
									<php:forEach items="${tests }" var="test">
										<tr>
											<td>${test.getHospitalFee().getServiceName()}</td>
											<td>${test.getDate()}</td>
											<td>${test.getNotes()}</td>
											<td>${test.getResult()}</td>
											<td>${test.getHospitalFee().getPrice()}</td>
										</tr>
									</php:forEach>

								</table>
								<p class="text-right text-danger">Tổng : ${testFee } vnd</p>
								<!-- ASDASD -->
							</div>
						</php:if>
						<h3 class="text-right text-success mt-3">Tổng tiền phải thu: ${testFee+ medicineFee+fee.getPriceInpatient()} vnd</h3>
					</div>
				</div>



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
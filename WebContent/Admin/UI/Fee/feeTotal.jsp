<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Phí</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">
	<div id="wrapper">
		<%@include file="../../common/sidebar.jsp"%>
		<div id="content-wrapper">
			<%@include file="../../common/headerWrapper.jsp"%>
			<div>
				<h1 class="text-center text-danger">Các khoản viện phí</h1>
				<table class="table table-striped table-bordered text-center">
					<tr>
						<th>ID bệnh nhân</th>
						<th>Tên người xét nghiệm</th>
						<th>Tiền nội trú (tổng)</th>
						<th>Ngày tính</th>
						<th>Tổng số tiền</th>
						<th>Trạng thái</th>
						<th>Hành động</th>
					</tr>
					<php:forEach items="${feeTotal }" var="fee">
						<tr>
							<td><h3 style="color: red">${fee.getId() }</h3></td>
							<td>${fee.getPatient().getName()}</td>
							<td>${fee.getPriceInpatient()}</td>
							<td>${fee.getDate()}</td>
							<td>${fee.getFeeOfUser()}</td>
							<php:if test="${fee.getStatus() == 1 }">
								<td class="text-danger">Đã thanh toán</td>
							</php:if>
							<php:if test="${fee.getStatus() == 0 }">
								<td class="text-warning">Chưa thanh toán</td>
							</php:if>
							<td><a class="btn btn-danger"
								href="./feeTotal/edit?id=${fee.getPatient().getId() }">Edit</a> <a
								class="btn btn-warning" href="./feeTotal/detail?id=${fee.getId() }">Xem
									chi tiết</a></td>
						</tr>
					</php:forEach>
				</table>
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
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="js/sb-admin-2.min.js"></script>
	<script src="vendor/jquery/jquery.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Nội trú</title>
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
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<%@include file="../../common/headerWrapper.jsp"%>
				<div>
					<table class="table table-striped table-bordered text-center">
						<tr>
							<th>ID</th>
							<th>Tên bệnh nhân</th>
							<th>Ngày nhập viện</th>
							<th>Ngày xuất viện</th>
							<th>Phòng</th>
							<th>Ghi chú</th>
							<th>Hành động</th>
						</tr>
						<php:forEach items="${inpatients }" var="s">
							<tr>
								<td><h3 style="color: red">${s.getId() }</h3></td>
								<td><php:forEach items="${patients }" var="patient">
										<php:if test="${patient.getId() == s.getPatient_id() }">
							${ patient.getName()}
						</php:if>
									</php:forEach></td>
								<td>${s.getAdmission_date()}</td>
								<td>${s.getDischarge_date()}</td>
								<td>${s.getRoom()}</td>
								<td>${s.getNotes()}</td>
								<td><a class="btn btn-danger"
									href="./inpatient/edit?id=${s.getId() }">Edit</a> <a
									class="btn btn-warning"
									href="./inpatient/delete?id=${s.getId() }">Delete</a></td>
							</tr>
						</php:forEach>
					</table>
					<a href="inpatientAdd" class="btn btn-danger">Thêm bệnh nhân nội trú</a>
				</div>

			</div>
			<%@include file="../../common/footer.jsp"%>
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
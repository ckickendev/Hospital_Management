<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Examination</title>
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
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<%@include file="../../common/headerWrapper.jsp"%>
				<div>
					<form action="edit" method="post">
						<h2 class="text-danger text-center">Sửa hồ sơ khám</h2>
						<div class="form-group">
							<label for="" style="font-size: 18px">Tên bệnh nhân</label> <select
								required name="patient_id">
								<php:forEach items="${patients }" var="patient">
									<php:if test="${patient.getId() == examination.getPatientId()  }">
										<option value="${patient.getId() }" selected>${ patient.getName()}</option>
									</php:if>
									<php:if test="${patient.getId() != examination.getPatientId()  }">
										<option value="${patient.getId() }">${ patient.getName()}</option>
									</php:if>
								</php:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Tên bác sĩ</label> <select
								required name="doctor_id">
								<php:forEach items="${doctors }" var="doctor">
									<php:if test="${doctor.getId() == examination.getDoctorId()  }">
										<option value="${doctor.getId() }" selected>${ doctor.getName()}</option>
									</php:if>
									<php:if test="${patient.getId() != examination.getDoctorId()  }">
										<option value="${doctor.getId() }">${ doctor.getName()}</option>
									</php:if>
								</php:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Ngày</label> <input
								required name="date" type="date" value="${examination.getDate() }" class="form-control">
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Triệu chứng</label> <input
								required name="sym" type="text"
								value="${examination.getSymptoms() }" class="form-control">
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Chẩn đoán</label> <input
								required name="dia" type="text"
								value="${examination.getDiagnosis() }" class="form-control">
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Ghi chú</label> <input
								required name="note" type="text"
								value="${examination.getNotes() }" class="form-control">
						</div>
						<input type="hidden" name="id" value="${examination.getId() }" />
						<button class="btn btn-danger">Thêm</button>
					</form>
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
	<script src=".././vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src=".././vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src=".././js/sb-admin-2.min.js"></script>
	<script src=".././vendor/jquery/jquery.min.js"></script>




</body>
</html>
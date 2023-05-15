<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Test</title>
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
					<h2 class="text-danger text-center">Sửa xét nghiệm</h2>
					<div class="form-group">
						<label for="" style="font-size: 18px">Tên bệnh nhân</label> <select
							required name="patient_id">
							<php:forEach items="${patients }" var="patient">
								<php:if test="${patient.getId() == test.getPatient_id()  }">
									<option value="${patient.getId() }" selected>${ patient.getName()}</option>
								</php:if>
								<php:if test="${patient.getId() != test.getPatient_id()  }">
									<option value="${patient.getId() }">${ patient.getName()}</option>
								</php:if>
							</php:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="" style="font-size: 18px">Tên xét nghiệm</label> <select
							required name="service_id">

							<php:forEach items="${services }" var="service">
								<php:if test="${service.getId() == test.getTest_id()  }">
									<option value="${service.getId() }" selected>${ service.getServiceName()}</option>
								</php:if>
								<php:if test="${service.getId() != test.getTest_id()  }">
									<option value="${service.getId() }">${ service.getServiceName()}</option>
								</php:if>
							</php:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="" style="font-size: 18px">Ngày xét nghiệm</label> <input
							required name="date" value="${test.getDate() }" type="date" class="form-control">
					</div>
					<div class="form-group">
						<label for="" style="font-size: 18px">Ghi chú</label> <input
							required name="note" value="${test.getNotes() }" type="text" class="form-control">
					</div>
					<div class="form-group">
						<label for="" style="font-size: 18px">Kết quả</label> <input
							name="result" value="${test.getResult() }" type="text"  class="form-control">
					</div>
					<input type="hidden" name="id" value="${test.getId() }" >
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
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
					<form action="editUser" method="post">
						<h2 class="text-danger text-center">Sửa nhân viên</h2>
						<div class="form-group">
							<label for="" style="font-size: 18px">Tên nhân viên</label> <input
								name="name" type="text" value="${user.getName() }"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Chọn vị trí</label> <select
								name="position">
								<php:forEach items="${pos }" var="p">
									<option value="${p.getId()}">${p.getName() }</option>>
				</php:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Phòng ban</label> <input
								name="department" name="notes" type="text"
								value="${user.getDepartment() }" class="form-control">
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Email</label> <input
								name="email" type="text" value="${user.getEmail() }"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Sdt</label> <input
								name="phone_number" type="text"
								value="${user.getPhone_number() }" class="form-control">
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Username</label> <input
								name="username" disabled type="text"
								value="${user.getUsername() }" class="form-control">
						</div>
						<div class="form-group">
							<label for="" style="font-size: 18px">Email</label> <input
								name="price" type="text" value="${user.getEmail() }"
								class="form-control">
						</div>
						<php:if test="${user.getRole() == 1}">
							<input type="checkbox" checked name="role">
						</php:if>
						<php:if test="${user.getRole() != 1}">
							<input type="checkbox" name="role">
						</php:if>
						<input type="hidden" name="id" value="${user.getId() }" />
						<button>Submit</button>
					</form>
				</div>
				<%@include file="../../common/footer.jsp"%>

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
	<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous">
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>
</body>
</html>
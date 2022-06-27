<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="Page/css/login.css">
<link rel="stylesheet" href="Page/css/web.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="Page/css/cartMainCss.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="Page/css/cart33.css" type="text/css"
	media="screen">
<link rel="stylesheet"
	href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">
<link type="text/css" rel="stylesheet" href="Page/css/slick.css" />
<link type="text/css" rel="stylesheet" href="Page/css/slick-theme.css" />
<link type="text/css" rel="stylesheet"
	href="Page/css/nouislider.min.css" />
<link rel="stylesheet" href="Page/css/font-awesome.min.css">
<title>Login Flap Shop</title>
</head>
<body>

	<%@include file="header.jsp"%>
	<div class="body-login">
		<div class="container">
			<div class="main">
				<form action="login" method="post" class="form" id="form-login">
					<h3 class="login-title">Đăng nhập</h3>
					<div class="form-group">
						<input type="text" id="fullname" name="username"
							placeholder="Tên đăng nhập"> <span class="form-message"></span>
					</div>
					<div class="form-group">
						<input type="password" id="fullname" name="password"
							placeholder="Mật khẩu"> <span class="form-message"></span>
					</div>
					<php:if test="${mess.length() > 0 }">
						<p style="color: red">${mess }</p>
					</php:if>
					<a class="login-forget" onclick="ngu()">Quên mật khẩu</a>
					<div class="login-btn">
						<button type="submit" class="btn btn-outline-secondary">Đăng
							nhập</button>
					</div>
					<a href="home" class="login-not btn btn-success w-25">Quay về
						trang chủ </a>
				</form>
			</div>
		</div>
	</div>
	<!-- FOOTER -->

	<%@include file="footer.jsp"%>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<script src="./js/web.js"></script>
<script>
	function ngu() {
		alert('Quên mật khẩu là ngu');
	}
</script>
</html>
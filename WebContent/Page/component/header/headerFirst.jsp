<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="php"%>
<!-- HEADER -->
<header>
	<!-- TOP HEADER -->
	<div id="top-header">
		<div class="container">
			<ul class="header-links pull-left">
				<li><a href="#"><i class="fa fa-phone"></i> 0827299123</a></li>
				<li><a href="#"><i class="fa fa-envelope-o"></i>
						flapteam@gmail.com</a></li>
				<li><a href="#"><i class="fa fa-map-marker"></i> Ngu Hanh
						Son, Da Nang</a></li>
			</ul>
			<ul class="header-links pull-right">
				<li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
				<li class="contact-account">
					
					<php:if
						test="${userLogin == null }">
						<div class="contact-account__create">
							<span>Tài khoản</span> <i class="icon-down fas fa-chevron-down"></i>
						</div>
						<div class="contact-account__log" style="z-index: 10">
							<a href="login" class="contact-account__login"> <span class="element_text">Đăng
									nhập</span>
							</a> <a href="signup" class="contact-account__signup"> <span class="element_text">Đăng
									ký</span>
							</a>
						</div>
					</php:if> 
					
					<php:if test="${userLogin != null }">
						<div class="nav-item dropdown d-none d-lg-block user-dropdown"><a
							class="nav-link" id="UserDropdown" href="#"
							data-bs-toggle="dropdown" aria-expanded="false">
						</a>
							<div
								class="dropdown-menu dropdown-menu-right navbar-dropdown m-4 p-4 dropmenu_config_color"
								aria-labelledby="UserDropdown">
								<div class="dropdown-header text-center">
									<p class="mb-1 mt-3 font-weight-semibold">${userLogin.getName() }</p>
									<p class="fw-light text-muted mb-0">${userLogin.getEmail() }</p>
								</div>
								<php:if test="${userLogin.getRole() == 1 }">
									<a href="admin/home" class="dropdown-item my-2 "><i
										class="fas fa-cogs text-danger me-2"></i> Quản lí <span
										class="badge badge-pill badge-danger">1</span></a>
								</php:if>
								<a href="./profile" class="dropdown-item my-2 "><i
									class="far fa-user text-primary me-2"></i> Hồ sơ của tôi <span
									class="badge badge-pill badge-danger">1</span></a> <a
									class="dropdown-item my-2 " href="history"><i
									class="far fa-envelope text-primary me-2"></i> Lịch sử</a> <a
									class="dropdown-item my-2 "><i
									class="fas fa-calendar-times text-primary me-2"></i> Hoạt động</a> <a
									class="dropdown-item my-2 "><i
									class="fas fa-question-circle text-primary me-2"></i> FAQ</a> <a
									class="dropdown-item my-2" href="signout"><i
									class="fas fa-sign-out-alt text-warning me-2"></i>Đăng xuất</a>
							</div></div>

					</php:if></li>



			</ul>
		</div>
	</div>
	<!-- /TOP HEADER -->

	<!-- MAIN HEADER -->
	<div id="header">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row row_headerFirst">
				<!-- LOGO -->

				<div class="col-md-3">
					<div class="header-logo">
						<a href="home" class="logo"> <img width="200px" height="80px"
							src="Page/img/logo.png" alt="">
						</a>
					</div>
				</div>
				<!-- /LOGO -->

				<!-- SEARCH BAR -->
				<div class="col-md-6">
					<div class="header-search">
						<form action="search" method="get">
							<select class="input-select">
								<option value="0">Tất cả danh mục</option>
								<option value="1">Tất cả danh mục</option>
								<option value="1">Tất cả danh mục</option>
							</select> <input class="input header_search_input" name="key" placeholder="Nhập từ khóa">
							<button class="search-btn">Tìm kiếm</button>
						</form>
					</div>
				</div>
				<!-- /SEARCH BAR -->

				<!-- ACCOUNT -->
				<div class="col-md-3 clearfix">
					<div class="header-ctn">
						<!-- Wishlist -->
						<div>
							<a href="#"> <i class="fa fa-heart-o"></i> <span>Yêu thích</span>
								<div class="qty">2</div>
							</a>
						</div>
						<!-- /Wishlist -->

						<!-- Cart -->
						<div class="dropdown header-cart__item cart-header-right"
							style="position: relative">
							<a class="dropdown-toggle header-cart__added"
								data-toggle="dropdown" aria-expanded="true"> <i
								class="fa fa-shopping-cart"></i> <span>Giỏ hàng</span>
								<div class="qty">${sessionScope.cart != null ? sessionScope.cart.getCartItems().size() : 0}</div>
							</a>

							<%@include file="headerCartDiv.jsp"%>

						</div>
						<!-- /Cart -->

						<!-- Menu Toogle -->
						<div class="menu-toggle">
							<a href="#"> <i class="fa fa-bars"></i> <span>Menu</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>



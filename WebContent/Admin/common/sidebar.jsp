<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="http://localhost:8080/Hospital_Management/home">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">Hospital</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link"
		href="http://localhost:8080/Hospital_Management/home"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Interface</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-cog"></i> <span>Khám
				bệnh</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Management Components:</h6>
				<a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/patient">Quản
					lí tiếp nhận bệnh nhân</a> <a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/inpatient">Quản
					lí bệnh nhân nội trú</a> <a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/tests">Quản lí
					xét nghiệm</a> <a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/feeTotal">Quản lí
					viện phí</a> <a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/examination">Quản
					lí khám bệnh</a> <a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/dismedication">Quản
					lí đơn thuốc</a>
			</div>
		</div></li>

	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities1"
		aria-expanded="true" aria-controls="collapseUtilities1"> <i
			class="fas fa-fw fa-wrench"></i> <span>Vật tư bệnh viện</span>
	</a>
		<div id="collapseUtilities1" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Management Medical:</h6>
				<a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/bloodbank">Quản
					lí ngân hàng máu</a> <a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/medication">Quản
					lí dược</a> <a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/service">Quản
					lí dịch vụ</a>
			</div>
		</div></li>

	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities2"
		aria-expanded="true" aria-controls="collapseUtilities2"> <i
			class="fas fa-fw fa-wrench"></i> <span>Nhân sự</span>
	</a>
		<div id="collapseUtilities2" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Management Employee:</h6>
				<a class="collapse-item"
					href="http://localhost:8080/Hospital_Management/employee">Quản
					lí nhân sự</a>
			</div>
		</div></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Addons</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-fw fa-folder"></i> <span>Pages</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Login Screens:</h6>
				<a class="collapse-item" href="login.html">Login</a> <a
					class="collapse-item" href="register.html">Register</a> <a
					class="collapse-item" href="forgot-password.html">Forgot
					Password</a>
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">Other Pages:</h6>
				<a class="collapse-item" href="404.html">404 Page</a> <a
					class="collapse-item" href="blank.html">Blank Page</a>
			</div>
		</div></li>

	<!-- Nav Item - Charts -->

	<!-- Nav Item - Tables -->
	<li class="nav-item"><a class="nav-link" href="tables.html"> <i
			class="fas fa-fw fa-table"></i> <span>Tables</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

	<!-- Sidebar Message -->
	<div class="sidebar-card d-none d-lg-flex">
		<img class="sidebar-card-illustration mb-2"
			src="img/undraw_rocket.svg" alt="...">
		<p class="text-center mb-2">
			<strong>SB Admin Pro</strong> is packed with premium features,
			components, and more!
		</p>
		<a class="btn btn-success btn-sm"
			href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to
			Pro!</a>
	</div>

</ul>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="el-header">
		<div class="container" style="position: relative;">
			<ul class="nav navbar-nav navbar-right">
<<<<<<< HEAD
				<c:choose>
					<c:when test="${empty sessionScope.session_user }">
						<li><a href="/login.jsp">Login</a></li>
						<li><a href="/register.jsp">Register</a></li>
=======
				<li><a href="/index.jsp">HomePage</a></li>
					<c:choose>
   					<c:when test="${empty sessionScope.session_user }">
					<li><a href="/login.jsp">Login</a></li>
					<li><a href="/register.html">Register</a></li>
>>>>>>> 2b74d1eea3fb540f8345cf744bac4b207105c65c
					</c:when>
					<c:otherwise>
						<li><a class="el-current-user" href="/personal.do">${sessionScope.session_user.email}</a>
						</li>
						<li><a href="/cartList.jsp">ShoppingCart</a></li>
						<li><a href="/home.jsp">PersonalManage</a></li>
						<li><a href="/UserServlet?method=logout">Logout</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="#">Help</a></li>
			</ul>
		</div>
	</div>
</body>
</html>


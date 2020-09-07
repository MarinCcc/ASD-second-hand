<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div class="el-header" >
		<div class="container" style="position: relative;">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/index.jsp">HomePage</a></li>
					<c:choose>
   					<c:when test="${empty sessionScope.session_user }">
					<li><a href="/login.html">Login</a></li>
					<li><a href="/register.html">Register</a></li>
					</c:when>
					<c:otherwise>
					<li>
						  <a class="el-current-user" href="/personal.do">${sessionScope.session_user.username}</a>
					</li>
					<li><a  href="/UserServlet?method=logout">Logout</a></li>
					</c:otherwise>
					</c:choose>
				<li><a href="#">Help</a></li>
			</ul>
		</div>
</div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
	
<ul id="menu" class="list-group">
	<li class="list-group-item">
		<a href="javascript:;"><span>Personal Information</span></a>
		<ul>
			<li name="ld"><a href="personalInfo.jsp"><span>Login detail</span></a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#"><span class="text-title">Monitoring</span></a>
		<ul class="in">
			<li name="allProducts"><a href="#">view all products</a></li>
			<li name="Transation record"><a href="/">view pending order</a></li>
			<li name="seller"><a href="/">view all sellers</a></li>
			<li name="buyer"><a href="/">view all buyers</a></li>
			<li name="auditSaleApplyPage"><a href="/ProductServlet?method=auditSaleApplyPage">audit Sale Application</a></li>
			
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#"><span>Categories</span></a>
		<ul class="in">
			<li name="accountFlow_list"><a href="">view all categories</a></li>
			
		</ul>
	</li>
</ul>


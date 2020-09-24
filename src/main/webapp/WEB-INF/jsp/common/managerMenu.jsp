<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
	
<ul id="menu" class="list-group">
	<li class="list-group-item">
		<a href="javascript:;"><span>Personal detail</span></a>
		<ul>
			<li name="infor"><a href="/"><span>Information</span></a></li>
			<li name="ld"><a href="#"><span>Login detail</span></a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#"><span class="text-title">Monitoring</span></a>
		<ul class="in">
			<li name="allProducts"><a href="#">view all products</a></li>
			<li name="Transation record"><a href="/">Transation record</a></li>
			<li name="seller"><a href="/">view all sellers</a></li>
			<li name="buyer"><a href="/">view all buyers</a></li>
			
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#"><span>Categories</span></a>
		<ul class="in">
			<li name="accountFlow_list"><a href="">view all categories</a></li>
			
		</ul>
	</li>
</ul>

<!-- <#if currentMenu??>
<script type="text/javascript">
	$(".list-group-item li[name=${currentMenu}]").addClass("active");
</script>
</#if> -->
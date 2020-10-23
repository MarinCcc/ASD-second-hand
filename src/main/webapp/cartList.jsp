<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My Cart List Page</title>

    <link rel="stylesheet" href="./js/bootstrap-3.3.2-dist/css/bootstrap.css"
          type="text/css" />
    <link rel="stylesheet" href="./css/core.css" type="text/css" />
    <link type="text/css" rel="stylesheet" href="./css/account.css" />
    <script type="text/javascript" src="./js/jquery/jquery-2.1.3.js"></script>
    <script type="text/javascript"
            src="./js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="./js/jquery.bootstrap.min.js"></script>

    <script type="text/javascript">

    </script>

    <%@ include file="WEB-INF/jsp/common/top.jsp"%>
    <%@ include file="WEB-INF/jsp/common/head.jsp"%>

</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <%@ include file="WEB-INF/jsp/common/leftMenu.jsp"%>
        </div>
        <c:choose>
            <c:when test="${empty cartVos }">
                <div class="alert alert-warning">
                    No products added to your shopping cart.
                </div>
            </c:when>
            <c:otherwise>
                <table style="width:70%;">
                    <thead>
                    <tr>
                        <th>Product</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Date</th>
                        <th>Operation</th>
                    </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="item" items="${cartVos}">
                           <tr>
                               <td>${item.productTitle }</td>
                               <td>${item.productPrice }</td>
                               <td>${item.quantity }</td>
                               <jsp:useBean id="now" class="java.util.Date" scope="request" />
                               <td><fmt:formatDate  value="${item.createAt }" type="both"/></td>
                               <td><input type="checkbox" name="product" value="${item.productId}" checked="checked" /></td>
                            </tr>
                        </c:forEach>
                        <tr>
                               <td></td>
                                <td></td>
                               <td></td>
                               <td></td>
                               <td><button  name="buy" id="cartBuy">buy</button></td>
                       </tr>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</body>
<%@ include file="WEB-INF/jsp/common/footer.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#cartBuy").click(function(){
			var chk_value =[];
			$('input[name="product"]:checked').each(function(){
				chk_value.push($(this).val());
			});
			alert(JSON.stringify(chk_value));
		});
		
	});
</script>
</html>
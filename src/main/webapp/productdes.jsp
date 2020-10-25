<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${product.getTitle()}</title>
</head>
<body>
	<ul>
		<li>Title: ${product.getTitle()}</li>
		<li><img alt="300x200" src="${product.getPicture1()}" /></li>
		<li><img alt="300x200" src="${product.getPicture2()}" /></li>
		<li>category: ${product.getCategory()}</li>
		<li>price: $ ${product.getPrice()}</li>
		<li>description: ${product.getDescription()}</li>
		<li>applierEmail: ${product.getApplierEmail()}</li>
		<li>remark: ${product.getRemark()}</li>
	</ul>
</body>
</html>
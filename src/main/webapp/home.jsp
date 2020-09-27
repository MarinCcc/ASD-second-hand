<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<style>
a {
	color: white;
	background: #1E63B0; //
	默认的颜色 border-radius: 5px;
}

a:active {
	color: black;
	border-radius: 5px;
	background: #4a9bfa;
	黑色 opacity: 0.5;
	//
	这里重要，就是通过这个透明度来设置
}
</style>
</head>
<body>
	<div style="width: 1300px; background-color: burlywood;">
		<div style="width: 80%; margin: 0 auto">
			<a href="home.jsp">home</a>
		</div>
		<div>
			<div
				style="float: left; margin-left: 25px; width: 300px; height: 300px">
				<a href="detail?id=1"> <img alt="earphone" src="img/earphone.jpg" width="100%" height="100%">
				</a>
			</div>
			<div
				style="float: left; margin-left: 25px; width: 300px; height: 300px">
				<a href="detail?id=2"> <img alt="iwatch" src="img/iwatch.jpg" width="100%" height="100%">
				</a>
			</div>
			<div
				style="float: left; margin-left: 25px; width: 300px; height: 300px">
				<a href="detail?id=3"> <img alt="pc" src="img/pc.jpg" width="100%" height="100%"></a>
			</div>
			<div
				style="float: left; margin-left: 25px; width: 300px; height: 300px">
				<a href="detail?id=4"> <img alt="ipad" src="img/ipad.jpg" width="100%" height="100%"></a>
			</div>
		</div>
	</div>
</body>
</html>
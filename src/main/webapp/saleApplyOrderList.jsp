<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Second-Hand Trading Market</title>

<link rel="stylesheet" href="/js/bootstrap-3.3.2-dist/css/bootstrap.css"
	type="text/css" />
<link rel="stylesheet" href="/css/core.css" type="text/css" />
<link type="text/css" rel="stylesheet" href="/css/account.css" />
<script type="text/javascript" src="/js/jquery/jquery-2.1.3.js"></script>
<script type="text/javascript"
	src="/js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/js/jquery.bootstrap.min.js"></script>
<script type="text/javascript"
	src="/js/plugins/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript"
	src="/js/plugins/jquery.twbsPagination.min.js"></script>
x

<style type="text/css">
.picture {
	width: 160px;
	height: 150px;
	float: left;
	margin-right: 10px;
	border: 1px solid #e3e3e3;
	text-align: center;
	padding: 5px;
}

.uploadImg {
	width: 100px;
	height: 100px;
	margin-top: 5px;
}

.swfupload {
	left: 0px;
	cursor: pointer;
}

.uploadify {
	height: 20px;
	font-size: 13px;
	line-height: 20px;
	text-align: center;
	position: relative;
	margin-left: auto;
	margin-right: auto;
	cursor: pointer;
	background-color: #337ab7;
	border-color: #2e6da4;
	color: #fff;
}
</style>

<script type="text/javascript">
		$(function() {
			$('#pagination').twbsPagination({
				totalPages : ${pageResult.totalPage},
				startPage : ${pageResult.currentPage},
				visiblePages : 5,
				first : "first",
				prev : "pre",
				next : "next",
				last : "last",
				onPageClick : function(event, page) {
					$("#currentPage").val(page);
					$("#searchForm").submit();
				}
			});
			
			$(".btn_audit").click(function(){
				var form=$("#editform");
				$("#myModal").modal("hide");
				form.ajaxSubmit(function(){
					$.messager.confirm("Congratulation","Audit Successful!",function(){
						window.location.reload();
					});
				});
				return false;
			});
			
			$("#uploadBtn1").uploadify({
				buttonText:"Picture1",
				fileObjName:"file",
				fileTypeDesc:"Picture1",
				fileTypeExts:"*.gif; *.jpg; *.png",
				multi:false,
				swf:"/js/plugins/uploadify/uploadify.swf",
				uploader:"/UpdatePictureServlet",
				overrideEvents:["onUploadSuccess","onSelect"],
				onUploadSuccess:function(file,data){
					$("#uploadImg1").attr("src",data);
					$("#uploadImage1").val(data);
				}
			});
			
			$("#uploadBtn2").uploadify({
				buttonText:"Picture2",
				fileObjName:"file",
				fileTypeDesc:"Picture2",
				fileTypeExts:"*.gif; *.jpg; *.png",
				multi:false,
				swf:"/js/plugins/uploadify/uploadify.swf",
				uploader:"/UpdatePictureServlet",
				overrideEvents:["onUploadSuccess","onSelect"],
				onUploadSuccess:function(file,data){
					$("#uploadImg2").attr("src",data);
					$("#uploadImage2").val(data);
				}
			});
			
			$(".auditClass").click(function(){
				var json=$(this).data("json");
				$("#oid").val(json.oid);
				$("#title").val(json.title);
				$("#price").val(json.price);
				$("#description").val(json.description);
				if(json.bargainStatus == true){
					$("#bargainStatus").val(0);
				}
				else{
					$("#bargainStatus").val(1);
				}
				$("#category").val(json.category);
				$("#uploadImg1").attr("src",json.picture1);
				$("#uploadImg2").attr("src",json.picture2);
				$("#uploadImage1").val(json.picture1);
				$("#uploadImage2").val(json.picture2);
				$("#myModal").modal("show");
			});
			});
			
		

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
			<div class="col-sm-9">
				<div class="page-header">
					<h3>Applying Order</h3>
				</div>
				<form id="searchForm" class="form-inline" method="post"
					action="/ProductServlet?method=saleApplyingListPage">
					<input type="hidden" id="currentPage" name="currentPage" value="" />
				</form>
				<div class="panel panel-default">

					<c:choose>
						<c:when test="${not empty pageResult.listData}">
							<table class="table">

								<thead>
									<tr>
										<th>Title</th>
										<th>Price</th>
										<th>Category</th>
										<th>Apply Date</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="info" items="${pageResult.listData}">
										<tr>
											<td>${info.title}</td>
											<td>${info.price}</td>
											<td>${info.category}</td>
											<td>${info.applyTime}</td>
											<td><a href="javascript:void(-1);" class="auditClass"
												data-json='${info.jsonString}'>Modify</a></td>
											<td><a
												href="ProductServlet?method=withdrawSaleApply&oid=${info.oid}">Delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div style="text-align: center;">
								<ul id="pagination" class="pagination"></ul>
							</div>
						</c:when>
						<c:otherwise>
							<h1>You have no application at present</h1>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<form class="form-horizontal" id="editform" method="post"
							action="/ProductServlet?method=editSaleApplyingListPage">
							<fieldset>
								<div id="legend" class="">
									<legend>Modify Application</legend>
								</div>
								<input type="hidden" name="oid" id="oid" value="" />
								<div class="form-group">
									<label class="col-sm-4 control-label" for="title">Title</label>
									<div class="col-sm-8">
										<input id="title" name="title" class="form-control"
											type="text">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4  control-label" for="category">Category</label>
									<div class="col-sm-8">
										<select id="category" class="form-control" name="category"
											size="1">
											<!-- <option >Please select a category</option> -->
											<option value="Fashion">Fashion</option>
											<option value="Electronics">Electronics</option>
											<option value="SportingGoods">SportingGoods</option>
											<option value="HomeGarden">Home & Garden</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4  control-label" for="price">Sale
										Price</label>
									<div class="col-sm-8">
										<input id="price" class="form-control" name="price"
											type="text">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4  control-label" for="description">Description</label>
									<div class="col-sm-8">
										<input id="description" class="form-control"
											name="description" type="text">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4  control-label" for="bargainStatus">Bargain
										Status</label>
									<div class="col-sm-8">
										<select id="bargainStatus" class="form-control"
											name="bargainStatus" size="1">
											<option value="0">Yes</option>
											<option value="1">No</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-4  control-label" for="picture">Picture</label>
									<div class="col-sm-8">
										<div class=picture>
											<div>
												<a href="javascript:;" id="uploadBtn1">Picture1</a>
											</div>
											<img alt="" src="" class="uploadImg" id="uploadImg1" /> <input
												type="hidden" name="image1" id="uploadImage1" />
										</div>
										<div class="picture">
											<div>
												<a href="javascript:;" id="uploadBtn2">Picture2</a>
											</div>
											<img alt="" src="" class="uploadImg" id="uploadImg2" /> <input
												type="hidden" name="image2" id="uploadImage2" />
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-success btn_audit" value="1">Modify</button>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
<%@ include file="WEB-INF/jsp/common/footer.jsp"%>
</html>
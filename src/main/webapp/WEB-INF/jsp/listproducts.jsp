<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sky Mall Shopping</title>

<link type="text/css" href="static/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/product.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">

		<div class="row">

			<c:forEach items="${products}" var="prodInfo">
				<div class="col-lg-4">
					<div class="well">
						<h2>${prodInfo.productDesc}</h2>
						<ul>
							<li>Price: ${prodInfo.unitPrice}</li>
							<li>Quantity: ${prodInfo.quantity}</li>
							<li>Category: ${prodInfo.category}</li>
						</ul>
						<form:form action="addToCart" modelAttribute="itemForm">
							<div class="input-group">
								<form:input type="hidden" path="code" value="${prodInfo.productCode}" />
								<form:input type="hidden" path="name" value="${prodInfo.productDesc}" />
								<form:input type="hidden" path="unitPrice" value="${prodInfo.unitPrice}" />
								<span class="input-group-addon" id="sizing-addon1">Quantity</span>
								<form:input type="text" path="qty" class="form-control" aria-label="" value="1" />
								<div class="input-group-btn">
									<button class="btn btn-success" type="submit">Add to Cart</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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
			<h2>Customer Detail:</h2>
			<form:form action="addCustomer" modelAttribute="customerForm">
				<div class="form-group">
					<label for="name">Name: </label> 
					<form:input type="text" path="name" class="form-control" />
				</div>
				<div class="form-group">
					<label for="pwd">Address:</label> 
					<form:input type="" path="address" class="form-control" />
				</div>
				<div class="form-group">
					<label for="pwd">Phone Number:</label> 
					<form:input type="text" path="phone" class="form-control" />
				</div>				
				<button type="submit" class="btn btn-success">Checkout</button>
			</form:form>
		</div>
	</div>
</body>
</html>
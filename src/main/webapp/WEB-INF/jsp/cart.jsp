<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sky Mall Shopping</title>

<link type="text/css" href="static/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">

		<c:if test="${empty cart.orderItemTOs}">
			<h2>There is no items in Cart</h2>
		</c:if>
		<c:if test="${not empty cart.orderItemTOs}">

			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cart.orderItemTOs}" var="item">
						<tr>
							<td data-th="Product">
								<div class="row">
									<!-- div class="col-sm-2 hidden-xs">
								<img src="http://placehold.it/100x100" alt="..."
									class="img-responsive" />
							</div -->
									<div class="col-sm-12">
										<h4 class="nomargin">${item.productName}</h4>
										<p></p>
									</div>
								</div>
							</td>
							<td data-th="Price">${item.unitPrice}</td>
							<td data-th="Quantity">${item.qty} <!-- input type="number" class="form-control text-center" value="1" -->
							</td>
							<td data-th="Subtotal" class="text-center">${item.purchasePrice}</td>
							<td class="actions" data-th="">								
								<a class="btn btn-danger btn-sm" href="delete?pCode=${item.productCode}">
									<i class="glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total 1.99</strong></td>
					</tr>
					<tr>
						<td><a href="skymall" class="btn btn-warning"><i
								class="fa fa-angle-left"></i> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center">
							<strong>Total ${cart.total}</strong>
						</td>
						<td><a href="addCustomer" class="btn btn-success btn-block">Continue
								<i class="fa fa-angle-right"></i>
						</a></td>
					</tr>
				</tfoot>
			</table>
		</c:if>
	</div>
</body>
</html>
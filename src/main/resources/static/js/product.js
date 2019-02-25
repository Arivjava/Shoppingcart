/**
 * 
 */
$(document).ready(function(){
	
	//Product save 
	$("#productsave").click(function(event){
		
		event.preventDefault();
		//Using ajax json submit.

		var data = {};
		data['productDesc']  = $('#productDesc').val();
		data['unitPrice']    = $('#unitPrice').val();
		data['quantity']     = $('#quantity').val();
		data['category']     = $('#category').val();
		//alert(JSON.stringify(data));
		
		$.ajax({ 
			 	headers: {
			        Accept: "application/json; charset=utf-8",
			        "Content-Type": "application/json; charset=utf-8"
			    },
			    type: "POST",
			    url: "/productsystem/addProduct",
			    data: JSON.stringify(data),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
				success : function(response) {
					if(response.validated) {
						$('#statusMessage').html(response.statusMessage);
						$('#statusMessage').addClass("alert alert-success");
					}
					else{
						$("#productidmsg").html("");
						$("#productdescmsg").html("");
						$("#unitPricemsg").html("");
		          		$("#quantitymsg").html("");
		          		$("#categorymsg").html("");
		          	 
		          	 
						$.each(response.errorMessages,function(key,value){
							console.log(key + value);
		  	          		if(key=="productId") {
		  	          			$("#productidmsg").html(value);
		  	          		}
		  	          		if(key=="productDesc") {
		  	          			$("#productdescmsg").html(value);
		  	          		}
		  	          		if(key=="unitPrice") {
		  	          			$("#unitPricemsg").html(value);
		  	          		}
		  	          		if(key=="quantity") {
		  	          			$("#quantitymsg").html(value);
		  	          		}
		  	          		if(key=="category") {
		  	          			$("#categorymsg").html(value);
		  	          		}
		  	          		  	          		
			             });
					}
				},
				error : function(xhr, error) {
					$('#statusMessage').html("Error while adding Product Data");
					$('#statusMessage').addClass("alert alert-danger");
					console.log("Error Code :"+ xhr.status);
					console.log(error);
				}
		});
		
	});
	
	$('#viewProduct').click(function(){
		$.ajax({
			type : "GET",
			url : '/productsystem/getProduct',
			data : "productId=" + $('#viewProductId').val(),
		    contentType: "application/json; charset=utf-8",
			success : function(response){
				if(response.validated) {
					
					$('#statusMessage').html("");
					$('#statusMessage').removeClass("alert alert-danger");
					
					$('#productId').val(response.productTO.productId);
		            $("#productId").attr("disabled", "disabled"); 
					$('#productDesc').val(response.productTO.productDesc);
					$("#productDesc").attr("disabled", "disabled");
					$('#unitPrice').val(response.productTO.unitPrice);
					$('#quantity').val(response.productTO.quantity);
					$('#category').val(response.productTO.category);
					$("#category").attr("disabled", "disabled");
					$('#productStatus').val(response.productTO.productStatus);
				}
				else{
					$('#statusMessage').html(response.statusMessage);
					$('#statusMessage').addClass("alert alert-danger");
					
					$('#productId').val("");
		            //$("#customerId").attr("disabled", "disabled"); 
					$('#productName').val("");
					//$("#productName").attr("");
					$('#unitPrice').val("");
					$('#quantity').val("");
					$('#category').val("");
					$('#productStatus').val("");
					$("#productUpdate").prop("disabled",true);

				}
			},
			error : function(xhr, error){
				console.log("Error code:" + xhr.status);
				console.log(error);
			}
		});
	});

	$("#productUpdate").click(function(event){
		
		event.preventDefault();
	
		var data = {};
		data['productId']    = $('#productId').val();
		data['productDesc']  = $('#productDesc').val();
		data['unitPrice']    = $('#unitPrice').val();
		data['quantity']     = $('#quantity').val();
		data['category']     = $('#category').val();
		data['productStatus']  = $('#productStatus').val();
		$.ajax({ 
			 	headers: {
			        Accept: "application/json; charset=utf-8",
			        "Content-Type": "application/json; charset=utf-8"
			    },
			    type: "POST",
			    url: "/productsystem/updateProduct",
			    data: JSON.stringify(data),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
				success : function(response) {
					if(response.validated) {
						$('#statusMessage').html("Product Data Updated successfully");
						$('#statusMessage').addClass("alert alert-success");
					}
					else{
						$("#productidmsg").html("");
						$("#productdescmsg").html("");
						$("#unitpricemsg").html("");
		          		$("#quantitymsg").html("");
		          		$("#categorymsg").html("");
		          		$("#productstatusmsg").html("");
		          		 
		          		
						$.each(response.errorMessages,function(key,value){
							console.log(key + value);
		  	          		if(key=="productId") {
		  	          			$("#productidmsg").html(value);
		  	          		}
		  	          		if(key=="productDesc") {
		  	          			$("#productdescmsg").html(value);
		  	          		}
		  	          		if(key=="unitPrice") {
		  	          			$("#unitpricemsg").html(value);
		  	          		}
		  	          		if(key=="quantity") {
		  	          			$("#quantitymsg").html(value);
		  	          		}
		  	          		if(key=="category") {	
		  	          			$("#categorymsg").html(value);
		  	          		}
		  	          		if(key=="productStatus") {
		  	          			$("#productstatusmsg").html(value);
		  	          		}
		  	             });
					}
				},
				error : function(xhr, error) {
					$('#statusMessage').html("Error while updating Product Data");
					$('#statusMessage').addClass("alert alert-danger");
					console.log("Error Code :"+ xhr.status);
					console.log(error);
				}
		});
	
});

	$('#viewCategoryButton').click(function(){
		//$("#productUpdate").prop("disabled",true);
		event.preventDefault();
		const _value = $('#viewCategory').val();
		if('' == _value){
			
			alert("Enter the category!");
			return false;
		}
		const url = '/productsystem/getProductByCategory?productCategory='+ _value;
			$('#productListTab').DataTable({
				
				'ajax': url,
				'columns':[
					{'data': 'productId'},
					{'data': 'productDesc'},
					{'data': 'unitPrice'},
					{'data': 'quantity'},
					{'data': 'category'},
					{'data': 'productStatus'},
					
				]
			});
	});
	

	$('#viewProductByPriceButton').click(function(){
		//$("#productUpdate").prop("disabled",true);
		event.preventDefault();
		const _value1 = $('#fromPrice').val();
		const _value2 = $('#toPrice').val();
		if('' == _value1){
			
			alert("Enter the from price!");
			return false;
		}
		if('' == _value2){
			
			alert("Enter the To price!");
			return false;
		}
		
		const url = '/productsystem/getProductByPrice?fromPrice='+ _value1+"&toPrice="+_value2;
			$('#productListTab').DataTable({
				
				'ajax': url,
				'columns':[
					{'data': 'productId'},
					{'data': 'productDesc'},
					{'data': 'unitPrice'},
					{'data': 'quantity'},
					{'data': 'category'},
					{'data': 'productStatus'},
					
				]
			});
	});
	

	$('#reset').click(function(event){
		
		$('#productidmsg').html("");
		$("#productdescmsg").html("");
		$("#unitPricemsg").html("");
		$("#categorymsg").html("");
  		$("#quanlificationmsg").html("");
  	   		   		
	});
	
	
	
}); 

package com.ari.shopping.to;

public class OrderItemTO {


	private String productCode ;
	private String productName;
	private double unitPrice ;
	private int qty;
	private double purchasePrice ;

	public OrderItemTO(String code, String name, int qty, double unit, double price) {
		super();
		this.productCode = code;
		this.productName = name;
		this.qty = qty;
		this.unitPrice = unit;
		this.purchasePrice = price;
	}

	public OrderItemTO() {
		// TODO Auto-generated constructor stub
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Override
	public String toString() {
		return "OrderItemTO [productCode=" + productCode + ", productName=" + productName + ", unitPrice=" + unitPrice
				+ ", qty=" + qty + ", purchasePrice=" + purchasePrice + "]";
	}

}

/**
 * 
 */
package com.ari.shopping.to;

import java.io.Serializable;

/**
 * @author power-team
 *
 */
public class ItemForm implements Serializable {
	
	private String code;
	private String name;
	private String qty;
	private String unitPrice;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "\nItemForm [code=" + code + ", qty=" + qty + "]";
	}
	
}

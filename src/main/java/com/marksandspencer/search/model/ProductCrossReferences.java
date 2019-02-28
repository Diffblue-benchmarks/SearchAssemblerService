package com.marksandspencer.search.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductCrossReferences {

	private String ProductExternalID;
	private String productID;
	private String IsServiceValid;
	private String type;
	
	public String getProductExternalID() {
		return ProductExternalID;
	}
	public void setProductExternalID(String productExternalID) {
		ProductExternalID = productExternalID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getIsServiceValid() {
		return IsServiceValid;
	}
	public void setIsServiceValid(String isServiceValid) {
		IsServiceValid = isServiceValid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}

/**
 * 
 */
package com.marksandspencer.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author 1574935
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="productdetails")
public class ProductDetailsDocument {

	@Id
	private String _id;
	private String productId;
	private String productData;
	private String timeStamp;
	
	
	/*
	 * public ProductDetailsDocument(String productId,String Contents) {
	 * this.productId = productId; this.productData = Contents; }
	 */

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}




	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public String getProductData() {
		return productData;
	}


	public void setProductData(String productData) {
		this.productData = productData;
	}


	public String getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


		



}

package com.marksandspencer.search.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Skuchildren {
	private String approvalStatus;
	private String strokeId;
	private String stockIndicator;
	private String productExternalId;
	private Integer price;
	private String name;
	private Integer stockQuantity;
	private Attributes attributes;
	private String id;
	private List<Categories> categories;
	private String productType;
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getStrokeId() {
		return strokeId;
	}
	public void setStrokeId(String strokeId) {
		this.strokeId = strokeId;
	}
	public String getStockIndicator() {
		return stockIndicator;
	}
	public void setStockIndicator(String stockIndicator) {
		this.stockIndicator = stockIndicator;
	}
	public String getProductExternalId() {
		return productExternalId;
	}
	public void setProductExternalId(String productExternalId) {
		this.productExternalId = productExternalId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Categories> getCategories() {
		return categories;
	}
	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}

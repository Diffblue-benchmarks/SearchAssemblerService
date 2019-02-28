package com.marksandspencer.search.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Children {
	private String approvalStatus;
	private List<AssetCrossReferences> assetCrossReferences;
	private String strokeId;
	private List<Skuchildren> children;
	private String productExternalId;
	private String name;
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
	public List<AssetCrossReferences> getAssetCrossReferences() {
		return assetCrossReferences;
	}
	public void setAssetCrossReferences(List<AssetCrossReferences> assetCrossReferences) {
		this.assetCrossReferences = assetCrossReferences;
	}
	public String getStrokeId() {
		return strokeId;
	}
	public void setStrokeId(String strokeId) {
		this.strokeId = strokeId;
	}
	public List<Skuchildren> getChildren() {
		return children;
	}
	public void setChildren(List<Skuchildren> children) {
		this.children = children;
	}
	public String getProductExternalId() {
		return productExternalId;
	}
	public void setProductExternalId(String productExternalId) {
		this.productExternalId = productExternalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

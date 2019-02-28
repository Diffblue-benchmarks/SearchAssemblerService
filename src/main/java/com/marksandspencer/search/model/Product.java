package com.marksandspencer.search.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection = "ProductTable")
@XmlRootElement(name="Product")
public class Product {

	private @Id String _id;
	private String approvalStatus;
	private String strokeId;
	private String isBuyable;
	private String parentId;
	private ProductCrossReferences productCrossReferences;
	private List<AssetCrossReferences> assetCrossReferences;
	private List<Children> children;

	public List<Children> getChildren() {
		return children;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
	}

	private String productExternalId;
//	private String review;
	private String name;
	private Attributes attributes;
	private String id;
	private List<Categories> categories;

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	private String priceRange;
	private String productType;
	private CountriesData countriesData;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

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

	public String getIsBuyable() {
		return isBuyable;
	}

	public void setIsBuyable(String isBuyable) {
		this.isBuyable = isBuyable;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public ProductCrossReferences getProductCrossReferences() {
		return productCrossReferences;
	}
	public void setProductCrossReferences(ProductCrossReferences productCrossReferences) {
		this.productCrossReferences = productCrossReferences;
	}
	public List<AssetCrossReferences> getAssetCrossReferences() {
		return assetCrossReferences;
	}

	public void setAssetCrossReferences(List<AssetCrossReferences> assetCrossReferences) {
		this.assetCrossReferences = assetCrossReferences;
	}

	public String getProductExternalId() {
		return productExternalId;
	}

	public void setProductExternalId(String productExternalId) {
		this.productExternalId = productExternalId;
	}

//	public String getReview() {
//		return review;
//	}
//	public void setReview(String review) {
//		this.review = review;
//	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public CountriesData getCountriesData() {
		return countriesData;
	}

	public void setCountriesData(CountriesData countriesData) {
		this.countriesData = countriesData;
	}

}

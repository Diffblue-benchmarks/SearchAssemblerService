package com.marksandspencer.search.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductDetails")
public class ProductDetails {

	private List<Product> productsList = null;

	public List<Product> getProductsList() {
		return productsList;
	}

	@XmlElement(name = "Product")
	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}
}

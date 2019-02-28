package com.marksandspencer.search.model;

public class GBClass {

	private String eligibleForSale;
    public String getEligibleForSale() {
		return eligibleForSale;
	}
	public void setEligibleForSale(String eligibleForSale) {
		this.eligibleForSale = eligibleForSale;
	}
	public String getMarkedForDelete() {
		return markedForDelete;
	}
	public void setMarkedForDelete(String markedForDelete) {
		this.markedForDelete = markedForDelete;
	}
	private String markedForDelete;
}
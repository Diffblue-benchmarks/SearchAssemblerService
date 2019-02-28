package com.marksandspencer.search.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AssetCrossReferences {
private String assetId;
private String type;
public String getAssetId() {
	return assetId;
}
public void setAssetId(String assetId) {
	this.assetId = assetId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}

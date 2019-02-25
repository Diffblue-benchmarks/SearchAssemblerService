/**
 * 
 */
package com.marksandspencer.search.service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marksandspencer.search.model.ProductDetailsDocument;
import com.marksandspencer.search.repository.ProductDetailsRepository;
import com.marksandspencer.search.util.CSVUtils;
import com.marksandspencer.search.util.SearchUtil;

/**
 * @author 1574935
 *
 */
@Service
public class EnrichService {

	@Autowired
	ProductDetailsRepository PDrepository;

	/**
	 * This method is to create CSV file from given input
	 * 
	 */
	public void createCSV() {
		// Need to integrate CSV calling logic
	}

	/**
	 * Method to save product details into DB
	 * 
	 * @param productData
	 */
	public void createFullFeed(String jsonString) {

		insertProductDetails(jsonString);

		List<ProductDetailsDocument> productDataFromMongo = getProductListFromDb();
		System.out.println(productDataFromMongo);
		try {
			createCsvForProduct(productDataFromMongo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void createCsvForProduct(List<ProductDetailsDocument> productDataFromMongo) throws ClassNotFoundException {
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String sourceCsvPath = "D:\\" + "productCatalog_" + timeStamp + ".csv";
		String sourceZipPath = "D:\\" + "productCatalog_" + timeStamp + ".csv";

		try {
			FileWriter writer = new FileWriter(sourceCsvPath);
			List<String> csvHeader = new ArrayList<String>();
			var list = new ArrayList<String>();
			/*
			 * list.add(productDataFromMongo.getApprovalStatus());
			 * list.add(productDataFromMongo.getStrokeId());
			 * list.add(productDataFromMongo.getIsBuyable());
			 * list.add(productDataFromMongo.getParentId());
			 * Supplier<Stream<AssetCrossReferences>>
			 * coursesDtoList=()->productDataFromMongo.getAssetCrossReferences().stream();
			 * 
			 * list.addAll(coursesDtoList.get().map(AssetCrossReferences::getAssetId).
			 * collect(Collectors.toList()));
			 * list.addAll(coursesDtoList.get().map(AssetCrossReferences::getType).collect(
			 * Collectors.toList()));
			 * 
			 * list.add(productDataFromMongo.getProductExternalId());
			 * list.add(productDataFromMongo.getName());
			 * list.add(productDataFromMongo.getAttributes().getLinkToSizeGuide());
			 * list.add(productDataFromMongo.getAttributes().getCareInstruction1());
			 * list.add(productDataFromMongo.getAttributes().getDisplayAlsoInRangeLink());
			 * list.add(productDataFromMongo.getAttributes().getDeliveryDaysTo());
			 * list.add(productDataFromMongo.getAttributes().
			 * getManualProductReferenceAllowed());
			 * list.add(productDataFromMongo.getAttributes().getAdditionalFeatures());
			 * list.add(productDataFromMongo.getId());
			 * System.out.println("Category Size"+productDataFromMongo.getCategories().size(
			 * )); for(Categories d:productDataFromMongo.getCategories()) {
			 * list.add(d.getMasterCategory().toString()); list.add(d.getName().toString());
			 * } list.add(productDataFromMongo.getPriceRange());
			 * list.add(productDataFromMongo.getProductType());
			 * list.add(productDataFromMongo.getCountriesData().getGB().getEligibleForSale()
			 * );
			 * list.add(productDataFromMongo.getCountriesData().getGB().getMarkedForDelete()
			 * );
			 */

			CSVUtils.writeLine(writer, list);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			// need to handle the exceptions in future
		}

	}

	/**
	 * Method to save product details into DB
	 * 
	 * @param productData
	 */
	private void insertProductDetails(String productData) {
		System.out.println("-----------Insert---------");
		ProductDetailsDocument pd = new ProductDetailsDocument();
		pd.setProductId("P22200535");
		pd.setProductData(productData);
		pd.setTimeStamp(SearchUtil.DateFormat());
		PDrepository.save(pd);

	}

	private List<ProductDetailsDocument> getProductListFromDb() {
		return PDrepository.findAll();

	}

}

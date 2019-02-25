/**
 * 
 */
package com.marksandspencer.search.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marksandspencer.search.dto.ProductDetailsDocument;
import com.marksandspencer.search.repository.ProductDetailsRepository;

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
	public void insertProductDetails(String productData) {

		ProductDetailsDocument pd = new ProductDetailsDocument("P22200535", productData);
		pd.setProductId("P22200535");
		pd.setProductData(productData);
		pd.setTimeStamp(DateFormat());
		PDrepository.save(pd);

	}

	/**
	 * Method to get the current time stamp
	 * 
	 * @return
	 */
	private String DateFormat() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		return dtf.format(now);
	}

}

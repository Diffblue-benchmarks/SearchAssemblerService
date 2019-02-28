/**
 * 
 */
package com.marksandspencer.search.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marksandspencer.search.model.Product;
import com.marksandspencer.search.model.ProductDetails;
import com.marksandspencer.search.model.ProductDetailsDocument;
import com.marksandspencer.search.repository.ProductDetailsRepository;
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
	public void createFullFeed() {

		List<ProductDetailsDocument> productDataFromMongo = getProductListFromDb();
		try {
			createCsvForProduct(productDataFromMongo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void createCsvForProduct(List<ProductDetailsDocument> productDataFromMongo) throws ClassNotFoundException {
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String sourceCsvPath = "D:\\CSVFiles\\" + "productCatalog_" + timeStamp + ".csv";
		String sourceZipPath = "D:\\" + "productCatalog_" + timeStamp + ".csv";
		List<Product> productList = new ArrayList<Product>();
		try {
			FileWriter writer = new FileWriter(sourceCsvPath);
			for (ProductDetailsDocument pd : productDataFromMongo) {

				ObjectMapper mapper = new ObjectMapper();
				Product product = mapper.readValue(pd.getProductData(), Product.class);
				productList.add(product);
			}
			File file = new File("D:\\file.xml");
			ProductDetails detailsToXml = new ProductDetails();
			detailsToXml.setProductsList(productList); 
			JAXBContext jaxbContext= JAXBContext.newInstance(ProductDetails.class); 
			Marshaller jaxbMarshaller =jaxbContext.createMarshaller();
			  
			  // output pretty printed
			  jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			  
			  jaxbMarshaller.marshal(detailsToXml, file);
			  jaxbMarshaller.marshal(detailsToXml, System.out);
			 

		} catch (IOException  |JAXBException e) {
			e.printStackTrace();
			// need to handle the exceptions in future
		}

	}

	/**
	 * Method to save product details into DB
	 * 
	 * @param productData
	 */
	public void insertProductDetails(String productData, String productId) {
		ProductDetailsDocument pd = new ProductDetailsDocument();
		pd.setProductId(productId);
		pd.setProductData(productData);
		pd.setTimeStamp(SearchUtil.DateFormat());
		PDrepository.save(pd);
	}

	private List<ProductDetailsDocument> getProductListFromDb() {
		return PDrepository.findAll();

	}

}

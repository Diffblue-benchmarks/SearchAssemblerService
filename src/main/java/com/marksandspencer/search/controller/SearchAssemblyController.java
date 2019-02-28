package com.marksandspencer.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.marksandspencer.search.dto.ProductIdDto;
import com.marksandspencer.search.service.EnrichService;

/**
 * @author 1574935
 *
 */
@RestController
public class SearchAssemblyController {

	@Value("${api.enrich.productId.rest.url}")
	private String enrichProductApiUrl;

	@Value("${api.product.assembly.url}")
	private String productAssemblyApiUrl;

	@Autowired
	EnrichService enrichService;

	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * Dummy Enrich API which returns product Id.
	 * 
	 * @return
	 */

	@RequestMapping(value = "/dummy/enrich/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<ProductIdDto>> getProductIds() {
		ProductIdDto dto = new ProductIdDto();
		ProductIdDto dto1 = new ProductIdDto();
		dto.setId("P20026490");
		dto1.setId("P60184113");
		List<ProductIdDto> productList = new ArrayList<ProductIdDto>();
		productList.add(dto);
		productList.add(dto1);
		return new ResponseEntity<List<ProductIdDto>>(productList, HttpStatus.OK);

	}

	/**
	 * Service to get the product List
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/create/fullfeed")

	public String getProductList() {
		List<ProductIdDto> productList = new ArrayList<ProductIdDto>();
		productList = restTemplate.getForObject(enrichProductApiUrl, List.class);
		String jsonInString=null;
		// dummy Enriched API to get product Id
	//	for(ProductIdDto id : productList) {
		
			String Url = productAssemblyApiUrl + "P20026490";
			jsonInString = restTemplate.getForObject(Url, String.class);
			enrichService.insertProductDetails(jsonInString,"P20026490" );
	//	}
		enrichService.createFullFeed();

		return jsonInString;
	}

}

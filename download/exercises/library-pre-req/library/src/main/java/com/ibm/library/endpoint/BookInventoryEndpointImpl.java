package com.ibm.library.endpoint;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import com.ibm.library.model.BookData;

@Component
public class BookInventoryEndpointImpl implements BookInventoryEndpoint {

	private RestTemplate restTemplate = new RestTemplate();
	@Value("${bookinventory.endpoint}")
	private String bookInventoryEndpoint;
	
	@Override
	public Collection<BookData> getBooks() {

		Collection<BookData> books = null;
		
		String bookInventoryRESTRequestURL = "http://" + bookInventoryEndpoint + "/bookinventory/books";
		
		BookData[] bookDataArray = this.restTemplate.getForObject(bookInventoryRESTRequestURL, BookData[].class);
		
		if ((bookDataArray != null) && (bookDataArray.length != 0)) {
			books = Arrays.asList(bookDataArray);
		}
		
		return books;
	}

}

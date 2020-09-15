package com.ibm.library.service;

import java.util.Collection;
import com.ibm.library.model.BookData;
import com.ibm.library.endpoint.BookInventoryEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private BookInventoryEndpoint bookInventoryEndpoint;

	public LibraryServiceImpl() {
	}

	@Override
	public Collection<BookData> getBooks() {
		
		Collection<BookData> books = this.bookInventoryEndpoint.getBooks();
		
		return books;
	}
}

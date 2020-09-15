package com.ibm.bookinventory.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bookinventory.model.BookData;
import com.ibm.bookinventory.repo.BookInventoryRepo;

@Service
public class BookInventoryServiceImpl implements BookInventoryService {
	
	@Autowired
	private BookInventoryRepo bookInventoryRepo;
	
	public BookInventoryServiceImpl() {
		
	}
	
	@Override
	public Collection<BookData> getBooks() {
		Collection<BookData> books = this.bookInventoryRepo.getBooks();
		
		return books;
	}

}

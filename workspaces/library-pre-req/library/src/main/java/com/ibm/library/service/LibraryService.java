package com.ibm.library.service;

import java.util.Collection;
import com.ibm.library.model.Book;

public interface LibraryService {
	
	public Collection<Book> getBooks();
}

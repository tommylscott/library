package com.ibm.library.service;

import java.util.Collection;
import java.util.Iterator;

import com.ibm.library.model.Book;
import com.ibm.library.repo.LibraryRepo;
import com.ibm.library.exception.BadValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryRepo libraryRepo;

	public LibraryServiceImpl() {
	}

	@Override
	public Collection<Book> getBooks() {
		
		Collection<Book> books = this.libraryRepo.getBooks();
		
		double lateFee = 0.0;
		int numDaysLate = 0;
		Book book = null;
		Iterator<Book> booksIter = books.iterator();
		while (booksIter.hasNext()) {
			book = booksIter.next();
			if (book.getAuthor().equals("Tom Smith")) {
				book.setAuthor(book.getAuthor() + "- CHECKED");
			}
			
			if (book.getTitle().length() % 2 == 0) {
				numDaysLate = -1 * book.getTitle().length();
			}
			else {
				numDaysLate = book.getTitle().length();
			}
			
			try {
				
				lateFee = book.calculateLateFee(numDaysLate);
				book.setNotes("Fee is " + lateFee);
				
			} catch (BadValue badValue) {
				
				book.setNotes(badValue.getMessage());
				
			}
			
		}
		return books;
	}
}

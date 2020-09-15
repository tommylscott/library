package com.ibm.library.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.library.service.LibraryService;

import java.util.Collection;

import com.ibm.library.model.Book;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class LibraryController
{
	@Autowired
	private LibraryService libraryService;
	
	public LibraryController() {
	}

    @RequestMapping(value = "/books")
	public ResponseEntity<?> getBooks() {
    	Collection<Book> books = this.libraryService.getBooks();
    	ResponseEntity<Collection<Book>> responseEntity = new ResponseEntity<Collection<Book>>(books, HttpStatus.OK); 
		//ResponseEntity gives us the ability to add a response code, so we are going to use Response Entity in class
    	return responseEntity;
	}
}

package com.ibm.library.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.library.service.LibraryService;

import java.util.Collection;

import com.ibm.library.model.BookData;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/library")
public class LibraryController
{
	@Autowired
	private LibraryService libraryService;
	
	public LibraryController() {
	}

    @RequestMapping(value = "/books")
	public ResponseEntity<?> getBooks() {
    	Collection<BookData> books = this.libraryService.getBooks();
    	ResponseEntity<Collection<BookData>> responseEntity = new ResponseEntity<Collection<BookData>>(books, HttpStatus.OK); 
		//ResponseEntity gives us the ability to add a response code, so we are going to use Response Entity in class
    	return responseEntity;
	}
}

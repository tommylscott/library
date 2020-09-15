package com.ibm.bookinventory.repo;

import java.util.Collection;
import java.util.ArrayList;
import com.ibm.bookinventory.model.BookData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

@Component
public class BookInventoryRepoImpl implements BookInventoryRepo {

    @Override
    public Collection<BookData> getBooks() {
    	
    	ArrayList<BookData> books = null;
    	
    	BookData book = null;
    	
    	String fileName = "./src/main/resources/books";
    	File file = new File(fileName);

    	String line;
		String[] bookDataFields = null;
		
    	FileInputStream fis = null;
    	InputStreamReader isr = null;
    	BufferedReader br = null;
    	
		try {
			
	    	fis = new FileInputStream(file);
	    	isr = new InputStreamReader(fis);
	    	br = new BufferedReader(isr);
	    	
	    	while((line = br.readLine()) != null){
	    		
	    		bookDataFields = line.split("\\|");
	    		
	    		book = new BookData(bookDataFields[0], bookDataFields[1], 
	    				            bookDataFields[2], bookDataFields[3]);
	    		
	    	        
	        	if (book != null) {
	        		if (books == null) {
	        			books = new ArrayList<BookData>();
	        		}
	        		books.add(book);
	        	}
	    	}
		} catch (IOException e) {
			// Add processing for errors
		}
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// Add processing for errors
				}
			}
		}

    	return books;
    }
}

package com.klu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.klu.model.Library;

@Service
public class LibraryService {
    private List<Library> librarList = new ArrayList<>();

    public String GetWelcome() {
        return "Welcome to Library";
    }

    public Library createBook(Library library) {
        librarList.add(library);
        return library;
    }

    public Library getByid(int id) {
        for (Library l : librarList) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public int countofbooks() {
        return librarList.size();
    }

    
    public List<String> getAllTitle() {
    	List<String> titles=new ArrayList<>();
    	for(Library l:librarList) {
    		titles.add(l.gettitle());
    	}
    	return titles;
    }
    public String SearchbookbyTitle(String title) {
    	for(Library l:librarList) {
    		if(l.gettitle().equals(title)) {
    			return "Book found";
    		}
    	}
    	return "Book Not Found";
    }
    public double getBookPrice() {
        return 499.99;
    }
    public String authorname(String author) {
    	return "Books author is"+author;
    }
    public List<Library> getAllBooks(){
    	return librarList;
    }
}
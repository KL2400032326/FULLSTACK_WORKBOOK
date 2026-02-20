package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Library;
import com.klu.service.LibraryService;

@RestController
@RequestMapping("/Library")
public class LibraryController {
@Autowired
private LibraryService ls;
@GetMapping("/Greet")
public String GetWelcome() {
	return ls.GetWelcome();
}
@PostMapping("/add")
public Library createBook(Library library) {
    
    return ls.createBook(library);
}
@GetMapping("/detailsByid/{id}")
public Library getByid(@PathVariable int id) {
	return ls.getByid(id);
}
@GetMapping("/TotalBooks")
public int countofbooks() {
	return ls.countofbooks();
}
@GetMapping("/AllTitles")
public List<String> getAllTitle() {
	return ls.getAllTitle();
}
@GetMapping("/bookisthere")
public String SearchbookbyTitle(String title){
	return ls.SearchbookbyTitle(title);
}
@GetMapping("/Sampleprice")
public double getBookPrice() {
    return ls.getBookPrice();
}
@GetMapping("/author")
public String authorname(String author) {
	return "Books author is"+author;
}@GetMapping("/getAllBooks")
public List<Library> getAllBooks(){
	return ls.getAllBooks();
}
}

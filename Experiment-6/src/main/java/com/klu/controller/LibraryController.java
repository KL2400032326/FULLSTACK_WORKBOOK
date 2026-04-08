package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Library;
import com.klu.service.LibraryService;

@RestController
@RequestMapping("/Library")
public class LibraryController {
@Autowired
private LibraryService ls;
@GetMapping("/welcome")
public String GetWelcome() {
	return ls.GetWelcome();
}
@PostMapping("/addbook")  
public Library createBook(@RequestBody Library library) {  
    return ls.createBook(library);
}
@GetMapping("/books/{id}")
public Library getByid(@PathVariable int id) {
	return ls.getByid(id);
}
@GetMapping("/count")
public int countofbooks() {
	return ls.countofbooks();
}
@GetMapping("/viewbooks")
public List<String> getAllTitle() {
	return ls.getAllTitle();
}
@GetMapping("/search/{title}")
public String SearchbookbyTitle(@PathVariable String title){
	return ls.SearchbookbyTitle(title);
}
@GetMapping("/price")
public double getBookPrice() {
    return ls.getBookPrice();
}
@GetMapping("/author/{author}")
public String authorname( @PathVariable String author) {
	return "Books author is"+author;
}
@GetMapping("/ViewBooks")
public List<Library> getAllBooks(){
	return ls.getAllBooks();
}
}

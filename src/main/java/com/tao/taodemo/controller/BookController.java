package com.tao.taodemo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tao.taodemo.model.Book;
import com.tao.taodemo.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
    @GetMapping("/books")
    public List<Book> getAllbooks() {
        return bookService.findAllBooks();
    }
    
    @GetMapping("/books/{id}")
    public Optional<Book> getbookById(@PathVariable("id") UUID bookId) {
        return bookService.findBookById(bookId);
    }
	
}

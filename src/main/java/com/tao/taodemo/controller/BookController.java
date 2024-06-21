package com.tao.taodemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tao.taodemo.model.Book;
import com.tao.taodemo.service.BookService;

@RestController
@CrossOrigin
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

	@PutMapping("/books/borrow")
	public ResponseEntity<Object> borrowBook(@RequestBody Map<String, String> parameter) {
		Map<String, String> resultMap = new HashMap<>();
		String userId = parameter.get("user_id").toString();
		String bookId = parameter.get("book_id").toString();

		try {
			bookService.borrowBook(userId, bookId);
			resultMap.put("message", "Update successful");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(resultMap, HttpStatus.ACCEPTED);
	}

}

package com.tao.taodemo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.taodemo.model.Book;
import com.tao.taodemo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    
    public Optional<Book> findBookById(UUID id) {
        return bookRepository.findById(id);
    }
    
    
}

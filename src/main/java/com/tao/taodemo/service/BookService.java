package com.tao.taodemo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.taodemo.model.AppUser;
import com.tao.taodemo.model.Book;
import com.tao.taodemo.repository.BookRepository;
import com.tao.taodemo.repository.InventoryRepository;
import com.tao.taodemo.repository.UserRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Optional<Book> findBookById(UUID id) {
		return bookRepository.findById(id);
	}

	public void borrowBook(String userId, String bookId) {
		UUID userUUID = UUID.fromString(userId);
		UUID bookUUID = UUID.fromString(bookId);

		Optional<AppUser> userOptional = userRepository.findById(userUUID);

		if (!userOptional.isPresent()) {
			throw new IllegalArgumentException("Invalid user ID: " + userId);
		}
		AppUser user = userOptional.get();

		inventoryRepository.borrowBook(user, bookUUID);
	}

}

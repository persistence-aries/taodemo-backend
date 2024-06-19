package com.tao.taodemo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tao.taodemo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID>{
	
    @Query("SELECT id as id, title as title, author as author, image as image FROM Book  WHERE id = :id ")
	List<Book> findById(@Param("id") String id);
	
	List<Book> findAll();
	
}

package com.tao.taodemo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tao.taodemo.model.AppUser;
import com.tao.taodemo.model.Inventory;

import jakarta.transaction.Transactional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, UUID>{
    
	@Modifying
    @Transactional
    @Query("UPDATE Inventory"
		+  " SET "
		+  " user_id = :user_id "
		+  ", loanDate = CURRENT_TIMESTAMP "
		+  " WHERE id = :book_id ")
	void borrowBook(@Param("user_id") AppUser user_id, @Param("book_id") UUID book_id);
	
	List<Inventory> findAll();
}

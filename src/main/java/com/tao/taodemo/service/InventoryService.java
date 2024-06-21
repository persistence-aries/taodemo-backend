package com.tao.taodemo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.taodemo.model.Inventory;
import com.tao.taodemo.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;
	
	public List<Inventory> findAllInventory() {
		return inventoryRepository.findAll();
	}
	
	public List<Map<String, Object>> getMightLikeBooks() {
		return inventoryRepository.findRecomInventory();
	}
}

package com.wagg.inventory.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wagg.inventory.dto.ProductDto;

public interface ProductService {
	
	public ResponseEntity<List<ProductDto>> getAll();
	public ResponseEntity<String> save(ProductDto dto);

}

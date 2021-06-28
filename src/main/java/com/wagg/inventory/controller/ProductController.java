package com.wagg.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wagg.inventory.dto.ProductDto;
import com.wagg.inventory.service.ProductService;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<ProductDto>> getAll() {
		return service.getAll();
	}
}

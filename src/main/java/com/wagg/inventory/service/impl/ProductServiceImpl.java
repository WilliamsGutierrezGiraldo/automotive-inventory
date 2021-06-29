package com.wagg.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wagg.inventory.dto.ProductDto;
import com.wagg.inventory.mapper.ProductMapper;
import com.wagg.inventory.repository.ProductRepository;
import com.wagg.inventory.repository.entity.ProductEntity;
import com.wagg.inventory.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ResponseEntity<List<ProductDto>> getAll() {
		List<ProductDto> dtos = new ArrayList<>();
		try {
			List<ProductEntity> entities = (List<ProductEntity>) productRepository.findAll();
			for (ProductEntity entity : entities) {
				ProductDto dto = productMapper.entityToDto(entity); 
				dtos.add(dto);
			}
		} catch (NullPointerException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}

	@Override
	public ResponseEntity<String> save(ProductDto dto) {
		try {
			ProductEntity entity = productMapper.dtoToEntity(dto);
			productRepository.save(entity);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("created");
	}

}

package com.wagg.inventory.mapper.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.wagg.inventory.dto.ProductDto;
import com.wagg.inventory.mapper.ProductMapper;
import com.wagg.inventory.repository.entity.ProductEntity;

@Service
public class ProductMapperImpl implements ProductMapper {

	@Override
	public ProductEntity dtoToEntity(ProductDto dto) {
		ProductEntity entity = new ProductEntity();
		// the product is going to be updated
		if (dto.getId() != null) {
			entity.setId(dto.getId());
			entity.setEditionDate(LocalDate.now());
			entity.setEditorUser(null);
			entity.setRegistrationDate(dto.getRegistrationDate());
			entity.setEditionDate(LocalDate.now());
		} else {
			// the product is to be created
			entity.setRegistrationDate(LocalDate.now());
			entity.setRegisterUser(null);
		}
		entity.setName(dto.getName());
		entity.setStock(dto.getStock());
		
		return entity;
	}

	@Override
	public ProductDto entityToDto(ProductEntity entity) {
		ProductDto dto = new ProductDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setStock(entity.getStock());
		dto.setRegistrationDate(entity.getRegistrationDate());
		dto.setEditionDate(entity.getEditionDate());
		dto.setRegisterUser(entity.getRegisterUser().getId());
		dto.setEditorUser(entity.getEditorUser().getId());
		
		return dto;
	}

}

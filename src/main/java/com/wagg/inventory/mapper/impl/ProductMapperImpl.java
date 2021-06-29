package com.wagg.inventory.mapper.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wagg.inventory.dto.ProductDto;
import com.wagg.inventory.mapper.ProductMapper;
import com.wagg.inventory.repository.UserRepository;
import com.wagg.inventory.repository.entity.ProductEntity;
import com.wagg.inventory.repository.entity.UserEntity;

@Service
public class ProductMapperImpl implements ProductMapper {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public ProductEntity dtoToEntity(ProductDto dto) {
		ProductEntity entity = new ProductEntity();
		try {
			// the product is going to be updated
			if (dto.getId() != null) {
				entity.setId(dto.getId());
				entity.setEditionDate(LocalDate.now());
				entity.setEditorUser(getUser(dto.getEditorUser()));
				entity.setRegistrationDate(dto.getRegistrationDate());
				entity.setEditionDate(LocalDate.now());
			} else {
				// the product is to be created
				entity.setRegistrationDate(LocalDate.now());
			}
			entity.setName(dto.getName());
			entity.setStock(dto.getStock());
			entity.setRegisterUser(getUser(dto.getRegisterUser()));
			
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new IllegalArgumentException("user not found");
		}
		
		return entity;
	}

	@Override
	public ProductDto entityToDto(ProductEntity entity) {
		ProductDto dto = new ProductDto();
		try {
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setStock(entity.getStock());
			dto.setRegistrationDate(entity.getRegistrationDate());
			dto.setEditionDate(entity.getEditionDate());
			dto.setRegisterUser(entity.getRegisterUser().getId());
			if (entity.getEditorUser() != null) {
				dto.setEditorUser(entity.getEditorUser().getId() != null ? entity.getEditorUser().getId() : null);
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			throw new NullPointerException("mandatory fields not reported");
		}
		
		return dto;
	}
	
	private UserEntity getUser(Long id) { 
		Optional<UserEntity> op = null;
		try {
			op = userRepository.findById(id);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new IllegalArgumentException("user not found");
		}
		return op.isPresent() ? op.get() : null;
	}

}

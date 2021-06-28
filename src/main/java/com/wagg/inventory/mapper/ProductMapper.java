package com.wagg.inventory.mapper;

import com.wagg.inventory.dto.ProductDto;
import com.wagg.inventory.repository.entity.ProductEntity;

public interface ProductMapper {
	
	public ProductEntity dtoToEntity(ProductDto dto) throws IllegalArgumentException;
	public ProductDto entityToDto(ProductEntity entity) throws NullPointerException;

}

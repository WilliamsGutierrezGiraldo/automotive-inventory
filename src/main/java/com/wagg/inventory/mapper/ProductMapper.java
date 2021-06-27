package com.wagg.inventory.mapper;

import com.wagg.inventory.dto.ProductDto;
import com.wagg.inventory.repository.entity.ProductEntity;

public interface ProductMapper {
	
	public ProductEntity dtoToEntity(ProductDto dto);
	public ProductDto entityToDto(ProductEntity entity);

}

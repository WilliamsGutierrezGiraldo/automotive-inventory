package com.wagg.inventory.mapper;

import com.wagg.inventory.dto.UserDto;
import com.wagg.inventory.repository.entity.UserEntity;

public interface UserMapper {
	
	public UserDto entityToDto(UserEntity entity) throws NullPointerException;

}

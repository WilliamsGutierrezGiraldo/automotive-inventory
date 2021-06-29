package com.wagg.inventory.mapper.impl;

import org.springframework.stereotype.Service;

import com.wagg.inventory.dto.UserDto;
import com.wagg.inventory.mapper.UserMapper;
import com.wagg.inventory.repository.entity.UserEntity;

@Service
public class UserMapperImpl implements UserMapper {
	
	@Override
	public UserDto entityToDto(UserEntity entity) {
		UserDto dto = new UserDto();
		try {
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setLastname(entity.getLastname());
			dto.setBirthDate(entity.getBirthDate());
			dto.setPositionId(entity.getPosition().getId());
			dto.setJoiningDate(entity.getJoiningDate());
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			throw new NullPointerException("mandatory fields not reported");
		}
		return dto;
	}

}

package com.wagg.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wagg.inventory.dto.UserDto;
import com.wagg.inventory.mapper.UserMapper;
import com.wagg.inventory.repository.UserRepository;
import com.wagg.inventory.repository.entity.UserEntity;
import com.wagg.inventory.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public ResponseEntity<List<UserDto>> getAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		try {
			List<UserEntity> entities = (List<UserEntity>) userRepository.findAll();
			for (UserEntity userEntity : entities) {
				UserDto dto = userMapper.entityToDto(userEntity);
				dtos.add(dto);
			}
			
		} catch (NullPointerException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}

}

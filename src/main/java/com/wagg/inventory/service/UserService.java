package com.wagg.inventory.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wagg.inventory.dto.UserDto;

public interface UserService {
	
	public ResponseEntity<List<UserDto>> getAll();

}

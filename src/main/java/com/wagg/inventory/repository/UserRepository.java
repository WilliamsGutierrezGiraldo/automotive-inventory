package com.wagg.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wagg.inventory.repository.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}

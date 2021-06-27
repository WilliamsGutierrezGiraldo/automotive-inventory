package com.wagg.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wagg.inventory.repository.entity.PositionEntity;

@Repository
public interface PositionRepository extends CrudRepository<PositionEntity, Long> {

}

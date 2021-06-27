package com.wagg.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wagg.inventory.repository.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}

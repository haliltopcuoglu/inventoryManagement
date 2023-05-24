package com.inventory.inventoryManagement.repository;

import com.inventory.inventoryManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

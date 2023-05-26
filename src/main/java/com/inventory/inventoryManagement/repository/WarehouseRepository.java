package com.inventory.inventoryManagement.repository;

import com.inventory.inventoryManagement.entity.Product;
import com.inventory.inventoryManagement.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    List<Warehouse> findByProducts(Product product);

}

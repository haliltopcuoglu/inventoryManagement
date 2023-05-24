package com.inventory.inventoryManagement.repository;

import com.inventory.inventoryManagement.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}

package com.inventory.inventoryManagement.repository;

import com.inventory.inventoryManagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

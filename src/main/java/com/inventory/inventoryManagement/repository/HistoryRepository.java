package com.inventory.inventoryManagement.repository;

import com.inventory.inventoryManagement.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {
}

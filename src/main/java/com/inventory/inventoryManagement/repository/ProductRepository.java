package com.inventory.inventoryManagement.repository;

import com.inventory.inventoryManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p join  p.warehouse r where r.name = :warehouseName ")
    List<Product> findByWarehouseName(String warehouseName);
    @Query("select p from Product p join  p.warehouse r where r.region = :region ")
    List<Product> findByWarehouseRegion(String region);
    @Query("select p from Product p join  p.warehouse r where r.city = :city ")
    List<Product> findByWarehouseCity(String city);
    @Query("select p from Product p join p.category c where c.name = :categoryName")
    List<Product> findAllByCategory(@Param(value = "categoryName") String categoryName);


}

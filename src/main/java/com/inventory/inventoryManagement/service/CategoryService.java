package com.inventory.inventoryManagement.service;

import com.inventory.inventoryManagement.entity.Category;
import com.inventory.inventoryManagement.repository.CategoryRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

}

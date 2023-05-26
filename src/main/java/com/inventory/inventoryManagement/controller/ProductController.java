package com.inventory.inventoryManagement.controller;

import com.inventory.inventoryManagement.entity.Product;
import com.inventory.inventoryManagement.entity.Warehouse;
import com.inventory.inventoryManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Read - Add - Upadte - Delete operations
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    // product search
    @GetMapping("/searchProduct/{productId}")
    public List<Warehouse> getWarehousesByProductId(@PathVariable Integer productId){
        return productService.getWarehousesByProduct(productId);
    }

    // filtered products results
    @GetMapping("/filterByWarehouseName")
    public List<Product> getProductsByWarehouseName(@RequestParam(value = "warehouseName") String warehouseName){
        return productService.filterByWarehouse(warehouseName);
    }
    @GetMapping("/filterByCity")
    public List<Product> getProductsByWarehouseCity(@RequestParam(value = "city") String city){
        return productService.filterByWarehouseCity(city);
    }
    @GetMapping("/filterByRegion")
    public List<Product> getProductsByWarehouseRegion(@RequestParam(value = "region") String region){
        return productService.filterByWarehouseRegion(region);
    }
    @GetMapping("/filterByCategory")
    public List<Product> getProductsByCategory(@RequestParam(value = "category") String categoryName){
        return productService.filterByCategory(categoryName);
    }
}

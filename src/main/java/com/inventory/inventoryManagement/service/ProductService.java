package com.inventory.inventoryManagement.service;

import com.inventory.inventoryManagement.entity.Category;
import com.inventory.inventoryManagement.entity.History;
import com.inventory.inventoryManagement.entity.Product;
import com.inventory.inventoryManagement.entity.Warehouse;
import com.inventory.inventoryManagement.repository.HistoryRepository;
import com.inventory.inventoryManagement.repository.ProductRepository;
import com.inventory.inventoryManagement.repository.WarehouseRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {
    protected static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final HistoryRepository historyRepository;
    private final WarehouseRepository warehouseRepository;


    @Autowired
    public ProductService(ProductRepository productRepository, HistoryRepository historyRepository, WarehouseRepository warehouseRepository) {
        this.productRepository = productRepository;
        this.historyRepository = historyRepository;
        this.warehouseRepository = warehouseRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product addProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        saveToHistory(savedProduct, "product_added");
        return savedProduct;
    }

    public Product updateProduct(Integer id, Product product) {
        Product updatedProduct = productRepository.save(product);

        if (productRepository.existsById(id)) {
            product.setId(id);
            saveToHistory(updatedProduct, "product_updated");
            if (product.getQuantity() < product.getCriticalQuantity()){
                logger.warn("Critical product quantity reached.");
                return updatedProduct;
            }
            return updatedProduct;
        } else {
            throw new RuntimeException("Product cannot found with given id: " + id);
        }
    }
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.deleteById(id);
            saveToHistory(product, "product_deleted");
        }
    }

    // saving operations to history table
    private void saveToHistory(Product product, String operation) {
        History history = new History();
        history.setProductId(product.getId());
        history.setDateTime(LocalDateTime.now());
        history.setOperation(operation);
        historyRepository.save(history);
    }

    // filtering products
    public List<Product> filterByWarehouse(String warehouseName){
        return productRepository.findByWarehouseName(warehouseName);
    }
    public List<Product> filterByWarehouseRegion(String region){
        return productRepository.findByWarehouseRegion(region);
    }
    public List<Product> filterByWarehouseCity(String city){
        return productRepository.findByWarehouseCity(city);
    }
    public List<Product> filterByCategory(String categoryName){
        Category category = new Category();
        category.setName(categoryName);
        return productRepository.findAllByCategory(categoryName);
    }
    public List<Warehouse> getWarehousesByProduct(Integer productId){
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null)
            return warehouseRepository.findByProducts(product);
        return new ArrayList<>();
    }
}

package product_maintenance.service;

import java.util.List;

import product_maintenance.entity.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    Product getProductById(String id);
    Product updateProduct(Product product);
    void deleteProductById(String id);
}
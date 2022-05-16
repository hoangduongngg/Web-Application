package product_maintenance.service;

import lombok.AllArgsConstructor;
import product_maintenance.entity.Product;
import product_maintenance.repository.ProductRepository;
import product_maintenance.service.ProductService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplement implements ProductService {

    private final ProductRepository productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(String id) {
        if (productRepo.findById(id).isEmpty())
            return null;
        return productRepo.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProductById(String id) {
        productRepo.deleteById(id);
    }
}
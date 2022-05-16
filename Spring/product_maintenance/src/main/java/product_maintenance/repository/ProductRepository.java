package product_maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import product_maintenance.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
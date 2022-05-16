package product_maintenance.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force=true)
@Entity
public class Product {
    @Id
    private String id;
    private String description;
    private double price;

    public Product(String id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }
}
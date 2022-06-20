/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hoangduongngg
 */
public class Product {
    private Integer id;
    private String name;
    private String des;
    private float price;

    public Product() {
    }

    
    public Product(Integer id, String name, String des, float price) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", des=" + des + ", price=" + price + '}';
    }
    
    
}

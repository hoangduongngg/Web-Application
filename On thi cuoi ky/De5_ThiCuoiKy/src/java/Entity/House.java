/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hoangduongngg
 */
public class House {
    private String id ;
    private String address ; 
    private Integer area ;
    private String type;
    private Integer approved ;

    public House() {
    }

    public House(String id, String address, Integer area, String type, Integer approved) {
        this.id = id;
        this.address = address;
        this.area = area;
        this.type = type;
        this.approved = approved;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Integer getArea() {
        return area;
    }

    public String getType() {
        return type;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "House{" + "id=" + id + ", address=" + address + ", area=" + area + ", type=" + type + ", approved=" + approved + '}';
    }
    
    
}

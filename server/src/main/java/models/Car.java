package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
    
    @Id
    private Integer id;
    private String brand;
    private String model;

    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

}

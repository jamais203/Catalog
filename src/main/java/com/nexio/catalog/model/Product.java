package com.nexio.catalog.model;



import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="price")
    private Double price;
    @Column(name="description")
    private String description;

    public Product(){

    }

    public Product(Long id, String title, Double price, String description){
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
    }


    /*
    =================================================================
                        GETTERS & SETTERS
    =================================================================
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
    =================================================================
                       EQUALS & HASHCODE
    =================================================================
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) &&
                getTitle().equals(product.getTitle()) &&
                getPrice().equals(product.getPrice()) &&
                getDescription().equals(product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPrice(), getDescription());
    }
}

package com.triplepack.cable.query;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Cable {
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private Boolean hasDiscount;

    public Cable() {
        // Required by MongoDB?
    }

    private Cable(String id, String name, String description, Double price, Boolean hasDiscount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.hasDiscount = hasDiscount;
    }

    public static Cable createCable(String id, String name, String description, Double price, Boolean hasDiscount) {
        return new Cable(id, name, description, price, hasDiscount);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getHasDiscount() {
        return hasDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cable cable = (Cable) o;
        return Objects.equals(id, cable.id) &&
                Objects.equals(name, cable.name) &&
                Objects.equals(description, cable.description) &&
                Objects.equals(price, cable.price) &&
                Objects.equals(hasDiscount, cable.hasDiscount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, price, hasDiscount);
    }

    @Override
    public String toString() {
        return "cable{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", hasDiscount=" + hasDiscount +
                '}';
    }
}

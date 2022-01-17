package com.caiorib.spring.course.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "PRODUCT")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDT_PRODUCT")
    private Long id;

    @Column(name="DES_NAME")
    private String name;

    @Column(name="DES_PRICE")
    private String price;

    @ManyToMany
    @JoinTable(name="CATEGORY_PRODUCT",
            joinColumns = @JoinColumn(name = "IDT_PRODUCT"),
            inverseJoinColumns = @JoinColumn(name = "IDT_CATEGORY")
    )
    private List<CategoryEntity> categories;

    public ProductEntity(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;

        this.categories = new ArrayList<>();

    }

    public ProductEntity() {
        this.categories = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

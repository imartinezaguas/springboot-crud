package com.andres.curso.springboot.app.springbootcrud.entities;

import com.andres.curso.springboot.app.springbootcrud.validation.IsRequired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.parameters.P;

import javax.lang.model.element.Name;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @IsRequired(message = "{IsRequired.product.name}")
    @Size(min=3, max=20)
    private String name;
    
    @Min(value = 500, message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private Integer price;

    @IsRequired
    private String precioPorMoneda;

    @IsRequired
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private Company company;


    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categori_id")
    @JsonBackReference
    @JsonProperty("categori_id")
    private Categories categories;*/


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
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrecioPorMoneda() {
        return precioPorMoneda;
    }
    public void setPrecioPorMoneda(String precioPorMoneda) {
        this.precioPorMoneda = precioPorMoneda;
    }

    public Long getCompanyId() {
        return company.getNit();
    }

    /*
    public Long getCategoriesId() {
        return categories.getId();
    }

    public void setCategoriesId(Long categoriesId) {
        this.categories.setId(categoriesId);
    }*/
}

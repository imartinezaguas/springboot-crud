package com.andres.curso.springboot.app.springbootcrud.entities;

import com.andres.curso.springboot.app.springbootcrud.validation.IsRequired;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nit;

    @IsRequired
    private String name;
    @IsRequired
    private String address;
    @IsRequired
    private String phone;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL )
    @JsonManagedReference
    //@JsonBackReference
    private List<Product> productos;

    public Company() {
        this.productos = new ArrayList<>();
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }
}

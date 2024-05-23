package com.andres.curso.springboot.app.springbootcrud.entities;

import com.andres.curso.springboot.app.springbootcrud.validation.IsRequired;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsRequired
    private String name;

    @IsRequired
    private Date fecha;

    /*
    @OneToMany(mappedBy = "categories",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products;*/   


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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

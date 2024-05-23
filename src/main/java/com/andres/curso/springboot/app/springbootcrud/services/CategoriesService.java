package com.andres.curso.springboot.app.springbootcrud.services;

import com.andres.curso.springboot.app.springbootcrud.entities.Categories;
import com.andres.curso.springboot.app.springbootcrud.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {

    List<Categories> findAll();

    Optional<Categories> findById(Long id);

    Categories save(Categories categories);

    Optional<Categories> update(Long id, Categories categories);

    Optional<Categories> delete(Long id);

}

package com.andres.curso.springboot.app.springbootcrud.services;

import com.andres.curso.springboot.app.springbootcrud.entities.Categories;
import com.andres.curso.springboot.app.springbootcrud.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesImpl implements CategoriesService{

    @Autowired
    private CategoriesRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Categories> findAll() {
        return (List<Categories>) repository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Categories> findById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    @Override
    public Categories save(Categories categories) {
        return repository.save(categories);
    }

    @Transactional
    @Override
    public Optional<Categories> update(Long id, Categories categories) {
        Optional<Categories> categoriesOptional = repository.findById(id);

        if (categoriesOptional.isPresent()) {
            Categories categoriesDb = categoriesOptional.orElseThrow();
            categoriesDb.setName(categories.getName());
            categoriesDb.setFecha((categories.getFecha()));
            return Optional.of(repository.save(categoriesDb));

        }

        return categoriesOptional;
    }

    @Transactional
    @Override
    public Optional<Categories> delete(Long id) {
        Optional<Categories> categoriesOptional = repository.findById(id);
        categoriesOptional.ifPresent(categoriesDb -> {
            repository.delete(categoriesDb);
        } );
        return categoriesOptional;
    }
}

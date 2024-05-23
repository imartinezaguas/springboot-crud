package com.andres.curso.springboot.app.springbootcrud.services;

import com.andres.curso.springboot.app.springbootcrud.entities.Company;
import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> findAll();

    Optional<Company> findById(Long id);

    Company save(Company company);

    Optional<Company> update(Long id, Company company);

    Optional<Company> delete(Long id);
}

package com.andres.curso.springboot.app.springbootcrud.services;

import com.andres.curso.springboot.app.springbootcrud.entities.Company;
import com.andres.curso.springboot.app.springbootcrud.entities.Product;
import com.andres.curso.springboot.app.springbootcrud.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Company> findAll() {
        return (List<Company>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Company> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Company save(Company company) {
        return repository.save(company);
    }

    @Transactional
    @Override
    public Optional<Company> update(Long id, Company company) {

        Optional<Company> companyOptional = repository.findById(id);

        if (companyOptional.isPresent()) {
            Company companyDb = companyOptional.orElseThrow();
            companyDb.setName(company.getName());
            companyDb.setAddress((company.getAddress()));
            companyDb.setPhone(company.getPhone());
            return Optional.of(repository.save(companyDb));

        }

        return companyOptional;
    }

    @Transactional
    @Override
    public Optional<Company> delete(Long id) {
        Optional<Company> companyOptional = repository.findById(id);
        companyOptional.ifPresent(companyDb -> {
            repository.delete(companyDb);
        } );
        return companyOptional;
    }
}

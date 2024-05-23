package com.andres.curso.springboot.app.springbootcrud.controllers;

import com.andres.curso.springboot.app.springbootcrud.entities.Company;
import com.andres.curso.springboot.app.springbootcrud.entities.Product;
import com.andres.curso.springboot.app.springbootcrud.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public List<Company> list() {
        return service.findAll();

    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody Company company, BindingResult result) {

        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(company));
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Company> companytOptional = service.findById(id);
        if (companytOptional.isPresent()) {
            return ResponseEntity.ok(companytOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Company company, BindingResult result, @PathVariable Long id) {

        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<Company> companyOptional = service.update(id, company);
        if (companyOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(companyOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Company> companyOptional = service.delete(id);
        if (companyOptional.isPresent()) {
            return ResponseEntity.ok(companyOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}

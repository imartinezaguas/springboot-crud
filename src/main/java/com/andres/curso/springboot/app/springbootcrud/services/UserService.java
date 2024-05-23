package com.andres.curso.springboot.app.springbootcrud.services;

import java.util.List;
import java.util.Optional;

import com.andres.curso.springboot.app.springbootcrud.entities.Product;
import com.andres.curso.springboot.app.springbootcrud.entities.User;

public interface UserService {

    Optional<User> findById(Long id);

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}

package com.example.emtlab2_springboot_react.service.impl;

import com.example.emtlab2_springboot_react.model.Author;
import com.example.emtlab2_springboot_react.model.Country;
import com.example.emtlab2_springboot_react.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public Author create(String name, String surname, Country country) {
        return null;
    }

    @Override
    public Author update(String name, String surname, Country country) {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Author> listAll() {
        return null;
    }

    @Override
    public List<Author> GetAuthorByCountry() {
        return null;
    }

    @Override
    public List<Author> GetAuthorByNameAndSurname(String name, String surname) {
        return null;
    }
}

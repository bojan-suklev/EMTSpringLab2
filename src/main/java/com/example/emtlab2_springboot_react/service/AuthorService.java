package com.example.emtlab2_springboot_react.service;

import com.example.emtlab2_springboot_react.model.Author;
import com.example.emtlab2_springboot_react.model.Country;

import java.util.List;

public interface AuthorService {
    Author create(String name, String surname, Country country);
    Author update(String name,String surname,Country country);
    void delete(String name);
    List<Author> listAll();
    List<Author> GetAuthorByCountry();
    List<Author> GetAuthorByNameAndSurname(String name,String surname);
}

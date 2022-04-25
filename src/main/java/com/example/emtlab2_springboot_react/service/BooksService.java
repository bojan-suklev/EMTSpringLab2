package com.example.emtlab2_springboot_react.service;

import com.example.emtlab2_springboot_react.model.Author;
import com.example.emtlab2_springboot_react.model.Books;
import com.example.emtlab2_springboot_react.model.enumerations.BookEnum;

import java.util.List;


public interface BooksService {
    Books create(String name, BookEnum category, Author author, Integer avCopies);
    Books update(String name, BookEnum category, Author author, Integer avCopies);
    void delete(String name,BookEnum category,Author author);
    List<Books> listAll();
}

package com.example.emtlab2_springboot_react.service.impl;

import com.example.emtlab2_springboot_react.model.Author;
import com.example.emtlab2_springboot_react.model.Books;
import com.example.emtlab2_springboot_react.model.enumerations.BookEnum;
import com.example.emtlab2_springboot_react.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Override
    public Books create(String name, BookEnum category, Author author, Integer avCopies) {
        return null;
    }

    @Override
    public Books update(String name, BookEnum category, Author author, Integer avCopies) {
        return null;
    }

    @Override
    public void delete(String name, BookEnum category, Author author) {

    }

    @Override
    public List<Books> listAll() {
        return null;
    }
}

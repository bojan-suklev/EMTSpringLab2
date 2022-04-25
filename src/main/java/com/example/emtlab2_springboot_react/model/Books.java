package com.example.emtlab2_springboot_react.model;

import com.example.emtlab2_springboot_react.model.enumerations.BookEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BookEnum category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;
    public Books(){

    }

    public Books(String name, BookEnum category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}

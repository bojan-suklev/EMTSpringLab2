package com.example.emtlab2_springboot_react.web.REST;

import com.example.emtlab2_springboot_react.model.Author;
import com.example.emtlab2_springboot_react.model.Books;
import com.example.emtlab2_springboot_react.model.enumerations.BookEnum;
import com.example.emtlab2_springboot_react.service.BooksService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://emtlab2frontendreact.herokuapp.com")
@RequestMapping("/api/books")
public class BooksRestController {
    private final BooksService booksService;

    public BooksRestController(BooksService booksService) {
        this.booksService = booksService;
    }
    @GetMapping
    private List<Books> findAll(){
        return this.booksService.listAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.booksService.delete(id);
        if(this.booksService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/add")
    public ResponseEntity<Books> add(@RequestBody ObjectNode objectNode){
        String name = objectNode.get("name").asText();
        String category1 = objectNode.get("category").asText();
        BookEnum category=BookEnum.valueOf(category1);
        Long author=objectNode.get("author").asLong();
        Integer avCopies=objectNode.get("avCopies").asInt();
        return this.booksService.create(name,category,author,avCopies).map(books -> ResponseEntity.ok().body(books)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Books> edit(@PathVariable Long id,@RequestBody ObjectNode objectNode){
        String name = objectNode.get("name").asText();
        String category1 = objectNode.get("category").asText();
        BookEnum category=BookEnum.valueOf(category1);
        Long author=objectNode.get("author").asLong();
        Integer avCopies=objectNode.get("avCopies").asInt();
        return this.booksService.update(id,name,category,author,avCopies).map(books -> ResponseEntity.ok().body(books)).orElseGet(() -> ResponseEntity.badRequest().build());

    }
}

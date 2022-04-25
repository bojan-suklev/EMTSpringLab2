package com.example.emtlab2_springboot_react.web.REST;

import com.example.emtlab2_springboot_react.model.Author;
import com.example.emtlab2_springboot_react.model.Books;
import com.example.emtlab2_springboot_react.model.enumerations.BookEnum;
import com.example.emtlab2_springboot_react.service.AuthorService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://emtlab2backendspring.herokuapp.com/")
@RequestMapping("/api/author")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    private List<Author> findAll(){
        return this.authorService.listAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.authorService.delete(id);
        if(this.authorService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/add")
    public ResponseEntity<Author> add(@RequestBody ObjectNode objectNode){
        String name = objectNode.get("name").asText();
        String surname = objectNode.get("surname").asText();
        Long country = objectNode.get("country").asLong();
        return this.authorService.create(name,surname,country).map(authors -> ResponseEntity.ok().body(authors)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> edit(@PathVariable Long id,@RequestBody ObjectNode objectNode){
        String name = objectNode.get("name").asText();
        String surname = objectNode.get("surname").asText();
        Long country = objectNode.get("country").asLong();
        return this.authorService.update(id,name,surname,country).map(authors -> ResponseEntity.ok().body(authors)).orElseGet(() -> ResponseEntity.badRequest().build());

    }
}

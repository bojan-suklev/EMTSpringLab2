package com.example.emtlab2_springboot_react.web.REST;

import com.example.emtlab2_springboot_react.model.Books;
import com.example.emtlab2_springboot_react.model.Country;
import com.example.emtlab2_springboot_react.model.enumerations.BookEnum;
import com.example.emtlab2_springboot_react.service.CountryService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://emtlab2frontendreact.herokuapp.com")
@RequestMapping("/api/country")
public class CountryRestController {
    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    private List<Country> findAll(){
        return this.countryService.listAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.countryService.delete(id);
        if(this.countryService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/add")
    public ResponseEntity<Country> add(@RequestBody ObjectNode objectNode){
        String name = objectNode.get("name").asText();
        String continent = objectNode.get("continent").asText();
        return this.countryService.create(name,continent).map(country -> ResponseEntity.ok().body(country)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> edit(@PathVariable Long id, @RequestBody ObjectNode objectNode){
        String name = objectNode.get("name").asText();
        String continent = objectNode.get("continent").asText();
        return this.countryService.edit(id,name,continent).map(country -> ResponseEntity.ok().body(country)).orElseGet(() -> ResponseEntity.badRequest().build());

    }
}

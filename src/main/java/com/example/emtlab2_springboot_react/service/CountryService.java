package com.example.emtlab2_springboot_react.service;

import com.example.emtlab2_springboot_react.model.Country;

import java.util.List;

public interface CountryService {
    Country crate(String name, String continent);
    Country update(String name,String continent);
    void delete(String name);
    List<Country> listAll();
    List<Country> findByName(String name);
}

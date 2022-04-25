package com.example.emtlab2_springboot_react.service.impl;

import com.example.emtlab2_springboot_react.model.Country;
import com.example.emtlab2_springboot_react.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Override
    public Country crate(String name, String continent) {
        return null;
    }

    @Override
    public Country update(String name, String continent) {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Country> listAll() {
        return null;
    }

    @Override
    public List<Country> findByName(String name) {
        return null;
    }
}

package com.example.emtlab2_springboot_react.repository;

import com.example.emtlab2_springboot_react.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Long, Country> {
}

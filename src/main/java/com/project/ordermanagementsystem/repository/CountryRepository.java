package com.project.ordermanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ordermanagementsystem.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}

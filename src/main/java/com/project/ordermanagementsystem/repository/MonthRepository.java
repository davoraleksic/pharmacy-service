package com.project.ordermanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ordermanagementsystem.model.Month;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long> {

}

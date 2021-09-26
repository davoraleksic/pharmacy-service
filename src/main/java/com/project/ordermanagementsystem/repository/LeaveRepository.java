package com.project.ordermanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ordermanagementsystem.model.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
	

}

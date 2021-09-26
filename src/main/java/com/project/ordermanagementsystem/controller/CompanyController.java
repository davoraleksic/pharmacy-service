package com.project.ordermanagementsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ordermanagementsystem.exception.ResourceNotFoundException;
import com.project.ordermanagementsystem.model.Company;
import com.project.ordermanagementsystem.repository.CompanyRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CompanyController {
	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping("/companies")
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	
	@GetMapping("/companies/{id}")
	public ResponseEntity<Company> getEmployeeById(@PathVariable(value = "id") Long companyId)
			throws ResourceNotFoundException {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
		return ResponseEntity.ok().body(company);
	}

	@PostMapping("/companies")
	public Company createCompany(@Valid @RequestBody Company company) {
		return companyRepository.save(company);
	}

	@PutMapping("/companies/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable(value = "id") Long companyId,
			@Valid @RequestBody Company companyDetails) throws ResourceNotFoundException {
		final Company updatedCompany = companyRepository.save(companyDetails);
		return ResponseEntity.ok(updatedCompany);
	}

	@DeleteMapping("/companies/{id}")
	public Map<String, Boolean> deleteCompany(@PathVariable(value = "id") Long companyId)
			throws ResourceNotFoundException {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));

		companyRepository.delete(company);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

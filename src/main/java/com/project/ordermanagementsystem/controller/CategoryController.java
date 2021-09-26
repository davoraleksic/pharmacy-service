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
import com.project.ordermanagementsystem.model.Category;
import com.project.ordermanagementsystem.repository.CategoryRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/categories")
	public List<Category> getAllCompanies() {
		return categoryRepository.findAll();
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getEmployeeById(@PathVariable(value = "id") Long categoryId)
			throws ResourceNotFoundException {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));
		return ResponseEntity.ok().body(category);
	}

	@PostMapping("/categories")
	public Category createCategory(@Valid @RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryId,
			@Valid @RequestBody Category categoryDetails) throws ResourceNotFoundException {
		final Category updatedCategory = categoryRepository.save(categoryDetails);
		return ResponseEntity.ok(updatedCategory);
	}	

	@DeleteMapping("/categories/{id}")
	public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryId)
			throws ResourceNotFoundException {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

		categoryRepository.delete(category);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

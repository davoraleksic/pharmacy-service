package com.project.ordermanagementsystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
import com.project.ordermanagementsystem.model.Product;
import com.project.ordermanagementsystem.model.Leave;
import com.project.ordermanagementsystem.repository.LeaveRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class LeaveController {
	@Autowired
	private LeaveRepository leaveRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	@GetMapping("/leaves")
	public List<Leave> getAllLeaves() {
		return leaveRepository.findAll();
	}
	
	@GetMapping("/leaves/all-leaves")
	public ArrayList getAllLeaveFields() {
		 Query q = entityManager.createQuery("SELECT emp, lv from leaves lv, product emp WHERE product_id = leave_product_id");
		 List<Object[]> leave = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : leave ) {
			  Leave leave_details = (Leave)row[ 1 ];
			  Product product_details = (Product)row[ 0 ];
			  
			    HashMap<String, String> results = new HashMap();
			    results.put("leave_id",String.valueOf(leave_details.getLeave_id()));
				results.put("leave_reason",leave_details.getLeave_reason());
				results.put("leave_description",leave_details.getLeave_description());
				results.put("leave_from_date",leave_details.getLeave_from_date());
				results.put("leave_to_date",leave_details.getLeave_to_date());
				results.put("leave_status",leave_details.getLeave_status());

			    
			    resultArray.add(results);
			 
		 }	 

        return resultArray;
	}
	
	@GetMapping("/leaves/{id}")
	public ResponseEntity<Leave> getEmployeeById(@PathVariable(value = "id") Long leaveId)
			throws ResourceNotFoundException {
		Leave leave = leaveRepository.findById(leaveId)
				.orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id :: " + leaveId));
		return ResponseEntity.ok().body(leave);
	}

	@PostMapping("/leaves")
	public Leave createLeave(@Valid @RequestBody Leave leave) {
		return leaveRepository.save(leave);
	}

	@PutMapping("/leaves/{id}")
	public ResponseEntity<Leave> updateLeave(@PathVariable(value = "id") Long leaveId,
			@Valid @RequestBody Leave leaveDetails) throws ResourceNotFoundException {
		final Leave updatedLeave = leaveRepository.save(leaveDetails);
		return ResponseEntity.ok(updatedLeave);
	}

	@DeleteMapping("/leaves/{id}")
	public Map<String, Boolean> deleteLeave(@PathVariable(value = "id") Long leaveId)
			throws ResourceNotFoundException {
		Leave leave = leaveRepository.findById(leaveId)
				.orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id :: " + leaveId));

		leaveRepository.delete(leave);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

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
import com.project.ordermanagementsystem.model.Login;
import com.project.ordermanagementsystem.repository.LoginRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class LoginController {
	@Autowired
	private LoginRepository loginRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	
	public ArrayList getLoginData(long login_id) {
		 Query q = entityManager.createQuery("SELECT log from login log WHERE login_id = :login_id");
		 List<Object[]> login = q.setParameter("login_id", login_id).getResultList();
				 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		
		 for ( Object[] row : login ) {
			  
			 HashMap<String, String> results = new HashMap();
			  Login login_details = (Login)row[ 0 ];
			  
			    results.put("login_id",String.valueOf(login_details.getLogin_id()));
			    results.put("login_name",String.valueOf(login_details.getLogin_name()));
				results.put("login_email",login_details.getLogin_email());
				results.put("login_level_id",login_details.getLogin_level_id());
				
			    
			    resultArray.add(results);
			 
		 }	 
        return resultArray;
	}
	

/*	@PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginForm loginForm) {
        // throws Exception if authentication failed

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generate(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userService.findOne(userDetails.getUsername());
            return ResponseEntity.ok(new JwtResponse(jwt, user.getEmail(), user.getName(), user.getRole()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
*/
//	@PostMapping("/login")
//	public Login checkLogin(@Valid @RequestBody Login login) {
//		Login loginObj = loginRepository.checkLogin(login.getLogin_email(), login.getLogin_password());
//		
//		return loginRepository.checkLogin(login.getLogin_email(), login.getLogin_password());
//	}

	
	@PostMapping("/login")
	public Login checkLogin(@Valid @RequestBody Login login) {
		Login loginObj = loginRepository.checkLogin(login.getLogin_email(), login.getLogin_password());
		System.out.print(loginObj);
		return loginObj;
//		return this.getLoginData(loginObj.getLogin_id());
//		return loginRepository.checkLogin(login.getLogin_email(), login.getLogin_password());
	}
}

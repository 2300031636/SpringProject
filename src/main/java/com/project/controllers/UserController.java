package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.models.Admin;
import com.project.models.User;
import com.project.services.UserService;

@RestController
@RequestMapping("/User")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping("/home")
		public String Home() {
		return "User Home";
	}
	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            String output = service.registeruser(user);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
        	 e.printStackTrace();
            return ResponseEntity.status(500).body("User Registration Failed ...");
        }
    }
	 @PostMapping("/login")
	    public ResponseEntity<?> UserLogin(@RequestBody User user) {
	        try {
	            User u = service.userlogin(user.getEmail(), user.getPassword());
	            if (u != null) {
	            	System.out.println("User logged in: " + user.getEmail());
	                return ResponseEntity.ok(u);
	            } else {
	                return ResponseEntity.status(401).body("Invalid Credentials");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Login Failed: " + e.getMessage());
	        }
	    }
	 @PutMapping("/editprofile")
	    public ResponseEntity<String> updateUserProfile(@RequestBody User user) {
	        try {
	        	System.out.println(user.toString());
	            String output = service.updateprofile(user);
	            return ResponseEntity.ok(output);
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Failed to Update User ... !!");
	        }
	    }
	
}

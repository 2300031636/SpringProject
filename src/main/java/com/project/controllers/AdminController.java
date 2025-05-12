package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.models.Admin;
import com.project.models.User;
import com.project.models.ProjectManager; 
import com.project.services.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping
    public String home() {
        return "Admin Home";
    }

    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(@RequestBody Admin admin) {
        try {
            Admin a = service.adminLogin(admin.getEmail(), admin.getPassword());
            if (a != null) {
                System.out.println("Admin logged in: " + admin.getEmail());
                return ResponseEntity.ok(a);
            } else {
                return ResponseEntity.status(401).body("Invalid Credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login Failed: " + e.getMessage());
        }
    }
    @PostMapping("/addmanager")
    public ResponseEntity<String> addeventmanager(@RequestBody ProjectManager man)
    {
  	   try
  	   {
  		   
  		  String obj = service.addManager(man);
  		  return ResponseEntity.ok(obj); 
  	   }
  	   catch(Exception e)
  	   {
  		   
  		   return ResponseEntity.status(500).body("Failed to Add Manager ... "); 
  	   }
    }

    @GetMapping("/displayusers")
    public ResponseEntity<List<User>> viewUsers() {
        List<User> users = service.viewusers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/displaymanagers") 
    public ResponseEntity<List<ProjectManager>> viewManagers() {
        List<ProjectManager> managers = service.viewManagers(); 
        return ResponseEntity.ok(managers);
    }
    @DeleteMapping("/deleteuser")
    public ResponseEntity<String> deleteUser(@RequestParam int uid) {
        try {
            String obj = service.deleteUser(uid);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Delete User ... !!");
        }
    }
    @DeleteMapping("/deletemanager")
    public ResponseEntity<String> deleteManager(@RequestParam int mid) {
        try {
            String output = service.deleteManager(mid);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Delete Manager ... !!");
        }
    }


}

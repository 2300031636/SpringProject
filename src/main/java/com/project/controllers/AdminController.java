//package com.project.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.project.models.Admin;
//import com.project.models.User;
//import com.project.services.AdminService;
//
//@RestController
//@RequestMapping("/admin")
//@CrossOrigin("*")
//public class AdminController {
//
//    @Autowired
//    private AdminService service;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
//        boolean isAuthenticated = service.login(email, password);
//
//        if (isAuthenticated) {
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body("<h1>Welcome Admin!</h1>");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body("<p>Wrong email or password!</p>");
//        }
//    }
//
//   
//
//    @GetMapping("/display")
//    public ResponseEntity<List<User>> displayUsers() {
//        try {
//            List<User> users = service.viewuser();
//            return ResponseEntity.ok(users);
//        } catch (Exception e) {
//            return ResponseEntity.status(500).build();
//        }
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> removeUser(@RequestParam int userid) {
//        try {
//            String result = service.deleteuser(userid);
//            return ResponseEntity.ok(result);
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
//        }
//    }
//}

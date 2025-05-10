package com.project.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.models.User;
import com.project.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public String registeruser(User user) {
        // Set default role
        userRepo.save(user);
        return "User is added successfully";
    }
//    @Override
//    public String registeruser(User user) {
//        System.out.println("Registering user: " + user.getEmail());
//        User savedUser = userRepo.save(user);
//        System.out.println("Saved user ID: " + savedUser.getId());
//        return "User Registered Successfully";
//    }

    @Override
    public User userlogin(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public String updateprofile(User user) {
        Optional<User> obj = userRepo.findById(user.getId());
        if (obj.isEmpty()) {
            return "User not found";
        }
        User u = obj.get();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
      
        u.setDesignation(user.getDesignation());
        u.setContact(user.getContact());
        u.setAddress(user.getAddress());
        userRepo.save(u); 
        return "User profile is updated successfully";
    }
}

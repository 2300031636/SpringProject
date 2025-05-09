package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Task;
import com.project.models.User;
import com.project.repositories.AdminRepository;
import com.project.repositories.ManagerRepository;
import com.project.repositories.TaskRepository;
import com.project.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {
   
	@Autowired
	private UserRepository userRepo;
//	@Autowired
//	private TaskRepository taskRepo;
	@Override
	public String registeruser(User user) {
		
	userRepo.save(user);
	return "User is successfully added";
	}

	@Override
	public User userlogin(String email, String password) {
		
		return userRepo.findByEmailAndPassword(email, password);
	}

//	@Override
//	public List<Task> displaytasks() {
//		return taskRepo.findAll();
//	}

	@Override
	public String updateprofile(User user) {
		Optional<User> obj= userRepo.findById(user.getId());
		if(obj.isEmpty()) {
			return "User not found";
		}
		User u=obj.get();
		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        u.setDesignation(user.getDesignation());
        u.setContact(user.getContact());
        u.setAddress(user.getAddress());
        userRepo.save(user);
        return "User profile is updated successfully";
			
		}
	}



package com.project.services;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Admin;
import com.project.models.User;
import com.project.models.ProjectManager;
import com.project.repositories.AdminRepository;
import com.project.repositories.UserRepository;
import com.project.repositories.ManagerRepository;
import com.project.repositories.TaskRepository;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private ManagerRepository managerRepo;

    @Autowired
    private UserRepository userRepo;


    @Override
    public Admin adminLogin(String email, String password) {
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password must not be null");
        }

        return adminRepo.login(email.trim(), password.trim());
    }

	@Override
	public String addManager(ProjectManager manager) {
		
		managerRepo.save(manager);
		return "Project Manager Added Successfully";
	}

	@Override
	public List<ProjectManager> viewManagers() {
		return managerRepo.findAll();
	}

	@Override
	public String deleteManager(int Id) {
		
		 Optional<ProjectManager> manager = managerRepo.findById(Id);
		    
		    if (manager.isPresent()) 
		    {	
		        managerRepo.deleteById(Id);
		        return "Manager Deleted Successfully";
		    } 
		    else 
		    {
		        return "Manager ID Not Found";
		    }}
	
	

	@Override
	public List<User> viewusers() {
		return userRepo.findAll();
	}

	@Override
	public String deleteUser(int Id) {
		
		 Optional<User> user = userRepo.findById(Id);
		    
		    if (user.isPresent()) 
		    {	
		        userRepo.deleteById(Id);
		        return "User Deleted Successfully";
		    } 
		    else 
		    {
		        return "User ID Not Found";
		    }
	}}

   

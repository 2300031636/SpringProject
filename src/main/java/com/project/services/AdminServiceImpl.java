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

//    @Autowired
//    private TaskRepository taskRepository;

	@Override
	public Admin adminLogin(String email, String password) {
	 
    	 return adminRepo.findByEmailAndPassword(email, password);

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
	public String deleteManager(int managerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> viewusers() {
		return userRepo.findAll();
	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
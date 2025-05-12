package com.project.services;

import java.util.List;

import com.project.models.Admin;
import com.project.models.ProjectManager;
import com.project.models.User;

public interface AdminService {
	
	public Admin adminLogin(String email, String password);
	
	public String addManager(ProjectManager manager);
	
	public List<ProjectManager> viewManagers();
	
    public String deleteManager(int Id);
    
	public List<User> viewusers();

	public String deleteUser(int Id);


	

}
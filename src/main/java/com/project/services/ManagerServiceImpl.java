package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.AssignTask;
import com.project.models.ProjectManager;
import com.project.models.Task;
//import com.project.repositories.AssignTaskRepository;
//import com.project.repositories.AssignTaskRepository;
import com.project.repositories.ManagerRepository;
import com.project.repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepo;

    @Autowired
    private TaskRepository taskRepo;

//    @Autowired
//    private AssignTaskRepository assignTaskRepo;

    
    @Override
    public ProjectManager managerlogin(String email, String password) {
        return managerRepo.login(email.trim(), password.trim());
    }

    
    @Override
    public String createtask(Task task) {
        taskRepo.save(task);
        return "Task added Successfully";
    }


	@Override
	public ProjectManager ManagerById(int mid) {
		return managerRepo.findById(mid).get();
	}


	@Override
	public List<Task> viewtasksbymanager(int mid) {
		ProjectManager manager = managerRepo.findById(mid).orElse(null);
		 return taskRepo.findByManager(manager);
		
		
	}

}
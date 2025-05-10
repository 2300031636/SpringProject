package com.project.services;

import java.util.List;

import com.project.models.AssignTask;
import com.project.models.ProjectManager;
import com.project.models.Task;

public interface ManagerService {
 public ProjectManager managerlogin(String email,String password);
 public String createtask(Task task);
 public List<Task> viewtasksbymanager(int mid);
 public List<AssignTask> assigntasksbyManager(int mid);
 public String updatetaskstatus(int id,String status);

}

package com.project.services;

import java.util.List;

import com.project.models.Task;
import com.project.models.User;

public interface UserService {
public String registeruser(User user);
public User userlogin(String email,String password);
//public List<Task> displaytasks();
public String updateprofile(User user);

}

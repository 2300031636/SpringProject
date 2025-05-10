package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.models.ProjectManager;
import com.project.models.Task;
import com.project.models.AssignTask;
import com.project.services.ManagerService;

@RestController
@RequestMapping("/manager")
@CrossOrigin("*")
public class ManagerController {

    @Autowired
    private ManagerService service;

    @GetMapping("/home")
    public String home() {
        return "Manager Home";
    }

   
    @PostMapping("/login")
    public ResponseEntity<?> managerLogin(@RequestBody ProjectManager man) {
        try {
            ProjectManager m = service.managerlogin(man.getEmail(), man.getPassword());

            if (m != null) {
                return ResponseEntity.ok(m);
            } else {
                return ResponseEntity.status(401).body("Invalid Credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login Failed: " + e.getMessage());
        }
    }

    
    @PostMapping("/createtask")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        try {
            String result = service.createtask(task);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to create task: " + e.getMessage());
        }
    }

  
    @GetMapping("/viewtasksbymanager/{mid}")
    public ResponseEntity<List<Task>> viewTasksByManager(@PathVariable int mid) {
        List<Task> tasks = service.viewtasksbymanager(mid);
        return ResponseEntity.ok(tasks);
    }

   
    @GetMapping("/viewassignedtasks/{mid}")
    public ResponseEntity<List<AssignTask>> viewAssignedTasks(@PathVariable int mid) {
        List<AssignTask> assignedTasks = service.assigntasksbyManager(mid);
        return ResponseEntity.ok(assignedTasks);
    }

    
    @PutMapping("/updatetaskstatus")
    public ResponseEntity<String> updateTaskStatus(@RequestParam int id, @RequestParam String status) {
        try {
            String result = service.updatetaskstatus(id, status);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to update task status: " + e.getMessage());
        }
    }
}

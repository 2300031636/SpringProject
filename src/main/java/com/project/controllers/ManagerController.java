package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.dto.TaskDTO;
import com.project.models.Task;
import com.project.models.ProjectManager;
import com.project.services.ManagerService;

@RestController
@RequestMapping("/manager")
@CrossOrigin("*")
public class ManagerController 
{
   @Autowired
   private com.project.services.ManagerService service;
       
//   @PostMapping("/login")
//   public ResponseEntity<?> checkManagerLogin(@RequestBody ProjectManager manager) 
//   {
//       try 
//       {
//           ProjectManager m = service.managerlogin(manager.getName(), manager.getPassword());
//
//           if (m != null) 
//           {
//               return ResponseEntity.ok(m); 
//           } 
//           else 
//           {
//               return ResponseEntity.status(401).body("Invalid Username or Password"); 
//           }
//       } 
//       catch (Exception e) 
//       {
//           return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
//       }
//   }

   @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody ProjectManager request) {
       try {
           if (request.getEmail() == null || request.getPassword() == null) {
               return ResponseEntity.badRequest().body("Email and password are required");
           }

           ProjectManager manager = service.managerlogin(request.getEmail().trim(), request.getPassword().trim());

           if (manager != null) {
               return ResponseEntity.ok(manager);
           } else {
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
           }
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Login failed: " + e.getMessage());
       }
   }
   @PostMapping("/addtask")
   public ResponseEntity<String> addTask(@RequestBody TaskDTO dto) 
   {
       try 
       {
           ProjectManager manager = service.ManagerById(dto.manager_Id);

           Task task = new Task();
           
           task.setTitle(dto.getTitle());
           task.setDescription(dto.getDescription());
           task.setDeadline(dto.getDeadline()); 
           task.setStatus(dto.getStatus());
           task.setManager(manager);

           String output = service.createtask(task);
           return ResponseEntity.ok(output); 
       } 
       catch (Exception e) 
       { 
           return ResponseEntity.status(500).body("Failed to Add Task: " + e.getMessage());
       }
   }
   
   @GetMapping("/viewtasksbymanager/{managerId}")
   public ResponseEntity<List<Task>> viewTasksByManager(@PathVariable int managerId) 
   {
       List<Task> tasks = service.viewtasksbymanager(managerId);
       return ResponseEntity.ok(tasks);
   }
//   @DeleteMapping("/manager/deletetask/{taskId}")
//   public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
//       ManagerRepo.deleteById(taskId);
//       return ResponseEntity.ok("Task deleted successfully");
//   }

//   @GetMapping("/updatetaskstatus")
//   public ResponseEntity<String> updateTaskStatus(@RequestParam int taskId, @RequestParam String status) 
//   { 
//       try
////       {
////           String output = managerService.updateTaskStatus(taskId, status);
////           return ResponseEntity.ok(output);
////       }
////       catch (Exception e) 
////       {
////           return ResponseEntity.status(500).body("Error:" + e.getMessage());
////       }
//   }
}
//package com.project.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.project.models.AssignTask;
//import com.project.repositories.AssignTaskRepository;
//
//@RestController
//@RequestMapping("/api/assigntask")
//
//public class AssignTaskController {
//	@Autowired
//    private AssignTaskRepository assignTaskRepo;
//
//    @PostMapping("/add")
//    public AssignTask addTask(@RequestBody AssignTask assignTask) {
//        return assignTaskRepo.save(assignTask);
//    }
//
//    @GetMapping("/all")
//    public List<AssignTask> getAllTasks() {
//        return assignTaskRepo.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public AssignTask getTaskById(@PathVariable int id) {
//        return assignTaskRepo.findById(id).orElse(null);
//    }
//}
//
//
//    
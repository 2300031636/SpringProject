package com.project.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.models.ProjectManager;
import com.project.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

	public List<Task> findByManager(ProjectManager manager);
}
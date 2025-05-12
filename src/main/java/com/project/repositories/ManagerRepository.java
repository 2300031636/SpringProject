package com.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.models.ProjectManager;

@Repository
public interface ManagerRepository extends JpaRepository<ProjectManager, Integer>{
	  public ProjectManager findByEmailAndPassword(String email, String password);
	  @Query("SELECT m FROM ProjectManager m WHERE m.email = :email AND m.password = :password")
	  ProjectManager login(@Param("email") String email, @Param("password") String password);


	



}
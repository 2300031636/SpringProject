                                                                                                                                                                                                                         package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.Admin;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Admin findByEmailAndPassword(String email, String password);
}


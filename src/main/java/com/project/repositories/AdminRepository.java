                                                                                                                                                                                                                         package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.models.Admin;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	@Query("SELECT a FROM Admin a WHERE a.email = :email AND a.password = :password")
	Admin login(@Param("email") String email, @Param("password") String password);

}


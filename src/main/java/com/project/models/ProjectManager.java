package com.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="manager_table")
public class ProjectManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(name="man_email",unique= true,nullable=false)
	private String email;
	@Column(name="man_name",nullable=false)
	private String name;
	@Column(name="man_pwd",nullable=false)
	private String password;
	
	@Column(name="man_contact",nullable=false)
	private String contact;
	
	@Column(name="man_dept",nullable=false)
	private String department;
	@Column(name="man_desg",nullable=false)
	private String designation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "ProjectManager [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", contact=" + contact + ", department=" + department + ", designation=" + designation + "]";
	}
	
}



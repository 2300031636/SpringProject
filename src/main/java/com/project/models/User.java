package com.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	
	@Id
	@Column(nullable=false)
	private int id;
	@Column(name="user_email",unique= true,nullable=false)
	private String email;
	@Column(name="user_uname",nullable=false)
	private String username;
	@Column(name="user_pwd",nullable=false)
	private String password;
	@Column(name="user_role",nullable=false)
	private String role;
	@Column(name="user_contact",nullable=false)
	private String contact;
	@Column(name="user_add",nullable=false)
	private String address;
	@Column(name="user_desg",nullable=false)
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact= contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password + ", role="
				+ role + ", phoneno=" + contact + ", address=" + address + ", designation=" + designation + "]";
	}
}

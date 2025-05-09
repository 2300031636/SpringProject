//package com.project.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.models.Admin;
//import com.project.models.User;
//import com.project.repositories.AdminRepository;
//import com.project.repositories.UserRepository;
//@Service
//public class AdminServiceImpl implements AdminService {
//  @Autowired
//	private AdminRepository adminRepo;
//  private UserRepository userRepo;
//  
//	@Override
//	public boolean login(String email,String password) {
//		return adminRepo.findByEmailAndPassword(email, password).isPresent();
//	}
//
//	
//
////	@Override
////	public String deleteuser(int userid) {
////		
////		if (!userRepo.existsById(userid)) {
////            return "User not found";
////        }
////       userRepo.deleteById(userid);
////        return "User is removed Sucessfully!!";
////	}
////	
////
////	@Override
////	public String updateuser(User u) {
////		// TODO Auto-generated method stub
////		return null;
////	}
////
////	@Override
////	public List<User> viewuser() {
////		return userRepo.findAll();
////		
////	}
//
//}

//package com.project.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.project.models.AssignTask;
//import com.project.models.ProjectManager;
//import com.project.models.Task;
//
//
//
//@Repository
//public interface AssignTaskRepository extends JpaRepository<Task, Integer> {
//
//   
////    static List<AssignTask> findByManager(ProjectManager manager) {
////		
////		return null;
////	}
//
//
//    @Query("SELECT a FROM AssignTask a WHERE a.manager.id = ?1")
//    List<AssignTask> getAssignmentsByManagerId(int mid);
//
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE AssignTask a SET a.status = ?1 WHERE a.id = ?2")
//	static
//    int updateStatusById(String status, int id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//}
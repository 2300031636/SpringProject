package com.project.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "assigntask_table")
public class AssignTask 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String taskdescription;

    @Column(nullable = false)
    private String deadline;

    @Column(nullable = false)
    private String status;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime assigntime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTaskdescription() {
		return taskdescription;
	}

	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getAssigntime() {
		return assigntime;
	}

	public void setAssigntime(LocalDateTime assigntime) {
		this.assigntime = assigntime;
	}

	@Override
	public String toString() {
		return "AssignTask [id=" + id + ", task=" + task + ", user=" + user + ", taskdescription=" + taskdescription
				+ ", deadline=" + deadline + ", status=" + status + ", assigntime=" + assigntime + "]";
	}

    

   
}

package com.jspiders.todolist.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data 
public class TaskList {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String task;
	private String status="incompleted";
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
//	public TaskList( String task,  Admin admin) {
//		super();
//		this.id = id;
//		this.task = task;
////		this.status = status;
//		this.admin = admin;
//	}

	public TaskList(String task2, Admin admin2) {
		// TODO Auto-generated constructor stub
	}
	 public TaskList() {
	        // Initialize any fields if needed
	    }
	
   
	
	
	}


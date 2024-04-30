package com.jspiders.todolist.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(nullable = true , unique = true)
	private String email;
	@Column(nullable = true )
	private String name;
	@Column(nullable = true )
	private long contact;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="task")
	private List<TaskList> taskList;
	
	

	


}

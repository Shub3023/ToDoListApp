package com.jspiders.todolist.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.todolist.pojo.Admin;
import com.jspiders.todolist.pojo.TaskList;


@Component
public class AdminRepository {
	
	
	@Autowired
	EntityManager entityManager;

	public void addList(Admin admin) {

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();

	}

	public List<Admin> getAllAdmin() {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("SELECT admin from Admin admin ");

		List<Admin> admin  = query.getResultList();
		

		entityTransaction.commit();
		
		return  admin;

		
	}
	
//	public static void main(String[] args) {
//		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("to_do_list_app");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//		TaskList taskList1 = new TaskList();
////		taskList1.setTask("To play Cricket");
//
////		TaskList taskList2 = new Taskmmmm,List();
////		taskList2.setTask("To play Hocky");
////		entityManager.persist(taskList1);
////		entityManager.persist(taskList2);
//
//
//		Admin admin = new Admin();
//		//admin.setTaskList(Arrays.asList(taskList1, taskList2));
//		//admin.set
//		entityManager.persist(admin);
//		entityTransaction.commit();
//		}
//
//	
//	

}

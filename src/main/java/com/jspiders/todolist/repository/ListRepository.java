package com.jspiders.todolist.repository;

import java.util.Arrays;
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
public class ListRepository {
	
	@Autowired
	private EntityManager entityManager;

	public void addTask(TaskList taskList) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(taskList);
		entityTransaction.commit();
	}
	
public List<TaskList> getAllTask() {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("SELECT taskList from TaskList taskList ");

		List<TaskList> taskList  = query.getResultList();
		

		entityTransaction.commit();
		
		return  taskList;

		
	}

public void deleteTask(TaskList deletetaskById) {
	EntityTransaction entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.remove(deletetaskById);
	entityTransaction.commit();
	
}
@Autowired
AdminRepository adminRepository ;

@Autowired
ListRepository listRepository;

public static void main(String[] args) {
	
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("to_do_list_app");
EntityManager entityManager = entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction = entityManager.getTransaction();
entityTransaction.begin();

//TaskList taskList1 = new TaskList(1, null, null, null);
//taskList1.setTask("To play Cricket");

//TaskList taskList2 = new TaskList();
//taskList2.setTask("To play Hocky");
//entityManager.persist(taskList1);
//entityManager.persist(taskList2);


Admin admin = new Admin();
//admin.setTaskList(Arrays.asList(taskList1, taskList2));
//admin.set
entityManager.persist(admin);
entityTransaction.commit();
}

}



package com.jspiders.todolist.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListConfig {
	

	@Bean
	public EntityManager getList() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("to_do_list_app");
		
		return entityManagerFactory.createEntityManager()  ;
		
	}


}

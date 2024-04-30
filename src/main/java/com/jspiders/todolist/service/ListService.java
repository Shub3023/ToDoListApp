package com.jspiders.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.todolist.pojo.Admin;
import com.jspiders.todolist.pojo.TaskList;
import com.jspiders.todolist.repository.AdminRepository;
import com.jspiders.todolist.repository.ListRepository;

@Component
public class ListService {

	@Autowired
	private ListRepository listRepository;
	@Autowired
	private AdminService adminService;

	public void addTask(long adminId, String task) {
		System.out.println("Admin id:-");
		System.out.println(adminId);
//		List<Admin> admins = adminRepository.getAllAdmin();
//		System.out.println("All service layer admin:- ");
//		for(Admin admin:admins) {
//			
//			System.out.println(admin);
//		}
		System.out.println("Get admin by admin_id");
		
	Admin admin=adminService.getPageByid(adminId);

		TaskList taskList = new TaskList(task,admin );
//		taskList.setId(id);
		taskList.setTask(task);
		taskList.setAdmin(admin);

		listRepository.addTask(taskList);
	}

	public List<TaskList> getAllTask() {

		return listRepository.getAllTask();
	}

	public TaskList editTask(String task) {
		System.out.println("Task wanted to update:-"+task);
		TaskList flag = null;

		List<TaskList> taskLists = listRepository.getAllTask();

		for (TaskList taskList : taskLists) {

			if (taskList.getTask().equals(task)) {

				flag = taskList;
				System.out.println("flag"+flag);
				break;
			}
		}
		return flag;
		

	}

	public String deleteTask(String task) {
		System.out.println(task);

		TaskList deletetaskBysubject = null;
		List<TaskList> tasks = listRepository.getAllTask();
		for (TaskList task1 : tasks) {

			if (task1.getTask().equals(task)) {

				deletetaskBysubject = task1;
				break;
			}
		}
		if (deletetaskBysubject == null) {

			return "Task Not Found.";
		} else {
			listRepository.deleteTask(deletetaskBysubject);
			return "Task Deleted.";
		}
	}
//
//	public void updateTask(String task, String status) {
//		
//	    TaskList taskList = new TaskList();
//	    taskList.setTask(task);
//	    taskList.setStatus(status);
//	    listRepository.addTask(taskList);
//	}

	public void updateForm(long id) {
		
		TaskList task=null;
		
		List<TaskList> tasks = listRepository.getAllTask();
		
		for(TaskList taskList:tasks) {
			
			if(taskList.getId()==id) {
				task=taskList;
				break;
			}
		}
		
		TaskList taskList = getTaskByid(id);
		if(taskList.getStatus().equals("incompleted")) {
		task.setStatus("Completed");
		listRepository.addTask(task);
		}
		
		
	}

	

	public TaskList getTaskByid(long id) {

		TaskList getTaskById=null;
		List<TaskList> taskLists = listRepository.getAllTask();
		for(TaskList taskList:taskLists) {
			
			if(taskList.getId()==id) {
				
				getTaskById=taskList;
				break;
			}
		}
		return getTaskById;
	}

//	public void updateTask1(Long id, String task) {
//		
//       TaskList task1=null;
//		
//		List<TaskList> tasks = listRepository.getAllTask();
//		
//		for(TaskList taskList:tasks) {
//			
//			if(taskList.getId()==id) {
//				task1=taskList;
//				break;
//			}
//		}
//		
//		TaskList taskList = new TaskList();
//		taskList.setTask(task);
//		
//		listRepository.addTask(taskList);
//		
//	}

	
}

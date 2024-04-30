package com.jspiders.todolist.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.todolist.pojo.Admin;
import com.jspiders.todolist.pojo.TaskList;
import com.jspiders.todolist.service.ListService;

@Controller
public class ListController {
	
	@Autowired
	private ListService listService;
	
	@RequestMapping(path="/welcome_page", method = RequestMethod.GET)
	public String getPage() {
	
		return "welcome";
	}
	
	@RequestMapping(path = "/getTask", method = RequestMethod.GET)
	public String getcreateTask() {
		
//		System.out.println("Admin Id:-"+admin.getId());
			
		
		return "create";
	}
	//Post API
	@RequestMapping(path = "/postTask", method = RequestMethod.POST)
	public String addTask(@RequestParam String task, ModelMap map, HttpSession httpSession ) {
		Admin admin =(Admin) httpSession.getAttribute("admin");
		System.out.println("Controller Layer ");
//		System.out.println();
		System.out.println(admin);
		
		listService.addTask(admin.getId(), task);
		map.addAttribute("message", "Task added successfully.");
		return "create";
	}
	
	//Edit API
	@RequestMapping(path = "/editTask", method = RequestMethod.GET)
	public String getEditPage() {
		
		return "editTask";
	}
	
	@RequestMapping(path = "/editTask", method = RequestMethod.POST)
	public String EditTask(@RequestParam String task, ModelMap map) {
		
		TaskList taskList=listService.editTask(task);
		System.out.println("Tasklist:-"+taskList);
		map.addAttribute("task", taskList);
		return "updateTask";
	}
	
//	@RequestMapping(path = "/updateTask", method = RequestMethod.GET)
//	public String updateTask() {
//		
//		return "updateTask";
//	}
	
//	@RequestMapping(path = "/updatedTask", method = RequestMethod.POST)
//	public String updateTask(@PathVariable(value = "id")   @RequestParam String task, @RequestParam String status, ModelMap map) {
//		public String updateForm(@PathVariable(value = "id") long id, ModelMap model) {
//		listService.updateTask(id);
//		map.addAttribute("message","Task Upadated.");
//		return "updateTask";
//	}
	
//	@GetMapping("/updateTask/{id}")
//	public String updateForm(@PathVariable("id") Long id, ModelMap model) {
//		TaskList taskList = listService.updateForm(id);
//		model.addAttribute("taskList",taskList);
//		return "updateTask";
//	}
	
	@PostMapping("/updateTask/{id}")
	public String updateForm(@PathVariable("id") Long id) {
	    listService.updateForm(id);
//	    model.addAttribute("taskList", taskList);
	    return "gettasks";
	}

//	@PostMapping("/updateTask")
//	public String updateTask(@RequestParam Long id, @RequestParam String task, ModelMap map) {
//	    listService.updateTask1(id, task);
//	    map.addAttribute("message", "Task updated successfully.");
//	    return "updateTask";
//	}

	
	@RequestMapping(path = "/gettasks", method = RequestMethod.GET)
	public String getAllTask(ModelMap map) {
		
		List<TaskList> tasks= listService.getAllTask();
		map.addAttribute("tasks", tasks );
		return "allTask";
	}
	
	@RequestMapping(path = "/deletetask", method = RequestMethod.GET)
	public String getDeleteTask() {
		
		return "deleteTask" ;
		
	}
	
	@RequestMapping(path = "/deletedTask", method = RequestMethod.POST)
	public String deleteTask(@RequestParam String task, ModelMap map) {
		
		String task1=listService.deleteTask(task);
		System.out.println("Hi i am controller."+task1);
		map.addAttribute("message", task1);
		return "deleteTask";
		
	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		
		return "home" ;
		
	}
	@RequestMapping(path = "/log_out", method = RequestMethod.GET)
	public String logOut() {
		
		return "login" ;
		
	}
	
	@RequestMapping(path="/getTaskById", method=RequestMethod.GET)
	public String getPageByid() {
		
		return "getId";
	}
	
	@RequestMapping(path="/getTaskbyid", method=RequestMethod.POST)
	public String getTaskByid(@RequestParam long id, ModelMap map) {
		TaskList taskList= listService.getTaskByid(id);
		map.addAttribute("taskList",taskList);
		return "getId";
	}
	
	
	
		
	
	

}

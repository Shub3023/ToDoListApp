package com.jspiders.todolist.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.todolist.pojo.Admin;
import com.jspiders.todolist.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(path = "/log", method = RequestMethod.GET)
	public String getLogin() {

		return "login";
	}

	@RequestMapping(path = "/addregister", method = RequestMethod.GET)
	public String getRegisterPage() {
		return "reg";
	}

	@RequestMapping(path = "/addregister", method = RequestMethod.POST)
	public String addRegister(@RequestParam String email, @RequestParam String name, @RequestParam long contact,
			@RequestParam String password, ModelMap modelMap) {
		adminService.addRegister(email, name, contact, password);
		modelMap.addAttribute("message", "Admin Added.");
		return "reg";

	}

	@RequestMapping(path = "/log", method = RequestMethod.POST)
	public String checkLogin(@RequestParam String email, @RequestParam String pass, ModelMap modelMap,
			HttpSession httpSession) {

		Admin flag = adminService.checkLogin(email, pass);

//			modelMap.addAttribute("message", email);
		System.out.println(flag);

		if (flag != null) {
			httpSession.setAttribute("admin", flag);
			modelMap.addAttribute("message", "Admin is present");

			return "home";
		} else {
			modelMap.addAttribute("message", "Admin is not present");
			return "reg";
		}
	}

	public String getAllAdmin() {

		adminService.getAllAdmin();

		return null;

	}

	@RequestMapping(path = "/editAdmin", method = RequestMethod.GET)
	public String editAdmin() {
		return "edit";

	}

	@RequestMapping(path = "/editAdmin", method = RequestMethod.POST)
	public String editAdmin1(@RequestParam int id, ModelMap map) {

		Admin admin = adminService.editAdmin1(id);
		map.addAttribute("admins", admin);

		return "update";
	}

	@RequestMapping(path ="/updateAdmin1", method = RequestMethod.POST)
	public String updateAdmin(@RequestParam int id, @RequestParam String email, @RequestParam String name,
			@RequestParam long contact, @RequestParam String password, @RequestParam String confirmpassword,
			ModelMap map) {

		adminService.updateAdmin(id, email, name, contact, password, confirmpassword);
		map.addAttribute("message", "Admin Updated.");

		return "update";
	}
	
	@RequestMapping(path="/get", method=RequestMethod.GET)
	public String getPageByid() {
		
		return "get";
	}
	
	@RequestMapping(path="/getbyid", method=RequestMethod.POST)
	public String getPageByid(@RequestParam long id, ModelMap map) {
		Admin admin=adminService.getPageByid(id);
		map.addAttribute("admin",admin);
		return "get";
	}
	

}

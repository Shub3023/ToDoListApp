package com.jspiders.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.todolist.pojo.Admin;
import com.jspiders.todolist.repository.AdminRepository;

@Component
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public void addRegister(String email, String name, long contact, String password) {

		Admin admin = new Admin();
		admin.setEmail(email);
		admin.setName(name);
		admin.setContact(contact);
		admin.setPassword(password);

		adminRepository.addList(admin);
	}

	public Admin checkLogin(String email, String password) {
//		System.out.println("email"+email);
//		System.out.println("password"+password);

		Admin flag = null;

		List<Admin> admins = adminRepository.getAllAdmin();

		for (Admin admin : admins) {

			if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {

				flag = admin;
				System.out.println("flag" + flag);

			}
		}
		return flag;
	}

	public void getAllAdmin() {

		adminRepository.getAllAdmin();

	}

	public Admin editAdmin1(int id) {
		System.out.println(id);
		Admin flag = null;

		List<Admin> admins = adminRepository.getAllAdmin();

		for (Admin admin : admins) {

			if (admin.getId() == id) {

				flag = admin;
//				System.out.println("flag"+flag);
				break;

			}
		}
		return flag;
	}

	public void updateAdmin(long id, String email, String name, long contact, String password, String confirmpassword) {
		Admin admin = new Admin();
		admin.setId(id);
		admin.setEmail(email);
		admin.setName(name);
		admin.setContact(contact);

		adminRepository.addList(admin);
	}

	public Admin getPageByid(long id) {
		 
		Admin getAdminById=null;
		List<Admin> admins = adminRepository.getAllAdmin();
		for(Admin admin:admins) {
			
			if(admin.getId()==id) {
				
				getAdminById=admin;
				break;
			}
		}
		return getAdminById;
		
	}

}

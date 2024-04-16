package com.example.foodTownEntities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodTownEntities.entity.Admin;
import com.example.foodTownEntities.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService AdminService;
	
	@PostMapping("/add")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin Admin)
	{
		Admin a=AdminService.addAdmin(Admin);
		return new ResponseEntity<>(a,HttpStatus.CREATED);
	}
	@GetMapping("/get/{AdminId}")
	public ResponseEntity<Admin> getAdmin(@PathVariable Long AdminId)
	{
		boolean isAdmin=AdminService.isAdminExists(AdminId);
		if(isAdmin)
		{
			Admin a=AdminService.getAdminById(AdminId);
			return new ResponseEntity<>(a,HttpStatus.OK);
		}
		else
		{
			System.out.print("No Admin found");
			return null;
		}
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Admin>> getAllAdmin(){
		return new ResponseEntity<>(AdminService.getAllAdmins(),HttpStatus.OK);
	}
	@PutMapping("/update/{AdminId}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long AdminId,@RequestBody Admin a)
	{
		boolean isAdmin=AdminService.isAdminExists(AdminId);
		if(isAdmin)
		{
			return new ResponseEntity<>(AdminService.updateAdmin(AdminId, a),HttpStatus.OK);
		}
		else {
			System.out.print("No Admin found");
			return null;
		}
	}
	@DeleteMapping("/delete/{AdminId}")
	public void deleteAdminById(@PathVariable Long AdminId)
	{
		boolean isAdmin=AdminService.isAdminExists(AdminId);
		if(isAdmin)
		{
			AdminService.deleteAdminById(AdminId);
		}
		else
		{
			System.out.print("No Admin found");
		}
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllAdmin(){
		AdminService.deleteAllAdmin();
	}
}
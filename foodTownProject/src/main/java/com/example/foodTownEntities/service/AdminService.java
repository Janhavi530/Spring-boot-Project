package com.example.foodTownEntities.service;

import java.util.List;

import com.example.foodTownEntities.entity.Admin;

public interface AdminService {
Admin addAdmin(Admin Admin);
	
	List<Admin> getAllAdmins();
	
	Admin getAdminById(Long AdminId);
	
	Admin updateAdmin(Long AdminId,Admin Admin);
	
	void deleteAdminById(Long AdminId);
	
	void deleteAllAdmin();
	
	boolean isAdminExists(Long AdminId);
}

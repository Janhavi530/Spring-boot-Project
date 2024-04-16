package com.example.foodTownEntities.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.foodTownEntities.entity.Admin;
import com.example.foodTownEntities.repository.AdminRepository;
import com.example.foodTownEntities.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	  @Autowired
		 private AdminRepository AdminRepo;
	    
		@Override
		public Admin addAdmin(Admin Admin) {
			return AdminRepo.save(Admin);
		}

		@Override
		public List<Admin> getAllAdmins() {
			return AdminRepo.findAll();
		}

		@Override
		public Admin getAdminById(Long AdminId) {
			//Optional<Admin> op=AdminRepo.findById(AdminId);
			//return op.get();
			return AdminRepo.findById(AdminId).get();
		}

		@Override
		public Admin updateAdmin(Long AdminId,Admin Admin) {
			Admin a=AdminRepo.findById(AdminId).get();
			a.setName(Admin.getName());
			a.setUsername(Admin.getUsername());
			a.setPassword(Admin.getPassword());
			a.setEmail(Admin.getEmail());
			a.setMobilenumber(Admin.getMobilenumber());
			return AdminRepo.save(a);
		}

		@Override
		public void deleteAdminById(Long AdminId) {
			AdminRepo.deleteById(AdminId);
		}

		@Override
		public void deleteAllAdmin() {
			AdminRepo.deleteAll();
			
		}

		@Override
		public boolean isAdminExists(Long AdminId) {
			return AdminRepo.existsById(AdminId);
		}
}

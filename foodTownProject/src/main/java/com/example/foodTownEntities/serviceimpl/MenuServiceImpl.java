package com.example.foodTownEntities.serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodTownEntities.entity.Menu;

import com.example.foodTownEntities.repository.MenuRepository;
import com.example.foodTownEntities.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	 private MenuRepository MenuRepo;
	
	@Override
	public Menu addMenu(Menu Menu) {
		// TODO Auto-generated method stub
		return MenuRepo.save(Menu);
	}

	@Override
	public List<Menu> getAllMenus() {
		// TODO Auto-generated method stub
		return MenuRepo.findAll();
	}

	@Override
	public Menu getMenuById(Long MenuId) {
		// TODO Auto-generated method stub
		return MenuRepo.findById(MenuId).get();
	}

	@Override
	public Menu updateMenu(Long MenuId, Menu Menu) {
		// TODO Auto-generated method stub
		Menu a=MenuRepo.findById(MenuId).get();
		a.setName(Menu.getName());
		a.setPrice(Menu.getPrice());
		return MenuRepo.save(a);
	}

	@Override
	public void deleteMenuById(Long MenuId) {
		// TODO Auto-generated method stub
		MenuRepo.deleteById(MenuId);
	}

	@Override
	public void deleteAllMenu() {
		// TODO Auto-generated method stub
		MenuRepo.deleteAll();
	}

	@Override
	public boolean isMenuExists(Long MenuId) {
		// TODO Auto-generated method stub
		return MenuRepo.existsById(MenuId);
	}

}

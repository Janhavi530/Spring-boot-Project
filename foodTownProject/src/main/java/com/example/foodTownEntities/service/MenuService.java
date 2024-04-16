package com.example.foodTownEntities.service;
import java.util.List;

import com.example.foodTownEntities.entity.Menu;
public interface MenuService {
Menu addMenu(Menu Menu);
	
	List<Menu> getAllMenus();
	
	Menu getMenuById(Long MenuId);
	
	Menu updateMenu(Long MenuId,Menu Menu);
	
	void deleteMenuById(Long MenuId);
	
	void deleteAllMenu();
	
	boolean isMenuExists(Long MenuId);
}

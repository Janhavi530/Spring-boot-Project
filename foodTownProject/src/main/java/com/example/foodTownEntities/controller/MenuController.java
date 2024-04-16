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

import com.example.foodTownEntities.entity.Menu;

import com.example.foodTownEntities.service.MenuService;
@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService MenuService;
	
	@PostMapping("/add")
	public ResponseEntity<Menu> addMenu(@RequestBody Menu Menu)
	{
		Menu a=MenuService.addMenu(Menu);
		return new ResponseEntity<>(a,HttpStatus.CREATED);
	}
	@GetMapping("/get/{MenuId}")
	public ResponseEntity<Menu> getMenu(@PathVariable Long MenuId)
	{
		boolean isMenu=MenuService.isMenuExists(MenuId);
		if(isMenu)
		{
			Menu a=MenuService.getMenuById(MenuId);
			return new ResponseEntity<>(a,HttpStatus.OK);
		}
		else
		{
			System.out.print("No Menu found");
			return null;
		}
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Menu>> getAllMenu(){
		return new ResponseEntity<>(MenuService.getAllMenus(),HttpStatus.OK);
	}
	@PutMapping("/update/{MenuId}")
	public ResponseEntity<Menu> updateMenu(@PathVariable Long MenuId,@RequestBody Menu a)
	{
		boolean isMenu=MenuService.isMenuExists(MenuId);
		if(isMenu)
		{
			return new ResponseEntity<>(MenuService.updateMenu(MenuId, a),HttpStatus.OK);
		}
		else {
			System.out.print("No Menu found");
			return null;
		}
	}
	@DeleteMapping("/delete/{MenuId}")
	public void deleteMenuById(@PathVariable Long MenuId)
	{
		boolean isMenu=MenuService.isMenuExists(MenuId);
		if(isMenu)
		{
			MenuService.deleteMenuById(MenuId);
		}
		else
		{
			System.out.print("No Menu found");
		}
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllMenu(){
		MenuService.deleteAllMenu();
	}
}

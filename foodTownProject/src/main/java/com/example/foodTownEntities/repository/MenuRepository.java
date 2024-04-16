package com.example.foodTownEntities.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodTownEntities.entity.Menu;
public interface MenuRepository extends JpaRepository<Menu, Long> {

}

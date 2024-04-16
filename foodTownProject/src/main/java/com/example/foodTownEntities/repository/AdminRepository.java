package com.example.foodTownEntities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodTownEntities.entity.Admin;
public interface AdminRepository extends JpaRepository<Admin, Long> {

}

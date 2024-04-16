package com.example.foodTownEntities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodTownEntities.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}

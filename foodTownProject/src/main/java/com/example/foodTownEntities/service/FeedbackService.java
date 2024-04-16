package com.example.foodTownEntities.service;

import java.util.List;

import com.example.foodTownEntities.entity.Feedback;

public interface FeedbackService {
	Feedback addFeedback(Feedback Feedback);
	
	List<Feedback> getAllFeedbacks();
	
	Feedback getFeedbackById(Long FeedbackId);
	
	Feedback updateFeedback(Long FeedbackId,Feedback Feedback);
	
	void deleteFeedbackById(Long FeedbackId);
	
	void deleteAllFeedback();
	
	boolean isFeedbackExists(Long FeedbackId);
}

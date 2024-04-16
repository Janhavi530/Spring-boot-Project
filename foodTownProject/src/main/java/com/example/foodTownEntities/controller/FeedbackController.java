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

import com.example.foodTownEntities.entity.Feedback;

import com.example.foodTownEntities.service.FeedbackService;

@RestController
@RequestMapping("/Feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService FeedbackService;
	
	@PostMapping("/add")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback Feedback)
	{
		Feedback a=FeedbackService.addFeedback(Feedback);
		return new ResponseEntity<>(a,HttpStatus.CREATED);
	}
	@GetMapping("/get/{FeedbackId}")
	public ResponseEntity<Feedback> getFeedback(@PathVariable Long FeedbackId)
	{
		boolean isFeedback=FeedbackService.isFeedbackExists(FeedbackId);
		if(isFeedback)
		{
			Feedback a=FeedbackService.getFeedbackById(FeedbackId);
			return new ResponseEntity<>(a,HttpStatus.OK);
		}
		else
		{
			System.out.print("No Feedback found");
			return null;
		}
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Feedback>> getAllFeedback(){
		return new ResponseEntity<>(FeedbackService.getAllFeedbacks(),HttpStatus.OK);
	}
	@PutMapping("/update/{FeedbackId}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable Long FeedbackId,@RequestBody Feedback a)
	{
		boolean isFeedback=FeedbackService.isFeedbackExists(FeedbackId);
		if(isFeedback)
		{
			return new ResponseEntity<>(FeedbackService.updateFeedback(FeedbackId, a),HttpStatus.OK);
		}
		else {
			System.out.print("No Feedback found");
			return null;
		}
	}
	@DeleteMapping("/delete/{FeedbackId}")
	public void deleteFeedbackById(@PathVariable Long FeedbackId)
	{
		boolean isFeedback=FeedbackService.isFeedbackExists(FeedbackId);
		if(isFeedback)
		{
			FeedbackService.deleteFeedbackById(FeedbackId);
		}
		else
		{
			System.out.print("No Feedback found");
		}
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllFeedback(){
		FeedbackService.deleteAllFeedback();
	}
}

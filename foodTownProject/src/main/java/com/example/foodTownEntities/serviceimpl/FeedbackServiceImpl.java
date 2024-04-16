package com.example.foodTownEntities.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.foodTownEntities.entity.Feedback;
import com.example.foodTownEntities.service.FeedbackService;
import com.example.foodTownEntities.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository FeedbackRepo;
	@Override
	public Feedback addFeedback(Feedback Feedback) {
		// TODO Auto-generated method stub
		return FeedbackRepo.save(Feedback);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return FeedbackRepo.findAll();
	}

	@Override
	public Feedback getFeedbackById(Long FeedbackId) {
		// TODO Auto-generated method stub
		return FeedbackRepo.findById(FeedbackId).get();
	}

	@Override
	public Feedback updateFeedback(Long FeedbackId, Feedback Feedback) {
		// TODO Auto-generated method stub
		Feedback a=FeedbackRepo.findById(FeedbackId).get();
		a.setCustomer(Feedback.getCustomer());
		a.setMessage(Feedback.getMessage());
		a.setCreatedAt(Feedback.getCreatedAt());
		a.setUpdatedAt(Feedback.getUpdatedAt());
		return FeedbackRepo.save(a);
	}

	@Override
	public void deleteFeedbackById(Long FeedbackId) {
		// TODO Auto-generated method stub
		FeedbackRepo.deleteById(FeedbackId);
	}

	@Override
	public void deleteAllFeedback() {
		// TODO Auto-generated method stub
		FeedbackRepo.deleteAll();
	}

	@Override
	public boolean isFeedbackExists(Long FeedbackId) {
		// TODO Auto-generated method stub
		return FeedbackRepo.existsById(FeedbackId);
	}

}

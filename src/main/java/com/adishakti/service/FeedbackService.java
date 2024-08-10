package com.adishakti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adishakti.dao.FeedbackRepository;
import com.adishakti.entity.FeedBack;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public FeedBack saveFeedback(FeedBack feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<FeedBack> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<FeedBack> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}

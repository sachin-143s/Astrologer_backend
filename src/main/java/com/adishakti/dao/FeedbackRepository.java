package com.adishakti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adishakti.entity.FeedBack;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, Long> {}

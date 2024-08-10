package com.adishakti.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ChatSession {
    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "astrologer_id")
    private Astrologer astrologer;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double rate;
    @Column(length = 20)
    private String paymentReferenceNumber;
    private Boolean approved;
	public ChatSession() {
		super();
	}
	public ChatSession(Long id, User user, Astrologer astrologer, LocalDateTime startTime, LocalDateTime endTime,
			Double rate, String paymentReferenceNumber, Boolean approved) {
		super();
		this.id = id;
		this.user = user;
		this.astrologer = astrologer;
		this.startTime = startTime;
		this.endTime = endTime;
		this.rate = rate;
		this.paymentReferenceNumber = paymentReferenceNumber;
		this.approved = approved;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Astrologer getAstrologer() {
		return astrologer;
	}
	public void setAstrologer(Astrologer astrologer) {
		this.astrologer = astrologer;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getPaymentReferenceNumber() {
		return paymentReferenceNumber;
	}
	public void setPaymentReferenceNumber(String paymentReferenceNumber) {
		this.paymentReferenceNumber = paymentReferenceNumber;
	}
	public Boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "ChatSession [id=" + id + ", user=" + user + ", astrologer=" + astrologer + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", rate=" + rate + ", paymentReferenceNumber=" + paymentReferenceNumber
				+ ", approved=" + approved + "]";
	}

    
}

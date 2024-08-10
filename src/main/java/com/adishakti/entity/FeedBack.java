package com.adishakti.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="feedbacktbl")
public class FeedBack {
    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "astrologer_id")
    private Astrologer astrologer;

    private Integer rating;
    @Column(length = 40)
    private String comments;
	public FeedBack() {
		super();
	}
	public FeedBack(Long id, User user, Astrologer astrologer, Integer rating, String comments) {
		super();
		this.id = id;
		this.user = user;
		this.astrologer = astrologer;
		this.rating = rating;
		this.comments = comments;
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
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", user=" + user + ", astrologer=" + astrologer + ", rating=" + rating
				+ ", comments=" + comments + "]";
	}

    
}


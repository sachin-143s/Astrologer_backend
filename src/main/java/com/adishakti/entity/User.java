package com.adishakti.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="appuser")
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(length = 30)
    private String email;
    @Column(length = 20)
    private String password;
    private LocalDate dob;
    @Column(length = 20)
    private String city;
    @Column(length = 20)
    private String district;
    @Column(length = 20)
    private String state;
    @Column(length = 15)
    private String country;
    @Column(length = 6)
    private String pinCode;
    @Column(length = 10)
    private String mobileNumber;
    @Column(length = 10)
    private String gender;
    @Column(length = 20)
    private String birthPlace;
    private LocalTime birthTime;
    @Lob
    @Column(length = 10_000_000)
    private byte[] profile_img;
    
    @Column(length = 10)
    private String role; // Adding role field

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ChatSession> chatSessions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FeedBack> feedbacks;

	public User() {
		super();
	}

	public User(Long id, String firstName, String lastName, String email, String password, LocalDate dob, String city,
			String district, String state, String country, String pinCode, String mobileNumber, String gender,
			String birthPlace, LocalTime birthTime, byte[] profile_img, String role, List<ChatSession> chatSessions,
			List<FeedBack> feedbacks) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.birthPlace = birthPlace;
		this.birthTime = birthTime;
		this.profile_img = profile_img;
		this.role = role;
		this.chatSessions = chatSessions;
		this.feedbacks = feedbacks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public LocalTime getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(LocalTime birthTime) {
		this.birthTime = birthTime;
	}

	public byte[] getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(byte[] profile_img) {
		this.profile_img = profile_img;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<ChatSession> getChatSessions() {
		return chatSessions;
	}

	public void setChatSessions(List<ChatSession> chatSessions) {
		this.chatSessions = chatSessions;
	}

	public List<FeedBack> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<FeedBack> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", city=" + city + ", district=" + district + ", state="
				+ state + ", country=" + country + ", pinCode=" + pinCode + ", mobileNumber=" + mobileNumber
				+ ", gender=" + gender + ", birthPlace=" + birthPlace + ", birthTime=" + birthTime + ", profile_img="
				+ Arrays.toString(profile_img) + ", role=" + role + ", chatSessions=" + chatSessions + ", feedbacks="
				+ feedbacks + "]";
	}

    

	
}

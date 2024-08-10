package com.adishakti.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Astrologer {
    @Id
    @GeneratedValue()
    private Long id;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(length = 10)
    private String mobile;
    @Column(length = 20)
    private String aadharNumber;
    
    private Date dob;
    @Column(length = 20)
    private String gender;
    private Integer experience;
    
    @ElementCollection
    private List<Language> languagesKnown;
    
    //@ElementCollection
    private String skills;
    @Column(length = 50)
    private String email;
    @Column(length = 20)
    private String city;
    @Column(length = 20)
    private String district;
    @Column(length = 20)
    private String state;
    @Column(length = 10)
    private String country;
    @Column(length = 6)
    private String pinCode;
    
    private Double ratePerMinute;
    @Column(length = 100)
    private String certification;
    @Column(length = 20)
    private String degree;
    @Column(name = "rating")
    private Long rateIng;
    @Column(name = "Password",length = 20)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Image_id")
    private AstrologerImages astrologerImages;
  
    
	public Astrologer() {
		super();
	}



	public Astrologer(Long id, String firstName, String lastName, String mobile, String aadharNumber, Date dob,
			String gender, Integer experience, List<Language> languagesKnown,String skills, String email,
			String city, String district, String state, String country, String pinCode, Double ratePerMinute,
			String certification, String degree, Long rateIng, String password, AstrologerImages astrologerImages) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.aadharNumber = aadharNumber;
		this.dob = dob;
		this.gender = gender;
		this.experience = experience;
		this.languagesKnown = languagesKnown;
		this.skills = skills;
		this.email = email;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
		this.ratePerMinute = ratePerMinute;
		this.certification = certification;
		this.degree = degree;
		this.rateIng = rateIng;
		this.password = password;
		this.astrologerImages = astrologerImages;
		
	}



	public Long getRateIng() {
		return rateIng;
	}



	public void setRateIng(Long rateIng) {
		this.rateIng = rateIng;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AstrologerImages getAstrologerImages() {
		return astrologerImages;
	}

	public void setAstrologerImages(AstrologerImages astrologerImages) {
		this.astrologerImages = astrologerImages;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public List<Language> getLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(List<Language> languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	

	public Double getRatePerMinute() {
		return ratePerMinute;
	}

	public void setRatePerMinute(Double ratePerMinute) {
		this.ratePerMinute = ratePerMinute;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}





}

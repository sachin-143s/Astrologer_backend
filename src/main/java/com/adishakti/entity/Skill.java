package com.adishakti.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="skilltbl")
public class Skill {
    @Id
    @GeneratedValue()
    private Long id;
    @Column(length = 20)
    private String name;
	public Skill(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Skill() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}

   
}

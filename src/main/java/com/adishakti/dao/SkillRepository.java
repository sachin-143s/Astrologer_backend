package com.adishakti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adishakti.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {}


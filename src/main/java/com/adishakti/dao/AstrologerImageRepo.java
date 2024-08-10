package com.adishakti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adishakti.entity.AstrologerImages;

@Repository
public interface AstrologerImageRepo extends JpaRepository<AstrologerImages, Long> {



}

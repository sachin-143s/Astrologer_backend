package com.adishakti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adishakti.entity.Astrologer;
import com.adishakti.entity.AstrologerImages;

@Repository
public interface AstrologerRepository extends JpaRepository<Astrologer, Long> {
    Astrologer findByEmail(String email);
   @Query(value = "select as.astrologerImages from Astrologer as where as.id=?1")
   public AstrologerImages findByAstroName(Long id);
}

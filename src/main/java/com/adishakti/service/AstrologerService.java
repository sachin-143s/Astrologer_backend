package com.adishakti.service;

import java.io.IOException;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adishakti.dao.AstrologerImageRepo;
import com.adishakti.dao.AstrologerRepository;
import com.adishakti.entity.Astrologer;
import com.adishakti.entity.AstrologerImages;


@Service
public class AstrologerService {
    @Autowired
    private AstrologerRepository astrologerRepository;
    @Autowired
    private AstrologerImageRepo astrologerImageRepo;
    public Astrologer saveAstrologer(Astrologer astrologer) {
        return astrologerRepository.save(astrologer);
    }

    public List<Astrologer> getAllAstrologers() {
        return astrologerRepository.findAll();
    }

    public Optional<Astrologer> getAstrologerById(Long id) {
        return astrologerRepository.findById(id);
    }

    public Astrologer getAstrologerByEmail(String email) {
        return astrologerRepository.findByEmail(email);
    }

    public void deleteAstrologer(Long id) {
        astrologerRepository.deleteById(id);
    }
    public AstrologerImages insertAisro (MultipartFile files,AstrologerImages astrologerImages)throws IOException {
    	astrologerImages.setImageData(files.getBytes());
    	astrologerImages.setImageData(files.getBytes());
    	astrologerImages.setType(files.getContentType());
    	astrologerImages.setName(files.getOriginalFilename());
    	astrologerImages=astrologerImageRepo.save(astrologerImages);
    	return astrologerImages;
    }
    public AstrologerImages convertToByte (MultipartFile files,AstrologerImages astrologerImages)throws IOException {
    	astrologerImages.setImageData(files.getBytes());
    	astrologerImages.setImageData(files.getBytes());
    	astrologerImages.setType(files.getContentType());
    	astrologerImages.setName(files.getOriginalFilename());
    	//astrologerImages=astrologerImageRepo.save(astrologerImages);
    	return astrologerImages;
    }
    public Astrologer getByAustId(Long id) {
    	return astrologerRepository.findById(id).orElse(null);
    }
}

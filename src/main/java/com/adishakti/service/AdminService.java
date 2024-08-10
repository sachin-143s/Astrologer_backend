package com.adishakti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adishakti.dao.AdminRepository;
import com.adishakti.entity.Admin;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }
    
    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}

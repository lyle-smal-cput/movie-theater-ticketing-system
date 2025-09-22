package za.ac.cput.service;

/*
 AdminService.java
 Admin Service class
 Author: LJ Smal (223236012)
     Date: 25 May 2025 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepository;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin read(Long string) {
        return adminRepository.findById(string)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found with id: " + string));
    }

    public List <Admin> readByEmail(String string) {
        return adminRepository.findByEmail(string);
    }

    public Admin readByUsername(String string) {
        return adminRepository.findByUsername(string);
    }

    @Override
    public Admin update(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public boolean delete(Long string) {
        adminRepository.deleteById(string);
        return true;
    }

}

package za.ac.cput.controller;
/*
AdminController.java
 Admin Controller class
 Author: LJ Smal (223236012)
 Date: 25 May 2025
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.config.JwtUtil;
import za.ac.cput.domain.Admin;
import za.ac.cput.service.AdminService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService service;
    private final JwtUtil jwtUtil;

    @Autowired
    public AdminController(AdminService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/create")
    public Object create(@RequestBody Admin admin) {
        // Create admin first
        Admin createdAdmin = service.create(admin);

        // Generate a JWT token for the created admin
        String token = jwtUtil.generateToken(createdAdmin.getUsername(), "ADMIN");

        // Return both user info and token
        return Map.of(
                "userId", createdAdmin.getUserId(),
                "username", createdAdmin.getUsername(),
                "role", "ADMIN",
                "token", token
        );
    }

    @GetMapping("/read/{userId}")
    public Admin read(@PathVariable Long userId) {
        return service.read(userId);
    }

    @GetMapping("/readByEmail/{email}")
    public List<Admin> readByEmail(@PathVariable String email) {
        return service.readByEmail(email);
    }

    @GetMapping("/readByUsername/{username}")
    public Admin readByUsername(@PathVariable String username) {
        return service.readByUsername(username);
    }

    @PutMapping("/update")
    public Admin update(@RequestBody Admin admin) {
        return service.update(admin);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable Long userId) {
        return service.delete(userId);
    }

    @GetMapping("/getAll")
    public List<Admin> getAll() {
        return service.getAll();
    }
}

package za.ac.cput.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.config.JwtUtil;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.AdminRepository;
import za.ac.cput.repository.CustomerRepository;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManager authManager;
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(
            AuthenticationManager authManager,
            AdminRepository adminRepository,
            CustomerRepository customerRepository,
            JwtUtil jwtUtil
    ) {
        this.authManager = authManager;
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            logger.info("Hit the endpoint");

            if (authentication.isAuthenticated()) {
                Admin admin = adminRepository.findByUsername(request.getUsername());
                if (admin != null) {
                    logger.info("this is admin: {}", admin);

                    String token = jwtUtil.generateToken(admin.getUsername(), "ADMIN");
                    return Map.of(
                            "userId", admin.getUserId(),
                            "username", admin.getUsername(),
                            "role", "ADMIN",
                            "token", token
                    );
                }

                Customer customer = customerRepository.findByUsername(request.getUsername());
                if (customer != null) {
                    logger.info("this is customer: {}", customer);

                    String token = jwtUtil.generateToken(customer.getUsername(), "CUSTOMER");
                    return Map.of(
                            "userId", customer.getUserId(),
                            "username", customer.getUsername(),
                            "role", "CUSTOMER",
                            "token", token
                    );
                }

                throw new RuntimeException("User not found after authentication");
            } else {
                throw new RuntimeException("Invalid credentials");
            }

        } catch (AuthenticationException e) {
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }

    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}

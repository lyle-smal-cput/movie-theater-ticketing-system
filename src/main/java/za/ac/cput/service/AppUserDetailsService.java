package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.AdminPrincipal;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerPrincipal;
import za.ac.cput.repository.AdminRepository;
import za.ac.cput.repository.CustomerRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AppUserDetailsService(AdminRepository adminRepository, CustomerRepository customerRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            return new AdminPrincipal(admin);
        }

        Customer customer = customerRepository.findByUsername(username);
        if (customer != null) {
            return new CustomerPrincipal(customer);
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}

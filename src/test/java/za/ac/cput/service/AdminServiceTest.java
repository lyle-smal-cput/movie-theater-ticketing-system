package za.ac.cput.service;
/*
 AdminServiceTest.java
 Admin Service Test class
 Author: LJ Smal (223236012)
     Date: 25 May 2025 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.HouseFactory;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceTest {
    Admin admin = AdminFactory.createAdmin("admin123", "password", "Admin", "User", "lylesmal@gmail.com", HouseFactory.createHouse("1234", "123 Main St", "Southfield", "Cape Town", "South Africa", (short) 7880), "+27678074872", "male", LocalDate.of(1990, 1, 1), true);
@Autowired
    private AdminService adminService;

@Test
    void getAll() {
         List<Admin> admins = adminService.getAll();
         assertNotNull(admins);
         assertFalse(admins.isEmpty());
    }

    @Test
    void create() {
        Admin createdAdmin = adminService.create(admin);
        assertNotNull(createdAdmin);
        assertEquals(admin.getUserId(), createdAdmin.getUserId());
        assertEquals(admin.getEmail(), createdAdmin.getEmail());
    }

    @Test
    void read() {
        Admin createdAdmin = adminService.create(admin);
        Admin readAdmin = adminService.read(createdAdmin.getUserId());
        assertNotNull(readAdmin);
        assertEquals(createdAdmin.getUserId(), readAdmin.getUserId());
        assertEquals(createdAdmin.getEmail(), readAdmin.getEmail());
    }

    @Test
    void update() {
        Admin createdAdmin = adminService.create(admin);
        Admin updateAdmin= new Admin.Builder().copy(createdAdmin).setFirstName("new name").build();
        Admin updatedAdmin = adminService.update(updateAdmin);
        assertNotNull(updatedAdmin);
        assertEquals(updateAdmin.getFirstName(), updatedAdmin.getFirstName());
        assertEquals(createdAdmin.getUserId(), updatedAdmin.getUserId());
        assertEquals(createdAdmin.getEmail(), updatedAdmin.getEmail());
    }

    @Test
    void delete() {
        Admin createdAdmin = adminService.create(admin);
        boolean isDeleted = adminService.delete(createdAdmin.getUserId());
        assertTrue(isDeleted);
        assertThrows(IllegalArgumentException.class, () -> adminService.read(createdAdmin.getUserId()));
    }
}
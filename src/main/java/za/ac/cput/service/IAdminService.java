package za.ac.cput.service;

/*
 IAdminService.java
 Admin Service Interface
 Author: LJ Smal (223236012)
     Date: 25 May 2025 */

import za.ac.cput.domain.Admin;

import java.util.List;

public interface IAdminService extends IService<Admin, Long> {
    List<Admin> getAll();
}

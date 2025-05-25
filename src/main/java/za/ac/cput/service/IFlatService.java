package za.ac.cput.service;
/* Flat Interface Service .java
     Flat Service interface
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import za.ac.cput.domain.Flat;

import java.util.List;

public interface IFlatService extends IService<Flat, String> {
    List<Flat> getAll();
}
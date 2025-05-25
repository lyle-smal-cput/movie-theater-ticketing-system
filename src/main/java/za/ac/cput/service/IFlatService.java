package za.ac.cput.service;

import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Flat;

import java.util.List;

public interface IFlatService extends IService<Flat, String> {
    List<Flat> getAll();
}
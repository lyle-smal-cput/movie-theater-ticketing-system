package za.ac.cput.service;

import za.ac.cput.domain.House;
import java.util.List;

public interface IHouseService extends IService<House, String> {
    List<House> getAll();
}

package za.ac.cput.service;
/* House Service.java
     House Service class
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.House;
import za.ac.cput.repository.HouseRepository;
import java.util.List;

@Service
public class HouseService implements IHouseService {
    private final HouseRepository repository;

    @Autowired
    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    @Override
    public House create(House house) {
        return this.repository.save(house);
    }

    @Override
    public House read(Long addressId) {
        return this.repository.findById(addressId).orElse(null);
    }

    @Override
    public House update(House house) {
        if (this.repository.existsById(house.getAddressId()))
            return this.repository.save(house);
        return null;
    }

    @Override
    public boolean delete(Long addressId) {
        if (this.repository.existsById(addressId)) {
            this.repository.deleteById(addressId);
            return true;
        }
        return false;
    }

    @Override
    public List<House> getAll() {
        return this.repository.findAll();
    }
}

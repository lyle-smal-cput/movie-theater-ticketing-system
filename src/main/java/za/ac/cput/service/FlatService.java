package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Flat;
import za.ac.cput.repository.FlatRepository;
import java.util.List;

@Service
public class FlatService implements IFlatService{
    private final FlatRepository repository;

    @Autowired
    public FlatService(FlatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flat create(Flat flat) {
        return this.repository.save(flat);
    }

    @Override
    public Flat read(String addressId) {
        return this.repository.findById(addressId).orElse(null);
    }

    @Override
    public Flat update(Flat flat) {
        if (this.repository.existsById(flat.getAddressId()))
            return this.repository.save(flat);
        return null;
    }

    @Override
    public boolean delete(String addressId) {
        if (this.repository.existsById(addressId)) {
            this.repository.deleteById(addressId);
            return true;
        }
        return false;
    }

    @Override
    public List<Flat> getAll() {
        return this.repository.findAll();
    }

}

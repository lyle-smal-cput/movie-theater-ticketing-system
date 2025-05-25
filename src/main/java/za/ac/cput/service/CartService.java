package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository repository;

    @Override
    public Cart create(Cart cart) {
        return this.repository.save(cart);
    }

    @Override
    public Cart read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Cart update(Cart cart) {
        return this.repository.save(cart);
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<Cart> getAll() {
        return this.repository.findAll();
    }
}

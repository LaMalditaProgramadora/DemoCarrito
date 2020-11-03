package pe.edu.upc.spring.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.spring.model.Cart;
import pe.edu.upc.spring.model.Product;
import pe.edu.upc.spring.repository.ICartRepository;
import pe.edu.upc.spring.service.ICartService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Override
    public Cart getById(Integer idCart) {
        return cartRepository.findById(idCart).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Product> getProducts(Integer idCart) {
        Cart cart = cartRepository.findById(idCart).orElseThrow(EntityNotFoundException::new);
        return cart.getProducts();
    }
}

package pe.edu.upc.spring.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.spring.model.Cart;
import pe.edu.upc.spring.model.Product;
import pe.edu.upc.spring.repository.ICartRepository;
import pe.edu.upc.spring.repository.IProductRepository;
import pe.edu.upc.spring.service.IProductService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICartRepository cartRepository;

    @Override
    @Transactional
    public Cart assignProductCart(Integer idProduct, Integer idCart) {
        Product product = productRepository.findById(idProduct).orElseThrow(EntityNotFoundException::new);

        return cartRepository.findById(idCart).map(cart->{
            if(!cart.getProducts().contains(product)){
                cart.getProducts().add(product);
                return cartRepository.save(cart);
            }
            return cart;
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllByCartId(Integer idCart) {
        return cartRepository.findById(idCart).map(cart->{
            List<Product> products = cart.getProducts();
            return products;
        }).orElseThrow(EntityNotFoundException::new);
    }
}

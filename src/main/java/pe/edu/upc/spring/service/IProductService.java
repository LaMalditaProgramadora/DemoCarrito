package pe.edu.upc.spring.service;

import pe.edu.upc.spring.model.Cart;
import pe.edu.upc.spring.model.Product;

import java.util.List;

public interface IProductService {
    Cart assignProductCart(Integer idProduct, Integer idCart);
    List<Product> getAll();
    List<Product> getAllByCartId(Integer idCart);
}

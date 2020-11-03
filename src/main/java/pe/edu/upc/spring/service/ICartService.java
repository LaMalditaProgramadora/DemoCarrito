package pe.edu.upc.spring.service;

import pe.edu.upc.spring.model.Cart;
import pe.edu.upc.spring.model.Product;

import java.util.List;

public interface ICartService {
    Cart getById(Integer idCart);
    List<Product> getProducts(Integer idCart);
}

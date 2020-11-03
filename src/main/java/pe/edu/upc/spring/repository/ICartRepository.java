package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.spring.model.Cart;
import pe.edu.upc.spring.model.Product;

import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {
}

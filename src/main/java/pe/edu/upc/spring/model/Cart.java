package pe.edu.upc.spring.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "carritos")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCart;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "carrito_producto", joinColumns = @JoinColumn(name = "idCart"),
            inverseJoinColumns = @JoinColumn(name = "idProduct") )
    private List<Product> products;

    public Cart(int idCart, List<Product> products) {
        this.idCart = idCart;
        this.products = products;
    }

    public Cart() {
    }

    public int getIdCart() {
        return idCart;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

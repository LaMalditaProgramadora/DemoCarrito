package pe.edu.upc.spring.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @NotEmpty(message = "No puede estar vacío")
    @NotBlank(message = "No puede estar vacío")
    @Column(name = "nombres_product", length = 60, nullable = false)
    private String nameProduct;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts;

    public Product(int idProduct, @NotEmpty(message = "No puede estar vacío") @NotBlank(message = "No puede estar vacío") String nameProduct, List<Cart> carts) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.carts = carts;
    }

    public Product() {
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }
}

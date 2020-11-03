package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.upc.spring.service.IProductService;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/bienvenido")
    public String iProductBienvenido() {
        return "bienvenido";
    }

    @RequestMapping("/")
    public String irProductos(Map<String, Object> model) {
        model.put("listaProductos", productService.getAll());
        return "listProducts";
    }

    @RequestMapping("/agregarCarrito")
    public String agregarCarrito(
            Map<String, Object> model,
            @RequestParam(value = "idProduct") Integer idProduct,
            @RequestParam(value = "idCart") Integer idCart) {
        try {
            if (idCart != null && idCart > 0) {
                productService.assignProductCart(idProduct, idCart);
                model.put("listaProductos", productService.getAll());
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            model.put("mensaje", "Ocurrió un error");
            model.put("listaProductos", productService.getAll());
        }
        return "listProducts";
    }

}

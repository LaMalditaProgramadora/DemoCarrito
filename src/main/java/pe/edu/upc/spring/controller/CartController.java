package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.spring.service.ICartService;
import pe.edu.upc.spring.service.IProductService;

import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @RequestMapping("/bienvenido")
    public String iCRTBienvenido() {
        return "bienvenido";
    }

    @RequestMapping("/")
    public String irCarrito(Map<String, Object> model) {
        model.put("listaCarrito", cartService.getById(1));
        return "listCart";
    }
}

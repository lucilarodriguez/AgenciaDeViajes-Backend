
package com.example.demo.controladores;

import com.example.demo.entidades.Producto;
import com.example.demo.servicios.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProductoControlador {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/")
    public String index(ModelMap modelo) {
        List<Producto> productos = productoService.obtenerProductos();
        modelo.addAllAttributes(productos);
        return  "index.html";
    }
    
    
}

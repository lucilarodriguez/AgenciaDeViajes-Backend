
package com.example.demo.controladores;

import com.example.demo.entidades.DetalleReserva;
import com.example.demo.entidades.Producto;
import com.example.demo.servicios.DetalleReservaService;
import com.example.demo.servicios.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DetalleReservaControlador {

    public static List<DetalleReserva> obtenerDetalleReserva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Autowired
    private DetalleReservaService  detalleReservaService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/detallereserva")
    public List<DetalleReserva> index(ModelMap modelo) {
        List<DetalleReserva> detalle = (List<DetalleReserva>) detalleReservaService;
        
        return detalle;
    }
}

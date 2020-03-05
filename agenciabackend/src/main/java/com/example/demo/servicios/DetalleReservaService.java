
package com.example.demo.servicios;

import com.example.demo.controladores.DetalleReservaControlador;
import com.example.demo.entidades.DetalleReserva;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.Reserva;
import java.util.List;


public class DetalleReservaService {
   
      public List<DetalleReserva> obtenerDetalleReserva() {
        return DetalleReservaControlador.obtenerDetalleReserva();
        
    }
    
    
    
    
 
    
    
    
    
}

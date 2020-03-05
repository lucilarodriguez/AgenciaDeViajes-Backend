/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicios;

import com.example.demo.controladores.ProductoControlador;
import com.example.demo.entidades.DetalleReserva;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class PagoService {
    
  public void pagar() throws MPConfException, MPException{
      PagoService ps= new PagoService();
      //DetalleReservaService detallereservaservice = new DetalleReservaService();
      ProductoControlador pc= new ProductoControlador();
        // Agrega credenciales
        MercadoPago.SDK.setAccessToken("ACCESS_TOKEN");
        
        // Crea un objeto de preferencia
        Preference preference = new Preference();

        // Crea un ítem en la preferencia
        Item item = new Item();
        item.setTitle(ps.titulo())
            .setQuantity(1)
            .setUnitPrice((float)ps.precioFinal() );
        preference.appendItem(item);
        if(preference.setAutoReturn(Preference.AutoReturn.approved).equals(true)){
            //GUARDAR EN BASE DE DATOS
        }
        
        /*   PARA AGREGAR AL BOTON PAGAR
        <form action="/procesar-pago" method="POST">
  <script
   src="https://www.mercadopago.com.mx/integrations/v1/web-payment-checkout.js"
   data-preference-id="${preference.id}">
  </script>
</form>
        */
      
  }
  
  public float precioFinal ( ){
     DetalleReservaService detalleReservaService= new DetalleReservaService();
      
      List <DetalleReserva> a= detalleReservaService.obtenerDetalleReserva();
      float preciofinal=0;
      for (DetalleReserva detalleReserva : a) {
          preciofinal += detalleReserva.getCantidadDePersonas()*detalleReserva.getProducto().getPrecio();
      }
      return preciofinal;
  }
    public String titulo ( ){
     DetalleReservaService detalleReservaService= new DetalleReservaService();
      
      List <DetalleReserva> a= detalleReservaService.obtenerDetalleReserva();
      String titulo="";
      for (DetalleReserva detalleReserva : a) {
          titulo += detalleReserva.getProducto().getNombre()+" X "+detalleReserva.getCantidadDePersonas().toString()+ "/ ";
      }
      return titulo;
  }
    
}




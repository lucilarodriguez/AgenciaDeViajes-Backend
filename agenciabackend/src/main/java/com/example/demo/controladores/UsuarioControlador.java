
package com.example.demo.controladores;

import Error.ErrorService;
import com.example.demo.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioService usuarioservice;
    @Autowired
    private Object UsuarioServicie;
    
    @PostMapping("/reserva")
    public String obtenerusuario(ModelMap modelo,@RequestParam String nombre, @RequestParam String apellido, @RequestParam String mail, @RequestParam String dni, @RequestParam Integer telefono){
      
        try {
            usuarioservice.usuario(nombre, apellido, mail,dni,telefono);
        } catch (ErrorService ex) {
         
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("mail", mail);
            modelo.put("dni", dni);
            modelo.put("telefono", telefono);
            
            return "reserva.html";
        }
        
        modelo.put("titulo", "datos del ususario");
        modelo.put("descripcion", "Tu usuario fue registrado de manera satisfactoria");
        return "exito.html";
    }
}

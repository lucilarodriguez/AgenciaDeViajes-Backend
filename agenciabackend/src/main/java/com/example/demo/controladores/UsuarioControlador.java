
package com.example.demo.controladores;

import com.example.demo.servicios.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioService usuarioService;
     @GetMapping("/")
    public String index(){
        return "index.html";
    }
    
       @PostMapping("/reserva")
    public String usuario(ModelMap modelo, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String mail, @RequestParam String dni, @RequestParam Integer telefono){
      
        try {
            usuarioService.Registrar( nombre, apellido, mail, dni, telefono);
        } catch (ErrorServicio ex) {
          
      

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("mail", mail);
            modelo.put("dni", dni);
            modelo.put("telefono", telefono);
            
            return "reserva.html";
        }
        
        modelo.put("titulo", "Usuario Registrado.");
        modelo.put("descripcion", "Tu usuario fue registrado de manera satisfactoria");
        return "exito.html";
    }
    
}


package com.example.demo.servicios;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import com.example.demo.entidades.Usuario;
import com.example.demo.errores.ErrorServicio;
import com.example.demo.repositorios.ProductoRepositorio;
import com.example.demo.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioService {
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
@Transactional  
    public void Registrar( String nombre, String apellido, String mail, String dni, Integer telefono) throws ErrorService{
        
        
        validar(nombre, apellido, mail, dni, telefono);
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(mail);
        usuario.setTelefono(telefono);

        usuarioRepositorio.save(usuario);
        
        //notificacionservice.enviar("Bienvenidos al Tinder pibes", "Tinder de animalitos",usuario.getMail());
    }
    
private void validar(String nombre, String apellido,String mail,String dni,Integer telefono) throws ErrorServicio{
         if (nombre == null || nombre.isEmpty()){
             throw new ErrorServicio ("Es obligatorio completar el campo nombre.");
         }
         if (apellido == null || apellido.isEmpty()){
             throw new ErrorServicio ("Es obligatorio completar el campo apellido.");
         }
         if (dni == null || dni.isEmpty()){
             throw new ErrorServicio ("Es obligatorio completar el campo dni.");
         }
         if (telefono == null){
             throw new ErrorServicio ("Es obligatorio completar el campo de telefono");
         }
    
     
     }
    
    
   
    
    }
            
  
    
     


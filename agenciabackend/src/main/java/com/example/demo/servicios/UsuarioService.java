
package com.example.demo.servicios;

import Error.ErrorService;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import com.example.demo.entidades.Usuario;
import com.example.demo.repositorios.ProductoRepositorio;
import com.example.demo.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UsuarioService  {
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
 @Transactional  
    public void usuario( String nombre, String apellido, String mail, String dni, Integer telefono) throws ErrorService{
       
        
        validar(nombre, apellido, mail, dni);
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(mail);
        usuario.setTelefono(telefono);
           
        usuarioRepositorio.save(usuario);

    }

   public void validar(String nombre, String apellido, String mail, String dni) throws ErrorService{
             if(nombre == null || nombre.isEmpty()){
            throw new ErrorService("nombre nulo");
        }
         if(apellido == null || apellido.isEmpty()){
            throw new ErrorService("apellido nulo");
        }
         if(mail == null || mail.isEmpty()){
            throw new ErrorService("mail no valido");
        }
         if(dni == null || dni.isEmpty()){
            throw new ErrorService("documento no valido");
        }
        
    }
    

    
    
   
    
    }
            
  
    
     


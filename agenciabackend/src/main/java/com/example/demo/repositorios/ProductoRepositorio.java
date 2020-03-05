
package com.example.demo.repositorios;

import com.example.demo.entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String>{
    @Query("SELECT c FROM Producto c")
    public List<Producto> obtenerProductos();
  
    @Query("SELECT c FROM Producto c WHERE c.id = :id")
    public Producto obtenerProducto(@Param("id")Integer id);
    
}


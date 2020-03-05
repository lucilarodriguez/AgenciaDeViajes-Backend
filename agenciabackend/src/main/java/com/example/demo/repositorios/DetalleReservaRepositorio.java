
package com.example.demo.repositorios;

import com.example.demo.entidades.DetalleReserva;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleReservaRepositorio extends JpaRepository<DetalleReserva, String>{
    @Query("SELECT c FROM DetalleReserva c")
    public List<DetalleReserva> obtenerDetalleReserva();
}
package com.example.FrankySabado.Repositorios;

import com.example.FrankySabado.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEstudianteRepositorio extends JpaRepository<Estudiante,Integer> {

    List<Estudiante> finByPromedio(Double promedio);
    Optional<Estudiante> finByNombre(String nombre);
    Optional<Estudiante> finByCorreo(String correo);


}

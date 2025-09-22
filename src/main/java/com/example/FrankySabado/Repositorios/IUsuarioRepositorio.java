package com.example.FrankySabado.Repositorios;

import com.example.FrankySabado.modelos.Matricula;
import com.example.FrankySabado.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepositorio extends JpaRepository <Usuario,Integer>{

    //cuando salen mas resultados
    List<Usuario> finByCorreo (String correo);

    //cuando lo resultados son 0 o 1
    Optional <Usuario> findByNombre (String nombre);
    Optional <Usuario> findById (Integer id);
    Optional <Usuario> findBycorreo (String correo);


}

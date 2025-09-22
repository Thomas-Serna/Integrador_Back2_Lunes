package com.example.FrankySabado.servicios;

import com.example.FrankySabado.Repositorios.IUsuarioRepositorio;
import com.example.FrankySabado.modelos.Usuario;
import com.example.FrankySabado.modelos.dtos.UsuarioGenericoDTO;
import com.example.FrankySabado.modelos.mapas.IUsuarioMapa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    //1.Lamar al repositorio
    //INYECTAR UNA DEPENDENCIA AL REPOSITORIO
    @Autowired
    IUsuarioRepositorio repositorio;
    @Autowired
    IUsuarioMapa mapa;

    //1. Servicio para guardar usuario
    public UsuarioGenericoDTO guardarUsuario(Usuario datosUsuario)throws Exception{
        try {
            return this.mapa.convertir_a_dto_generico(this.repositorio.save(datosUsuario));
        }catch (Exception error) {
            throw new Exception("upss fallamos"+error.getMessage());
        }
        }

        //2, Servicio para buscar todos los usuarios
    public List<UsuarioGenericoDTO>buscarUsuarios()throws Exception{
        try{
            return this.mapa.convertir_lista_generico_dto(this.repositorio.findAll());
        }catch (Exception error) {
            throw new Exception("upss fallamos"+error.getMessage());
        }
    }

    //3.Servicio para buscar un usuario si me dan su id
    public UsuarioGenericoDTO buscarUsuarioPorId(Integer id)throws Exception{
        try{
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if(usuarioBuscado.isPresent()){//si si esta
                return this.mapa.convertir_a_dto_generico(usuarioBuscado.get());
            }else {//si no esta
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error) {
            throw new Exception("upss fallamos"+error.getMessage());
        }
    }

    //Buscar por correo
    public UsuarioGenericoDTO buscarUsuarioPorCorreo(String correo)throws Exception{
        try{
            Optional<Usuario> usuarioBuscado=this.repositorio.findBycorreo(correo);
            if(usuarioBuscado.isPresent()){//si si esta
                return this.mapa.convertir_a_dto_generico(usuarioBuscado.get());
            }else {//si no esta
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error) {
            throw new Exception("upss fallamos"+error.getMessage());
        }
    }
    }
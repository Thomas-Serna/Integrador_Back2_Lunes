package com.example.FrankySabado.servicios;

import com.example.FrankySabado.Repositorios.IEstudianteRepositorio;
import com.example.FrankySabado.modelos.Estudiante;
import com.example.FrankySabado.modelos.dtos.EstudianteDTO;
import com.example.FrankySabado.modelos.mapas.IEstudianteMapa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {

    @Autowired
    IEstudianteRepositorio repositorio ;
    @Autowired
    IEstudianteMapa mapa;

    public EstudianteDTO guardarEstudiante(Estudiante datosEstudiante)throws Exception{
        try {
            return this.mapa.convertir_a_dto(this.repositorio.save(datosEstudiante));
        }catch (Exception error) {
            throw new Exception("upss fallamos"+error.getMessage());
        }
    }

    //2, Servicio para buscar todos los estudiantes
    public List<EstudianteDTO> buscarEstudiantes()throws Exception{
        try{
            return this.mapa.convertir_a_lista_dto(this.repositorio.findAll());
        }catch (Exception error) {
            throw new Exception("upss fallamos"+error.getMessage());
        }
    }

    //3.Servicio para buscar un estudiante si me dan su nombre
    public EstudianteDTO buscarEstudiantePorNombre(String nombre)throws Exception{
        try{
            Optional<Estudiante> EstudianteBuscado=this.repositorio.finByNombre(nombre);
            if(EstudianteBuscado.isPresent()){//si si esta
                return this.mapa.convertir_a_dto(EstudianteBuscado.get());
            }else {//si no esta
                throw new Exception("Estudiante no encontrado");
            }
        }catch (Exception error) {
            throw new Exception("upss fallamos"+error.getMessage());
        }
    }

    //4.Servicio para buscar un estudiante si me dan su correo
    public EstudianteDTO buscarEstudiantePorCorreo(String correo)throws Exception{
        try{
            Optional<Estudiante> EstudianteBuscado=this.repositorio.finByCorreo(correo);
            if(EstudianteBuscado.isPresent()){//si si esta
                return this.mapa.convertir_a_dto(EstudianteBuscado.get());
            }else {//si no esta
                throw new Exception("Estudiante no encontrado");
            }
        }catch (Exception error) {
            throw new Exception("upss fallamos"+error.getMessage());
        }
    }

}

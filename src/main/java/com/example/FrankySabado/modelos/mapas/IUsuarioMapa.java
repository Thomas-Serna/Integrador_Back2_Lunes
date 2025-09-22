package com.example.FrankySabado.modelos.mapas;

import com.example.FrankySabado.modelos.Estudiante;
import com.example.FrankySabado.modelos.Usuario;
import com.example.FrankySabado.modelos.dtos.EstudianteDTO;
import com.example.FrankySabado.modelos.dtos.UsuarioEspecialDTO;
import com.example.FrankySabado.modelos.dtos.UsuarioGenericoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUsuarioMapa {

    @Mapping(source="nombre",target ="nombre")
    @Mapping(source="correo",target ="correo")
    @Mapping(source="rol",target ="rol")
    UsuarioGenericoDTO convertir_a_dto_generico(Usuario usuario);
    List<UsuarioGenericoDTO>convertir_lista_generico_dto(List<Usuario>Lista);

    @Mapping(source="id",target ="id")
    @Mapping(source="nombre",target ="nombre")
    @Mapping(source="contraseña",target ="contraseña")
    UsuarioEspecialDTO convertir_a_dto_especial(Usuario usuario);
    List<UsuarioEspecialDTO>convertir_lista_especial_dto(List<Usuario>Lista);
}

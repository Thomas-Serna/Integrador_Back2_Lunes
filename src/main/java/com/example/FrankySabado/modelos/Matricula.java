package com.example.FrankySabado.modelos;

import com.example.FrankySabado.modelos.dtos.EstudianteDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "estudiante_id", nullable = false, unique = true)
    private String estudiante_id;
    @Column(name = "materia_id", nullable = false, unique = true)
    private String materia_id;
    @Column(name = "grupo_id", nullable = false, unique = true)
    private String grupo_id;
    @Column(name = "periodo", nullable = false, unique = true)
    private int periodo;

    public Matricula() {
    }

    public Matricula(Integer id, String estudiante_id, String materia_id, String grupo_id, int periodo) {
        this.id = id;
        this.estudiante_id = estudiante_id;
        this.materia_id = materia_id;
        this.grupo_id = grupo_id;
        this.periodo = periodo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(String estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public String getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(String materia_id) {
        this.materia_id = materia_id;
    }

    public String getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(String grupo_id) {
        this.grupo_id = grupo_id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    //Relacion con tabla estudiante
    @OneToOne
    @JsonManagedReference(value = "relacionestudiantematricula")
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id")
    private Estudiante estudiante;

    //Relacion con tabla usuario
    @OneToOne
    @JsonManagedReference(value = "relacionusuariomatricula")
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    private Usuario usuario;

    //Relacion con tabla materia
    @OneToMany(mappedBy = "materia")
    @JsonManagedReference(value = "relacionmatriculamateria")
    private ArrayList<Materia> materias;
}
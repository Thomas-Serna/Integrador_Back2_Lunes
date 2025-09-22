package com.example.FrankySabado.modelos.dtos;

import java.time.LocalDate;

public class EstudianteDTO {
    private String nombre;
    private String correo;
    private Double promedio;
    private LocalDate fechaNacimiento;

    public EstudianteDTO() {
    }

    public EstudianteDTO(String nombre, String correo, Double promedio, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.correo = correo;
        this.promedio = promedio;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

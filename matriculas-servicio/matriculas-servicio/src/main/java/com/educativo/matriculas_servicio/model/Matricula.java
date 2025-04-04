package com.educativo.matriculas_servicio.model;

public class Matricula {
    private String id;
    private String estudianteId;
    private String asignaturaId;
    private String fechaRegistro;

    public Matricula() {
    }

    public Matricula(String id, String estudianteId, String asignaturaId, String fechaRegistro) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.asignaturaId = asignaturaId;
        this.fechaRegistro = fechaRegistro;
    }

    public String getId() {
        return id;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public String getAsignaturaId() {
        return asignaturaId;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }

    public void setAsignaturaId(String asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
package com.educativo.matriculas_servicio.dto;

public class MatriculaRespuestaDTO {
    private UsuarioDTO usuario;
    private AsignaturaDTO asignatura;

    public MatriculaRespuestaDTO(UsuarioDTO usuario, AsignaturaDTO asignatura) {
        this.usuario = usuario;
        this.asignatura = asignatura;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public AsignaturaDTO getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturaDTO asignatura) {
        this.asignatura = asignatura;
    }
}
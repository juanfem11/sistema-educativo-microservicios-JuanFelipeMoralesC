package com.educativo.matriculas_servicio.service;

import com.educativo.matriculas_servicio.clientes.UsuarioClient;
import com.educativo.matriculas_servicio.clientes.AsignaturaClient;
import com.educativo.matriculas_servicio.dto.UsuarioDTO;
import com.educativo.matriculas_servicio.dto.AsignaturaDTO;
import com.educativo.matriculas_servicio.model.Matricula;
import com.educativo.matriculas_servicio.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final UsuarioClient usuarioClient;
    private final AsignaturaClient asignaturaClient;

    public MatriculaService(MatriculaRepository matriculaRepository,
            UsuarioClient usuarioClient,
            AsignaturaClient asignaturaClient) {
        this.matriculaRepository = matriculaRepository;
        this.usuarioClient = usuarioClient;
        this.asignaturaClient = asignaturaClient;
    }

    public Matricula registrarMatricula(String estudianteId, String asignaturaId) {
        UsuarioDTO usuario = usuarioClient.obtenerUsuarioPorId(estudianteId);
        AsignaturaDTO asignatura = asignaturaClient.obtenerAsignaturaPorId(asignaturaId);

        if (usuario == null || asignatura == null) {
            throw new RuntimeException("No se encontraron los datos requeridos");
        }

        Matricula matricula = new Matricula();
        matricula.setEstudianteId(estudianteId);
        matricula.setAsignaturaId(asignaturaId);
        matricula.setFechaRegistro("2024/04/04");

        return matriculaRepository.save(matricula);
    }

    public Optional<Matricula> obtenerMatriculaPorId(String id) {
        return matriculaRepository.findById(id);
    }
}
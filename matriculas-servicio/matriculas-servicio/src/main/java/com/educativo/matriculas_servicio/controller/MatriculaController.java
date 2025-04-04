package com.educativo.matriculas_servicio.controller;

import com.educativo.matriculas_servicio.clientes.UsuarioClient;
import com.educativo.matriculas_servicio.clientes.AsignaturaClient;
import com.educativo.matriculas_servicio.dto.*;
import com.educativo.matriculas_servicio.model.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private AsignaturaClient asignaturaClient;

    @GetMapping("/test")
    public String test() {
        return "Servicio de matrículas funcionando!";
    }

    @GetMapping
    public List<Matricula> listarMatriculas() {
        return Arrays.asList(
                new Matricula("1", "1", "1", "2024/04/01"),
                new Matricula("2", "2", "2", "2024/04/02"));
    }

    @GetMapping("/{usuarioId}/{asignaturaId}")
    public ResponseEntity<?> obtenerMatricula(
            @PathVariable String usuarioId,
            @PathVariable String asignaturaId) {

        UsuarioDTO usuario = usuarioClient.obtenerUsuarioPorId(usuarioId);
        AsignaturaDTO asignatura = asignaturaClient.obtenerAsignaturaPorId(asignaturaId);

        return ResponseEntity.ok(new MatriculaRespuestaDTO(usuario, asignatura));
    }
}
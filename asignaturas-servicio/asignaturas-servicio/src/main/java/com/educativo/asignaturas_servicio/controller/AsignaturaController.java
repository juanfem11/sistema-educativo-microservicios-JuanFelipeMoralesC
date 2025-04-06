package com.educativo.asignaturas_servicio.controller;

import com.educativo.asignaturas_servicio.model.Asignatura;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    private final List<Asignatura> asignaturas = Arrays.asList(
            new Asignatura(1, "Matemáticas", 4),
            new Asignatura(2, "Física", 3),
            new Asignatura(3, "Química", 4));

    @GetMapping
    public List<Asignatura> obtenerAsignaturas() {
        return asignaturas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerAsignaturaPorId(@PathVariable int id) {
        Optional<Asignatura> asignatura = asignaturas.stream()
                .filter(a -> a.getId() == id)
                .findFirst();

        return asignatura
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
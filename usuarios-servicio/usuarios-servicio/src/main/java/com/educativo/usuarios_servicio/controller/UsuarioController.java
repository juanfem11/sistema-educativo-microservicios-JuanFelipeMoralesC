package com.educativo.usuarios_servicio.controller;

import com.educativo.usuarios_servicio.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // Lista simulada de usuarios
    private final List<Usuario> usuarios = Arrays.asList(
            new Usuario(1, "Juan Felipe Morales"),
            new Usuario(2, "Maria Antonia Zapata"),
            new Usuario(3, "Carlos Andrés Alzate"));

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    // Obtener un usuario específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable int id) {
        Optional<Usuario> usuarioEncontrado = usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst();

        return usuarioEncontrado
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
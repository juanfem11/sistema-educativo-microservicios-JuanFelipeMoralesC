package com.educativo.usuarios_servicio.controller;

import com.educativo.usuarios_servicio.model.Usuario;
import com.educativo.usuarios_servicio.security.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final List<Usuario> usuarios = Arrays.asList(
            new Usuario("1", "Juan Felipe Morales", "juan@email.com", "password123"),
            new Usuario("2", "Maria Antonia Zapata", "maria@email.com", "password456"),
            new Usuario("3", "Carlos Andrés Alzate", "carlos@email.com", "password789"));

    @GetMapping("/{email}")
    public Optional<Usuario> obtenerUsuarioPorEmail(@PathVariable String email) {
        return usuarios.stream()
                .filter(usuario -> usuario.getEmail().equals(email))
                .findFirst();
    }
}

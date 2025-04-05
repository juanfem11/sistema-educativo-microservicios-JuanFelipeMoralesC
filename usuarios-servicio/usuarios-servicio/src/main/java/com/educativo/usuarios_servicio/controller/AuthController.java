package com.educativo.usuarios_servicio.controller;

import com.educativo.usuarios_servicio.model.Usuario;
import com.educativo.usuarios_servicio.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    private final List<Usuario> usuarios = Arrays.asList(
            new Usuario("1", "Juan Felipe Morales", "juan@email.com", "password123"),
            new Usuario("2", "Maria Antonia Zapata", "maria@email.com", "password456"),
            new Usuario("3", "Carlos Andrés Alzate", "carlos@email.com", "password789"));

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
        Optional<Usuario> usuarioOpt = usuarios.stream()
                .filter(usuario -> usuario.getEmail().equals(loginRequest.getEmail()) &&
                        usuario.getPassword().equals(loginRequest.getPassword()))
                .findFirst();

        if (usuarioOpt.isPresent()) {
            String token = jwtUtil.generateToken(usuarioOpt.get().getEmail(), "USER");
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}

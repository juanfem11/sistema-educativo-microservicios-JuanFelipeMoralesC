package com.educativo.matriculas_servicio.clientes;

import com.educativo.matriculas_servicio.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-servicio", url = "http://usuarios-servicio:8081")
public interface UsuarioClient {
    @GetMapping("/usuarios/{id}")
    UsuarioDTO obtenerUsuarioPorId(@PathVariable String id);
}
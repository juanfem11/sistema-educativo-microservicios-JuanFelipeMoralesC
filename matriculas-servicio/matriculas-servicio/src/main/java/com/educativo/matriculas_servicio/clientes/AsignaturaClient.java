package com.educativo.matriculas_servicio.clientes;

import com.educativo.matriculas_servicio.dto.AsignaturaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio", url = "http://asignaturas-servicio:8082")
public interface AsignaturaClient {
    @GetMapping("/asignaturas/{id}")
    AsignaturaDTO obtenerAsignaturaPorId(@PathVariable String id);
}
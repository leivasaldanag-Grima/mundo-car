package com.mundocar.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.mundocar.service.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    private final EstadoService service;
    public EstadoController(EstadoService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<JsonNode> obtener() {
        JsonNode estado = service.leer();
        return estado == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(estado);
    }

    @PutMapping
    public ResponseEntity<Void> guardar(@RequestBody JsonNode estado) {
        service.guardar(estado);
        return ResponseEntity.noContent().build();
    }
}

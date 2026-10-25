package com.mundocar.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.mundocar.service.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Vista JSON del módulo. Las modificaciones se guardan con PUT /api/estado. */
@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {
    private final EstadoService service;
    public DiagnosticoController(EstadoService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<JsonNode> listar() {
        JsonNode datos = service.seccion("diagnoses");
        return datos == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(datos);
    }
}

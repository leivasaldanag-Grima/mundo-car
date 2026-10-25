package com.mundocar.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mundocar.model.EstadoSistema;
import com.mundocar.repository.EstadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EstadoService {
    private final EstadoRepository repository;
    private final ObjectMapper mapper;
    public EstadoService(EstadoRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public JsonNode leer() {
        return repository.findById(1L).map(item -> {
            try { return mapper.readTree(item.getContenido()); }
            catch (JsonProcessingException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Estado JSON inválido", e);
            }
        }).orElse(null);
    }

    @Transactional(readOnly = true)
    public JsonNode seccion(String nombre) {
        JsonNode estado = leer();
        return estado == null ? null : estado.path(nombre);
    }

    @Transactional
    public synchronized void guardar(JsonNode estado) {
        if (estado == null || !estado.isObject()
                || !estado.path("users").isArray()
                || !estado.path("orders").isArray()
                || !estado.path("vehicles").isArray()
                || !estado.path("parts").isArray()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El estado debe incluir usuarios, órdenes, vehículos y repuestos");
        }
        try {
            String json = mapper.writeValueAsString(estado);
            if (json.length() > 2_000_000) {
                throw new ResponseStatusException(HttpStatus.PAYLOAD_TOO_LARGE, "Estado demasiado grande");
            }
            EstadoSistema entity = repository.findById(1L).orElseGet(() -> new EstadoSistema(1L, json));
            entity.setContenido(json);
            repository.save(entity);
        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "JSON no válido", e);
        }
    }
}

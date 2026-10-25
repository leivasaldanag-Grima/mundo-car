package com.mundocar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/** Guarda el conjunto de formularios de la demostración en un único documento JSON. */
@Entity
@Table(name = "estado_sistema")
public class EstadoSistema {
    @Id
    private Long id;

    @Lob
    @Column(nullable = false)
    private String contenido;

    protected EstadoSistema() { }

    public EstadoSistema(Long id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public Long getId() { return id; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
}

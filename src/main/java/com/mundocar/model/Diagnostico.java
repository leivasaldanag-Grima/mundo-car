package com.mundocar.model;

/** DTO de referencia para futuras operaciones específicas del módulo Diagnostico. */
public record Diagnostico(String orden, String fallas, String codigoDtc, String observaciones, String recomendaciones) { }

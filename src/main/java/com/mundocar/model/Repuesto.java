package com.mundocar.model;

/** DTO de referencia para futuras operaciones específicas del módulo Repuesto. */
public record Repuesto(String codigo, String descripcion, int stock, java.math.BigDecimal precio) { }

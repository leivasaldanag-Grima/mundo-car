package com.mundocar.model;

/** DTO de referencia para futuras operaciones específicas del módulo Presupuesto. */
public record Presupuesto(String orden, java.math.BigDecimal total, String decision, String observaciones) { }

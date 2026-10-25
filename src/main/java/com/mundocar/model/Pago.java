package com.mundocar.model;

/** DTO de referencia para futuras operaciones específicas del módulo Pago. */
public record Pago(String orden, String medio, java.math.BigDecimal monto, boolean registrado) { }

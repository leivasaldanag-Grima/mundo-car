package com.mundocar.model;

/** DTO de referencia para futuras operaciones específicas del módulo Vehiculo. */
public record Vehiculo(String placa, long clienteId, String marca, String modelo, int anio) { }

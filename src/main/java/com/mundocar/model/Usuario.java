package com.mundocar.model;

/** DTO de referencia para futuras operaciones específicas del módulo Usuario. */
public record Usuario(long id, String nombre, String correo, String rol, boolean activo) { }

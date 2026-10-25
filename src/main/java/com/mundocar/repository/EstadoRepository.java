package com.mundocar.repository;

import com.mundocar.model.EstadoSistema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoSistema, Long> { }

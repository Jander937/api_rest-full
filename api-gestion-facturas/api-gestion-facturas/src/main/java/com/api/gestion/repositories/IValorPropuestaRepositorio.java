package com.api.gestion.repositories;

import com.api.gestion.entities.ValorPropuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IValorPropuestaRepositorio extends JpaRepository <ValorPropuestaEntity, Integer> {
}

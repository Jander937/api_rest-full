package com.api.gestion.repositories;

import com.api.gestion.entities.TipoProponenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoProponenteRepositorio extends JpaRepository <TipoProponenteEntity, Integer> {
}

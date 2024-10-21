package com.api.gestion.repositories;

import com.api.gestion.entities.RepresentanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRepresentanteRepositorio extends JpaRepository <RepresentanteEntity, Integer> {
}

package com.api.gestion.repositories;

import com.api.gestion.entities.ProponenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProponenteRepositorio extends JpaRepository<ProponenteEntity, Integer> {
}

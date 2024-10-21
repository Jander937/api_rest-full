package com.api.gestion.repositories;

import com.api.gestion.entities.PropuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPropuestaRepositorio extends JpaRepository <PropuestaEntity, Integer> {
}

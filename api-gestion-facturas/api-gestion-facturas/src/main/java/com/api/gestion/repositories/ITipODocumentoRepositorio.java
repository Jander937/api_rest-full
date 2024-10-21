package com.api.gestion.repositories;

import com.api.gestion.entities.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipODocumentoRepositorio extends JpaRepository<TipoDocumentoEntity, Integer> {
}

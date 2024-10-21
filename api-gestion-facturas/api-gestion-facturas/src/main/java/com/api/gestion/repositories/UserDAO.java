package com.api.gestion.repositories;

import com.api.gestion.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,Integer> {
    UserEntity findByEmail(@Param(("email")) String email);
}

package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    UserEntity findByIdUser(Long idUser);
    Boolean existsByUsername(String username);
}

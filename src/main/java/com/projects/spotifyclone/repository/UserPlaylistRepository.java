package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.UserPlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPlaylistRepository extends JpaRepository<UserPlaylistEntity, Integer> {
    Optional<UserPlaylistEntity> findByNamePlaylist(String namePlaylist);
    Boolean existsByNamePlaylist(String namePlaylist);
}

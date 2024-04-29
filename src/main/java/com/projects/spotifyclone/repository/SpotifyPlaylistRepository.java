package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.SpotifyPlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SpotifyPlaylistRepository extends JpaRepository<SpotifyPlaylistEntity, Integer> {
    Optional<SpotifyPlaylistEntity> findByNamePlaylist(String namePlaylist);
    Boolean existsByNamePlaylist(String namePlaylist);
}

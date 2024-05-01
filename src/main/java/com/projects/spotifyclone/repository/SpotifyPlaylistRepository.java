package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.SpotifyPlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpotifyPlaylistRepository extends JpaRepository<SpotifyPlaylistEntity, Integer> {
    Optional<SpotifyPlaylistEntity> findByNamePlaylist(String namePlaylist);
    List<SpotifyPlaylistEntity> findDistinctByCategoriesNameCategory(String nameCategory);
    List<SpotifyPlaylistEntity> findDistinctByUsersUsername(String username);
    Boolean existsByNamePlaylist(String namePlaylist);
    Boolean deleteDistinctByUsersUsernameAndNamePlaylist(String username,String namePlaylist);
}

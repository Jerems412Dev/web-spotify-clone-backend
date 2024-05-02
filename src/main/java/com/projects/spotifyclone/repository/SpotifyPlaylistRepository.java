package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.SpotifyPlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotifyPlaylistRepository extends JpaRepository<SpotifyPlaylistEntity, Integer> {
    SpotifyPlaylistEntity findByNamePlaylist(String namePlaylist);
    SpotifyPlaylistEntity findByIdSpotifyPlaylist(long idPlaylist);
    List<SpotifyPlaylistEntity> findDistinctByCategoriesNameCategory(String nameCategory);
    List<SpotifyPlaylistEntity> findDistinctByUsersUsername(String username);
    Boolean existsByNamePlaylist(String namePlaylist);
    Boolean deleteDistinctByUsersUsernameAndNamePlaylist(String username,String namePlaylist);
    List<SpotifyPlaylistEntity> findDistinctByNamePlaylistContaining(String search);
}

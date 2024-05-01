package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.UserEntity;
import com.projects.spotifyclone.entity.UserPlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPlaylistRepository extends JpaRepository<UserPlaylistEntity, Integer> {
    Optional<UserPlaylistEntity> findByNamePlaylist(String namePlaylist);
    List<UserPlaylistEntity> findDistinctByUser_Username(String username);
    Boolean deleteDistinctByTracksTitleTrackAndIdUserPlaylist(String titleTrack, Long id);
    Boolean existsByNamePlaylist(String namePlaylist);
}

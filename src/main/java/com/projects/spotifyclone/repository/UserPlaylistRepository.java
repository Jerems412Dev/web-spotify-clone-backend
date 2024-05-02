package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.UserPlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPlaylistRepository extends JpaRepository<UserPlaylistEntity, Integer> {
    UserPlaylistEntity findByNamePlaylist(String namePlaylist);
    UserPlaylistEntity findByIdUserPlaylist(long idUserPlaylist);
    List<UserPlaylistEntity> findDistinctByUser_Username(String username);
    Boolean deleteDistinctByTracksTitleTrackAndIdUserPlaylist(String titleTrack, Long id);
    Boolean existsByNamePlaylist(String namePlaylist);
}

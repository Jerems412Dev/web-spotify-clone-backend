package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<TrackEntity, Integer> {
    TrackEntity findByTitleTrack(String titleTrack);
    TrackEntity findByIdTrack(long idTrack);
    List<TrackEntity> findDistinctByArtistsNameArtist(String nameArtist);
    List<TrackEntity> findDistinctByAlbum_TitleAlbum(String titleAlbum);
    List<TrackEntity> findDistinctByUsersUsername(String username);
    List<TrackEntity> findDistinctByCategoriesNameCategory(String nameCategory);
    List<TrackEntity> findDistinctByUserplaylistsIdUserPlaylist(Long id);
    List<TrackEntity> findDistinctByUserplaylistsIdUserPlaylistNot(Long id);
    List<TrackEntity> findDistinctBySpotifyplaylistsIdSpotifyPlaylist(Long id);
    List<TrackEntity> findDistinctBySpotifyplaylistsIdSpotifyPlaylistNot(Long id);
    List<TrackEntity> findDistinctByTitleTrackContaining(String search);
    Boolean existsByTitleTrack(String titleTrack);
    Boolean existsByTitleTrackAndUsersUsername(String titleTrack, String username);
    Boolean deleteDistinctByUsersUsernameAndTitleTrack(String username,String titleTrack);
}

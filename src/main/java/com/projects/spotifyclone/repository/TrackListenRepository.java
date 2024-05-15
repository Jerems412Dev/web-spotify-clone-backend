package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.TrackListenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackListenRepository extends JpaRepository<TrackListenEntity, Integer> {
    TrackListenEntity findTopByUser_UsernameOrderByIdDesc(String user);
    List<TrackListenEntity> findDistinctByUser_UsernameAndTrack_TitleTrack(String username, String titleTrack);
    List<TrackListenEntity> findDistinctByUser_UsernameAndTrack_TitleTrackNot(String username, String titleTrack);
    Boolean existsDistinctByUser_UsernameAndTrack_TitleTrack(String username, String titleTrack);
}

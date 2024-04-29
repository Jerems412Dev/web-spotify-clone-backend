package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackRepository extends JpaRepository<TrackEntity, Integer> {
    Optional<TrackEntity> findByTitleTrack(String titleTrack);
    Boolean existsByTitleTrack(String titleTrack);
}

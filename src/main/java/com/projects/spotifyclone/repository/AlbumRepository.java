package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {
    Optional<AlbumEntity> findByTitleAlbum(String albumName);
    Boolean existsByTitleAlbum(String albumName);
}

package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
    Optional<ArtistEntity> findByNameArtist(String artistName);
    Boolean existsByNameArtist(String artistName);
}

package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
    Optional<ArtistEntity> findByNameArtist(String artistName);
    List<ArtistEntity> findDistinctByUsersUsername(String username);
    List<ArtistEntity> findDistinctByCategoriesNameCategory(String nameCategory);
    List<ArtistEntity> findDistinctByNameArtistContaining(String search);
    Boolean existsByNameArtist(String artistName);
    Boolean existsByNameArtistAndCategoriesNameCategory(String nameArtist, String nameCategory);
    Boolean deleteDistinctByUsersUsernameAndNameArtist(String username,String nameArtist);
}

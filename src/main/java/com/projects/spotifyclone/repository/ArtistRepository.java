package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
    ArtistEntity findByNameArtist(String artistName);
    ArtistEntity findByIdArtist(long idArtist);
    List<ArtistEntity> findDistinctByUsersUsername(String username);
    List<ArtistEntity> findDistinctByCategoriesNameCategory(String nameCategory);
    List<ArtistEntity> findDistinctByNameArtistContaining(String search);
    Boolean existsByNameArtist(String artistName);
    Boolean existsByNameArtistAndCategoriesNameCategory(String nameArtist, String nameCategory);
    Boolean existsByIdArtistAndUsersUsername(long idArtist, String username);
    Boolean deleteDistinctByUsersUsernameAndNameArtist(String username,String nameArtist);
}

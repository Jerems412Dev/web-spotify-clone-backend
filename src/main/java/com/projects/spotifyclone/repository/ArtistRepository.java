package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
    ArtistEntity findByNameArtist(String artistName);
    ArtistEntity findByIdArtist(long idArtist);
    List<ArtistEntity> findDistinctByUsersUsername(String username);
    List<ArtistEntity> findDistinctByCategoriesNameCategory(String nameCategory);
    List<ArtistEntity> findDistinctByNameArtistContaining(String search);
    Boolean existsByNameArtist(String artistName);
    Boolean existsByNameArtistAndCategoriesNameCategory(String nameArtist, String nameCategory);
    Boolean existsByNameArtistAndUsersUsername(String nameArtist, String username);
    Boolean deleteDistinctByUsersUsernameAndNameArtist(String username,String nameArtist);
}

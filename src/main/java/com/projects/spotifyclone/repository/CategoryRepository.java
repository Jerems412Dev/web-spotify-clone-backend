package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findByNameCategory(String categoryName);
    List<CategoryEntity> findDistinctByAlbumsTitleAlbum(String titleAlbum);
    List<CategoryEntity> findDistinctByArtistsNameArtist(String nameArtist);
    List<CategoryEntity> findDistinctBySpotifyplaylistsNamePlaylist(String namePlaylist);
    Boolean existsByNameCategory(String categoryName);
}

package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {
    Optional<AlbumEntity> findByTitleAlbum(String titleAlbum);
    List<AlbumEntity> findDistinctByUsersUsername(String username);
    List<AlbumEntity> findDistinctByCategoriesNameCategory(String nameCategory);
    List<AlbumEntity> findDistinctByTitleAlbumContaining(String search);
    Boolean existsByTitleAlbum(String albumName);
    Boolean existsByTitleAlbumAndCategoriesNameCategory(String titleAlbum, String nameCategory);
    Boolean deleteDistinctByUsersUsernameAndTitleAlbum(String username,String titleAlbum);
}

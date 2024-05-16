package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {
    AlbumEntity findByTitleAlbum(String titleAlbum);
    AlbumEntity findByIdAlbum(long idAlbum);
    List<AlbumEntity> findDistinctByUsersUsername(String username);
    List<AlbumEntity> findDistinctByCategoriesNameCategory(String nameCategory);
    List<AlbumEntity> findDistinctByTitleAlbumContaining(String search);
    Boolean existsByTitleAlbum(String albumName);
    Boolean existsByTitleAlbumAndCategoriesNameCategory(String titleAlbum, String nameCategory);
    Boolean deleteDistinctByUsersUsernameAndTitleAlbum(String username,String titleAlbum);
    Boolean existsByTitleAlbumAndUsersUsername(String titleAlbum, String username);
}

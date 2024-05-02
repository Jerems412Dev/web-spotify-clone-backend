package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.AlbumDTO;
import com.projects.spotifyclone.dto.ArtistDTO;
import com.projects.spotifyclone.entity.UserEntity;
import com.projects.spotifyclone.mapper.AlbumMapper;
import com.projects.spotifyclone.repository.AlbumRepository;
import com.projects.spotifyclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private UserRepository userRepository;

    // add an album
    @Transactional
    public String createAlbum(AlbumDTO album, ArtistDTO artist) {
        album.setArtist(artist);
        albumMapper.toAlbumDTO(albumRepository.save(albumMapper.fromAlbumDTO(album)));
        return "album added successfully";
    }

    // retrieve a user's list of favorite albums
    @Transactional(readOnly = true)
    public List<AlbumDTO> findAlbumByUsername(String username) {
        return albumMapper.albumEntityListToAlbumDTOList(albumRepository.findDistinctByUsersUsername(username));
    }

    // retrieve the list of albums in a category.
    @Transactional(readOnly = true)
    public List<AlbumDTO> findByCategoryName(String categoryName) {
        return albumMapper.albumEntityListToAlbumDTOList(albumRepository.findDistinctByCategoriesNameCategory(categoryName));
    }

    // search for an album by title.
    @Transactional(readOnly = true)
    public List<AlbumDTO> searchAlbum(String containing) {
        return albumMapper.albumEntityListToAlbumDTOList(albumRepository.findDistinctByTitleAlbumContaining(containing));
    }

    // check if an album exists.
    @Transactional(readOnly = true)
    public Boolean albumExist(String titleAlbum) {
        return albumRepository.existsByTitleAlbum(titleAlbum);
    }

    // check if an album belongs to a category.
    @Transactional(readOnly = true)
    public Boolean albumExistInCategory(String titleAlbum, String nameCategory) {
        return albumRepository.existsByTitleAlbumAndCategoriesNameCategory(titleAlbum,nameCategory);
    }

    // Deletes a user's “like” of an album
    @Transactional(readOnly = true)
    public Boolean deleteAlbumUser(String username, String titleAlbum) {
        return albumRepository.deleteDistinctByUsersUsernameAndTitleAlbum(username,titleAlbum);
    }

    // Adds an object to the user_album pivot table (the action of liking an album).
    @Transactional()
    public String favAlbumByUser(long idUser, long idAlbum) {
        AlbumDTO album = albumMapper.toAlbumDTO(albumRepository.findByIdAlbum(idAlbum));
        List<UserEntity> userList = new ArrayList<>();
        userList.add(userRepository.findByIdUser(idUser));
        albumRepository.save(albumMapper.fromAlbumDTO(album));
        return "fav added successfully";
    }

    // find an artist by name
    @Transactional(readOnly = true)
    public AlbumDTO findByTitleAlbum(String titleAlbum) {
        return albumMapper.toAlbumDTO(albumRepository.findByTitleAlbum(titleAlbum));
    }

}

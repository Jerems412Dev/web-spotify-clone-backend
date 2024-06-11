package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.AlbumDTO;
import com.projects.spotifyclone.entity.AlbumEntity;
import com.projects.spotifyclone.entity.UserEntity;
import com.projects.spotifyclone.mapper.AlbumMapper;
import com.projects.spotifyclone.repository.AlbumRepository;
import com.projects.spotifyclone.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    private final AlbumMapper albumMapper;
    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;

    public AlbumService(AlbumMapper albumMapper, AlbumRepository albumRepository, UserRepository userRepository) {
        this.albumMapper = albumMapper;
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    // add an album
    @Transactional
    public String createAlbum(AlbumDTO album) {
        albumRepository.save(albumMapper.fromAlbumDTO(album));
        return "album added successfully";
    }

    // add albums
    @Transactional
    public String createAlbums(List<AlbumDTO> albums) {
        albumRepository.saveAll(albumMapper.albumDTOListToAlbumEntityList(albums));
        return "albums added successfully";
    }

    // retrieve 10 random albums
    @Transactional(readOnly = true)
    public List<AlbumDTO> findRandom10() {
        return albumMapper.albumEntityListToAlbumDTOList(albumRepository.findAll());
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

    // find an artist by name
    @Transactional(readOnly = true)
    public AlbumDTO findByTitleAlbum(String titleAlbum) {
        return albumMapper.toAlbumDTO(albumRepository.findByTitleAlbum(titleAlbum));
    }

    @Transactional(readOnly = true)
    public Boolean existsByIdAlbumAndUsername(long idAlbum, String username) {
        return albumRepository.existsByIdAlbumAndUsersUsername(idAlbum,username);
    }

    // Adds an object to the user_album pivot table (the action of liking an album).
    @Transactional()
    public String favAlbumByUser(int idUser, int idAlbum) {
        Optional<AlbumEntity> album = albumRepository.findById(idAlbum);
        Optional<UserEntity> user = userRepository.findById(idUser);
        album.get().getUsers().add(user.get());
        user.get().getAlbums().add(album.get());
        albumRepository.save(album.get());
        return "fav added successfully";
    }

}

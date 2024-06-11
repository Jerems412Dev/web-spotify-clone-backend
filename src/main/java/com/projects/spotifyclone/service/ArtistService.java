package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.ArtistDTO;
import com.projects.spotifyclone.entity.ArtistEntity;
import com.projects.spotifyclone.entity.UserEntity;
import com.projects.spotifyclone.mapper.ArtistMapper;
import com.projects.spotifyclone.repository.ArtistRepository;
import com.projects.spotifyclone.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistMapper artistMapper;
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;

    public ArtistService(ArtistMapper artistMapper, ArtistRepository artistRepository, UserRepository userRepository) {
        this.artistMapper = artistMapper;
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
    }

    // add an artist
    @Transactional
    public String createArtist(ArtistDTO artist) {
        artistMapper.toArtistDTO(artistRepository.save(artistMapper.fromArtistDTO(artist)));
        return "artist added successfully";
    }

    // add artists
    @Transactional
    public String createArtists(List<ArtistDTO> artists) {
        artistRepository.saveAll(artistMapper.artistDTOListToArtistEntityList(artists));
        return "artists added successfully";
    }

    // retrieve 10 random artists
    @Transactional(readOnly = true)
    public List<ArtistDTO> findRandom10() {
        return artistMapper.artistEntityListToArtistDTOList(artistRepository.findAll());
    }

    // retrieve a user's list of favorite artists
    @Transactional(readOnly = true)
    public List<ArtistDTO> findArtistByUsername(String username) {
        return artistMapper.artistEntityListToArtistDTOList(artistRepository.findDistinctByUsersUsername(username));
    }

    // retrieve the list of artists in a category.
    @Transactional(readOnly = true)
    public List<ArtistDTO> findByCategoryName(String categoryName) {
        return artistMapper.artistEntityListToArtistDTOList(artistRepository.findDistinctByCategoriesNameCategory(categoryName));
    }

    // search for an artist by title.
    @Transactional(readOnly = true)
    public List<ArtistDTO> searchArtist(String containing) {
        return artistMapper.artistEntityListToArtistDTOList(artistRepository.findDistinctByNameArtistContaining(containing));
    }

    // check if an artist exists.
    @Transactional(readOnly = true)
    public Boolean artistExist(String nameArtist) {
        return artistRepository.existsByNameArtist(nameArtist);
    }

    // check if an artist belongs to a category.
    @Transactional(readOnly = true)
    public Boolean artistExistInCategory(String nameArtist, String nameCategory) {
        return artistRepository.existsByNameArtistAndCategoriesNameCategory(nameArtist,nameCategory);
    }

    // Deletes a user's “like” of an artist
    @Transactional(readOnly = true)
    public Boolean deleteArtistUser(int idUser, int idArtist) {
        Optional<ArtistEntity> artist = artistRepository.findById(idArtist);
        Optional<UserEntity> user = userRepository.findById(idUser);
        user.get().getArtists().remove(artist.get());
        artist.get().getUsers().remove(user.get());
        artistRepository.save(artist.get());
        return true;
    }

    @Transactional(readOnly = true)
    public Boolean existsByIdArtistAndUsersUsername(long idArtist, String username) {
        return artistRepository.existsByIdArtistAndUsersUsername(idArtist,username);
    }

    // find an artist by name
    @Transactional(readOnly = true)
    public ArtistDTO findByNameArtist(String nameArtist) {
        return artistMapper.toArtistDTO(artistRepository.findByNameArtist(nameArtist));
    }

    // Adds an object to the user_artist pivot table (the action of liking an artist).
    @Transactional()
    public String favArtistByUser(int idUser, int idArtist) {
        Optional<ArtistEntity> artist = artistRepository.findById(idArtist);
        Optional<UserEntity> user = userRepository.findById(idUser);
        artist.get().getUsers().add(user.get());
        user.get().getArtists().add(artist.get());
        artistRepository.save(artist.get());
        return "fav added successfully";
    }

}

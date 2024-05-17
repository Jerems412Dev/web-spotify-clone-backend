package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.SpotifyPlaylistDTO;
import com.projects.spotifyclone.entity.UserEntity;
import com.projects.spotifyclone.mapper.SpotifyPlaylistMapper;
import com.projects.spotifyclone.repository.SpotifyPlaylistRepository;
import com.projects.spotifyclone.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpotifyPlaylistService {
    private final SpotifyPlaylistMapper spotifyPlaylistMapper;
    private final SpotifyPlaylistRepository spotifyPlaylistRepository;
    private final UserRepository userRepository;

    public SpotifyPlaylistService(SpotifyPlaylistMapper spotifyPlaylistMapper, SpotifyPlaylistRepository spotifyPlaylistRepository, UserRepository userRepository) {
        this.spotifyPlaylistMapper = spotifyPlaylistMapper;
        this.spotifyPlaylistRepository = spotifyPlaylistRepository;
        this.userRepository = userRepository;
    }

    // add an spotifyPlaylist
    @Transactional
    public String createSpotifyPlaylist(SpotifyPlaylistDTO spotifyPlaylist) {
        spotifyPlaylistRepository.save(spotifyPlaylistMapper.fromSpotifyPlaylistDTO(spotifyPlaylist));
        return "spotifyPlaylist added successfully";
    }

    // add spotifyPlaylists
    @Transactional
    public String createSpotifyPlaylists(List<SpotifyPlaylistDTO> spotifyPlaylists) {
        spotifyPlaylistRepository.saveAll(spotifyPlaylistMapper.spotifyPlaylistDTOListToSpotifyPlaylistEntityList(spotifyPlaylists));
        return "spotifyPlaylists added successfully";
    }

    // find playlist by name
    @Transactional(readOnly = true)
    public SpotifyPlaylistDTO findByNamePlaylist(String namePlaylist) {
        return spotifyPlaylistMapper.toSpotifyPlaylistDTO(spotifyPlaylistRepository.findByNamePlaylist(namePlaylist));
    }

    // find playlist by id
    @Transactional(readOnly = true)
    public SpotifyPlaylistDTO findByIdPlaylist(long idPlaylist) {
        return spotifyPlaylistMapper.toSpotifyPlaylistDTO(spotifyPlaylistRepository.findByIdSpotifyPlaylist(idPlaylist));
    }

    // find playlist by categoryName
    @Transactional(readOnly = true)
    public List<SpotifyPlaylistDTO> findByNameCategory(String nameCategory) {
        return spotifyPlaylistMapper.spotifyPlaylistEntityListToSpotifyPlaylistDTOList(spotifyPlaylistRepository.findDistinctByCategoriesNameCategory(nameCategory));
    }

    // find playlist
    @Transactional(readOnly = true)
    public List<SpotifyPlaylistDTO> findRandom10Playlist() {
        return spotifyPlaylistMapper.spotifyPlaylistEntityListToSpotifyPlaylistDTOList(spotifyPlaylistRepository.findAll());
    }

    // find playlist by username
    @Transactional(readOnly = true)
    public List<SpotifyPlaylistDTO> findByUsername(String username) {
        return spotifyPlaylistMapper.spotifyPlaylistEntityListToSpotifyPlaylistDTOList(spotifyPlaylistRepository.findDistinctByUsersUsername(username));
    }

    // check if playlist exists.
    @Transactional(readOnly = true)
    public Boolean playlistExist(String namePlaylist) {
        return spotifyPlaylistRepository.existsByNamePlaylist(namePlaylist);
    }

    // delete a user's playlist like
    @Transactional
    public Boolean deleteByUsernameAndNamePlaylist(String username,String namePlaylist) {
        return spotifyPlaylistRepository.deleteDistinctByUsersUsernameAndNamePlaylist(username,namePlaylist);
    }

    // search for spotifyPlaylist by namePlaylist.
    @Transactional(readOnly = true)
    public List<SpotifyPlaylistDTO> searchSpotifyPlaylist(String containing) {
        return spotifyPlaylistMapper.spotifyPlaylistEntityListToSpotifyPlaylistDTOList(spotifyPlaylistRepository.findDistinctByNamePlaylistContaining(containing));
    }

    @Transactional()
    public String favSpotifyPlaylistByUser(long idUser, long idPlaylist) {
        SpotifyPlaylistDTO playlist = spotifyPlaylistMapper.toSpotifyPlaylistDTO(spotifyPlaylistRepository.findByIdSpotifyPlaylist(idPlaylist));
        List<UserEntity> userList = new ArrayList<>();
        userList.add(userRepository.findByIdUser(idUser));
        spotifyPlaylistRepository.save(spotifyPlaylistMapper.fromSpotifyPlaylistDTO(playlist));
        return "fav added successfully";
    }

}

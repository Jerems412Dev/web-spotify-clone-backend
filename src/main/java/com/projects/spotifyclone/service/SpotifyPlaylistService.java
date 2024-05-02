package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.SpotifyPlaylistDTO;
import com.projects.spotifyclone.mapper.SpotifyPlaylistMapper;
import com.projects.spotifyclone.repository.SpotifyPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpotifyPlaylistService {
    @Autowired
    private SpotifyPlaylistMapper spotifyPlaylistMapper;

    @Autowired
    private SpotifyPlaylistRepository spotifyPlaylistRepository;

    // add an spotifyPlaylist
    @Transactional
    public String createSpotifyPlaylist(SpotifyPlaylistDTO spotifyPlaylist) {
        spotifyPlaylistMapper.toSpotifyPlaylistDTO(spotifyPlaylistRepository.save(spotifyPlaylistMapper.fromSpotifyPlaylistDTO(spotifyPlaylist)));
        return "spotifyPlaylist added successfully";
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

}

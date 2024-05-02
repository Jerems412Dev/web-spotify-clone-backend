package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.UserPlaylistDTO;
import com.projects.spotifyclone.mapper.UserPlaylistMapper;
import com.projects.spotifyclone.repository.UserPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserPlaylistService {
    @Autowired
    private UserPlaylistMapper userPlaylistMapper;

    @Autowired
    private UserPlaylistRepository userPlaylistRepository;

    // add an userPlaylist
    @Transactional
    public String createUserPlaylist(UserPlaylistDTO userPlaylist) {
        userPlaylistMapper.toUserPlaylistDTO(userPlaylistRepository.save(userPlaylistMapper.fromUserPlaylistDTO(userPlaylist)));
        return "userPlaylist added successfully";
    }

    // find playlist by name
    @Transactional(readOnly = true)
    public UserPlaylistDTO findByNamePlaylist(String namePlaylist) {
        return userPlaylistMapper.toUserPlaylistDTO(userPlaylistRepository.findByNamePlaylist(namePlaylist));
    }

    // find playlist by id
    @Transactional(readOnly = true)
    public UserPlaylistDTO findByIdPlaylist(long idPlaylist) {
        return userPlaylistMapper.toUserPlaylistDTO(userPlaylistRepository.findByIdUserPlaylist(idPlaylist));
    }

    // find playlist by categoryName
    @Transactional(readOnly = true)
    public List<UserPlaylistDTO> findByUsername(String username) {
        return userPlaylistMapper.userPlaylistEntityListToUserPlaylistDTOList(userPlaylistRepository.findDistinctByUser_Username(username));
    }

    // check if a playlist exists .
    @Transactional(readOnly = true)
    public Boolean existsByNamePlaylist(String namePlaylist) {
        return userPlaylistRepository.existsByNamePlaylist(namePlaylist);
    }

    // delete a user's playlist like
    @Transactional
    public Boolean deleteByTracksAndUserPlaylist(String titleTrack, Long id) {
        return userPlaylistRepository.deleteDistinctByTracksTitleTrackAndIdUserPlaylist(titleTrack,id);
    }

}

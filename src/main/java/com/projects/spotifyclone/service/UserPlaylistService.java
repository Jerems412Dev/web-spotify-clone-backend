package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.UserPlaylistDTO;
import com.projects.spotifyclone.entity.TrackEntity;
import com.projects.spotifyclone.entity.UserPlaylistEntity;
import com.projects.spotifyclone.mapper.UserPlaylistMapper;
import com.projects.spotifyclone.repository.TrackRepository;
import com.projects.spotifyclone.repository.UserPlaylistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserPlaylistService {
    private final UserPlaylistMapper userPlaylistMapper;
    private final UserPlaylistRepository userPlaylistRepository;
    private final TrackRepository trackRepository;

    public UserPlaylistService(UserPlaylistMapper userPlaylistMapper, UserPlaylistRepository userPlaylistRepository, TrackRepository trackRepository) {
        this.userPlaylistMapper = userPlaylistMapper;
        this.userPlaylistRepository = userPlaylistRepository;
        this.trackRepository = trackRepository;
    }

    // add an userPlaylist
    @Transactional
    public String createUserPlaylist(UserPlaylistDTO userPlaylist) {
        userPlaylistMapper.toUserPlaylistDTO(userPlaylistRepository.save(userPlaylistMapper.fromUserPlaylistDTO(userPlaylist)));
        return "userPlaylist added successfully";
    }

    // update an userPlaylist
    @Transactional
    public String updateUserPlaylist(int id, UserPlaylistDTO userPlaylistDTO) {
        Optional<UserPlaylistEntity> existingUserPlaylistO = userPlaylistRepository.findById(id);
        if(existingUserPlaylistO.isPresent()) {
            UserPlaylistEntity existingUserPlaylist = existingUserPlaylistO.get();
            existingUserPlaylist.setNamePlaylist(userPlaylistDTO.getNamePlaylist());
            existingUserPlaylist.setDescription(userPlaylistDTO.getDescription());
            existingUserPlaylist.setProfilePicture(userPlaylistDTO.getProfilePicture());
            userPlaylistRepository.save(existingUserPlaylist);
        }
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

    // find playlist by userName
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

    // Add an object to the user_userPlaylist pivot table (the action of liking a track).
    @Transactional()
    public String addTrackInPlaylist(int idUserPlaylist, int idTrack) {
        Optional<TrackEntity> track = trackRepository.findById(idTrack);
        Optional<UserPlaylistEntity> user = userPlaylistRepository.findById(idUserPlaylist);
        if(track.isPresent() && user.isPresent()) {
            track.get().getUserplaylists().add(user.get());
            user.get().getTracks().add(track.get());
            trackRepository.save(track.get());
        }
        return "fav added successfully";
    }

}

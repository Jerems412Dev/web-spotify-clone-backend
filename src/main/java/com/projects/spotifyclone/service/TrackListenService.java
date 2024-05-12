package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.TrackListenDTO;
import com.projects.spotifyclone.mapper.TrackListenMapper;
import com.projects.spotifyclone.repository.TrackListenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrackListenService {
    private final TrackListenMapper tracklistenMapper;
    private final TrackListenRepository tracklistenRepository;

    public TrackListenService(TrackListenMapper tracklistenMapper, TrackListenRepository tracklistenRepository) {
        this.tracklistenMapper = tracklistenMapper;
        this.tracklistenRepository = tracklistenRepository;
    }

    // find last track listen by user
    @Transactional(readOnly = true)
    public TrackListenDTO findLastTrackListen(String username) {
        return tracklistenMapper.toTrackListenDTO(tracklistenRepository.findTopByUser_UsernameOrderByListenedAtDesc(username));
    }

    // find trackListen by username and titleTrack
    @Transactional(readOnly = true)
    public List<TrackListenDTO> findByUserAndTrack(String username, String titleTrack) {
        return tracklistenMapper.tracklistenEntityListToTrackListenDTOList(tracklistenRepository.findDistinctByUser_UsernameAndTrack_TitleTrack(username,titleTrack));
    }

    // search for tracks not listened to by a user
    @Transactional(readOnly = true)
    public List<TrackListenDTO> findByUserAndTrackNot(String username, String titleTrack) {
        return tracklistenMapper.tracklistenEntityListToTrackListenDTOList(tracklistenRepository.findDistinctByUser_UsernameAndTrack_TitleTrackNot(username,titleTrack));
    }

    // check if a track has been listened to by a user
    @Transactional(readOnly = true)
    public Boolean existsByUserAndTrack(String username, String titleTrack) {
        return tracklistenRepository.existsDistinctByUser_UsernameAndTrack_TitleTrack(username,titleTrack);
    }

}

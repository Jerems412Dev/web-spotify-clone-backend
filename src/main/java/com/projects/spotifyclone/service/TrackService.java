package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.TrackDTO;
import com.projects.spotifyclone.mapper.TrackMapper;
import com.projects.spotifyclone.repository.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrackService {
    private final TrackMapper trackMapper;
    private final TrackRepository trackRepository;

    public TrackService(TrackMapper trackMapper, TrackRepository trackRepository) {
        this.trackMapper = trackMapper;
        this.trackRepository = trackRepository;
    }

    // create track
    @Transactional
    public String createTrack(TrackDTO track) {
        trackMapper.toTrackDTO(trackRepository.save(trackMapper.fromTrackDTO(track)));
        return "track added successfully";
    }

    // retrieve a track list by titleTrack
    @Transactional(readOnly = true)
    public TrackDTO findTrackByTitle(String titleTrack) {
        return trackMapper.toTrackDTO(trackRepository.findByTitleTrack(titleTrack));
    }

    // retrieve a track list by idTrack
    @Transactional(readOnly = true)
    public TrackDTO findTrackById(long idTrack) {
        return trackMapper.toTrackDTO(trackRepository.findByIdTrack(idTrack));
    }

    // returns the list of music liked by a user
    @Transactional(readOnly = true)
    public List<TrackDTO> findTrackByUsername(String username) {
        return trackMapper.trackEntityListToTrackDTOList(trackRepository.findDistinctByUsersUsername(username));
    }

    // return an artist's music list
    @Transactional(readOnly = true)
    public List<TrackDTO> findTrackByTitleAlbum(String titleAlbum) {
        return trackMapper.trackEntityListToTrackDTOList(trackRepository.findDistinctByAlbum_TitleAlbum(titleAlbum));
    }

    // return an artist's music list
    @Transactional(readOnly = true)
    public List<TrackDTO> findTrackByNameArtist(String nameArtist) {
        return trackMapper.trackEntityListToTrackDTOList(trackRepository.findDistinctByArtistsNameArtist(nameArtist));
    }

    // retrieve the list of songs in a category
    @Transactional(readOnly = true)
    public List<TrackDTO> findByNameCategory(String nameCategory) {
        return trackMapper.trackEntityListToTrackDTOList(trackRepository.findDistinctByCategoriesNameCategory(nameCategory));
    }

    // retrieve a UserPlaylist's music list
    @Transactional(readOnly = true)
    public List<TrackDTO> findByIdUserPlaylist(long idPlaylist) {
        return trackMapper.trackEntityListToTrackDTOList(trackRepository.findDistinctByUserplaylistsIdUserPlaylist(idPlaylist));
    }

    // recovers the list of songs not in the UserPlaylist
    @Transactional(readOnly = true)
    public List<TrackDTO> findByIdUserPlaylistNot(long idPlaylist) {
        return trackMapper.trackEntityListToTrackDTOList(trackRepository.findDistinctByUserplaylistsIdUserPlaylistNot(idPlaylist));
    }

    // retrieve a SpotifyPlaylist's music list
    @Transactional(readOnly = true)
    public List<TrackDTO> findByIdSpotifyPlaylist(long idPlaylist) {
        return trackMapper.trackEntityListToTrackDTOList(trackRepository.findDistinctBySpotifyplaylistsIdSpotifyPlaylist(idPlaylist));
    }

    // recovers the list of songs not in the SpotifyPlaylist
    @Transactional(readOnly = true)
    public List<TrackDTO> findByIdSpotifyPlaylistNot(long idPlaylist) {
        return trackMapper.trackEntityListToTrackDTOList(trackRepository.findDistinctBySpotifyplaylistsIdSpotifyPlaylistNot(idPlaylist));
    }

    // search for a track
    @Transactional(readOnly = true)
    public List<TrackDTO> findByTitleTrackContaining(String search) {
        return trackMapper.trackEntityListToTrackDTOList(trackRepository.findDistinctByTitleTrackContaining(search));
    }

    // check if a track exists by titleTrack.
    @Transactional(readOnly = true)
    public Boolean existsByTitleTrack(String titleTrack) {
        return trackRepository.existsByTitleTrack(titleTrack);
    }

    // check if a track exists by titleTrack and username.
    @Transactional(readOnly = true)
    public Boolean existsByTitleTrackAndUsername(String titleTrack, String username) {
        return trackRepository.existsByTitleTrackAndUsersUsername(titleTrack,username);
    }

    // Deletes a user's “like” of a track
    @Transactional(readOnly = true)
    public Boolean deleteByUsernameAndTitleTrack(String username, String titleTrack) {
        return trackRepository.deleteDistinctByUsersUsernameAndTitleTrack(username,titleTrack);
    }

}

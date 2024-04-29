package com.projects.spotifyclone.service;

import com.projects.spotifyclone.mapper.SpotifyPlaylistMapper;
import com.projects.spotifyclone.repository.SpotifyPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpotifyPlaylistService {
    @Autowired
    private SpotifyPlaylistMapper spotifyPlaylistMapper;

    @Autowired
    private SpotifyPlaylistRepository spotifyPlaylistRepository;

}

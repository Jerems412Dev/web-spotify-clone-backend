package com.projects.spotifyclone.service;

import com.projects.spotifyclone.mapper.TrackListenMapper;
import com.projects.spotifyclone.repository.TrackListenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackListenService {
    @Autowired
    private TrackListenMapper tracklistenMapper;

    @Autowired
    private TrackListenRepository tracklistenRepository;

}

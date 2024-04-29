package com.projects.spotifyclone.service;

import com.projects.spotifyclone.mapper.TrackMapper;
import com.projects.spotifyclone.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {
    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackRepository trackRepository;

}

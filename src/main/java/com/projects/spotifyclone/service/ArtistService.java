package com.projects.spotifyclone.service;

import com.projects.spotifyclone.mapper.ArtistMapper;
import com.projects.spotifyclone.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private ArtistRepository artistRepository;

}

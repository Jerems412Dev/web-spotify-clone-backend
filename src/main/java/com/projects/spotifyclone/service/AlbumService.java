package com.projects.spotifyclone.service;

import com.projects.spotifyclone.mapper.AlbumMapper;
import com.projects.spotifyclone.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumRepository albumRepository;

}

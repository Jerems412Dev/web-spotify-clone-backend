package com.projects.spotifyclone.service;

import com.projects.spotifyclone.mapper.UserPlaylistMapper;
import com.projects.spotifyclone.repository.UserPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPlaylistService {
    @Autowired
    private UserPlaylistMapper userPlaylistMapper;

    @Autowired
    private UserPlaylistRepository userPlaylistRepository;

}

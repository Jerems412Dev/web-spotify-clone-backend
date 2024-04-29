package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.SpotifyPlaylistDTO;
import com.projects.spotifyclone.entity.SpotifyPlaylistEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SpotifyPlaylistMapper {
    SpotifyPlaylistDTO toSpotifyPlaylistDTO(SpotifyPlaylistEntity spotifyPlaylistEntity);
    SpotifyPlaylistEntity fromSpotifyPlaylistDTO(SpotifyPlaylistDTO spotifyPlaylistDTO);
}

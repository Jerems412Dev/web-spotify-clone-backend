package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.SpotifyPlaylistDTO;
import com.projects.spotifyclone.entity.SpotifyPlaylistEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface SpotifyPlaylistMapper {
    SpotifyPlaylistDTO toSpotifyPlaylistDTO(SpotifyPlaylistEntity spotifyPlaylistEntity);
    List<SpotifyPlaylistDTO> spotifyPlaylistEntityListToSpotifyPlaylistDTOList(List<SpotifyPlaylistEntity> list);
    SpotifyPlaylistEntity fromSpotifyPlaylistDTO(SpotifyPlaylistDTO spotifyPlaylistDTO);
}

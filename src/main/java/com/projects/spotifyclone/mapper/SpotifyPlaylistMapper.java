package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.SpotifyPlaylistDTO;
import com.projects.spotifyclone.dto.SpotifyPlaylistWithPivotDTO;
import com.projects.spotifyclone.entity.SpotifyPlaylistEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface SpotifyPlaylistMapper {
    SpotifyPlaylistDTO toSpotifyPlaylistDTO(SpotifyPlaylistEntity spotifyPlaylistEntity);
    List<SpotifyPlaylistDTO> spotifyPlaylistEntityListToSpotifyPlaylistDTOList(List<SpotifyPlaylistEntity> list);
    List<SpotifyPlaylistEntity> spotifyPlaylistDTOListToSpotifyPlaylistEntityList(List<SpotifyPlaylistDTO> list);
    SpotifyPlaylistEntity fromSpotifyPlaylistDTO(SpotifyPlaylistDTO spotifyPlaylistDTO);
    SpotifyPlaylistWithPivotDTO toSpotifyPlaylistWithPivotDTO(SpotifyPlaylistEntity spotifyPlaylistEntity);
    List<SpotifyPlaylistWithPivotDTO> spotifyPlaylistEntityListToSpotifyPlaylistWithPivotDTOList(List<SpotifyPlaylistEntity> list);
    List<SpotifyPlaylistEntity> spotifyPlaylistWithPivotDTOListToSpotifyPlaylistEntityList(List<SpotifyPlaylistWithPivotDTO> list);
    SpotifyPlaylistEntity fromSpotifyPlaylistDTO(SpotifyPlaylistWithPivotDTO spotifyPlaylistDTO);
}

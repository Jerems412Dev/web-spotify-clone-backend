package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.ArtistDTO;
import com.projects.spotifyclone.entity.ArtistEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ArtistMapper {
    ArtistDTO toArtistDTO(ArtistEntity artistEntity);
    ArtistEntity fromArtistDTO(ArtistDTO artistDTO);
}

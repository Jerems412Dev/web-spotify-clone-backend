package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.ArtistDTO;
import com.projects.spotifyclone.dto.ArtistWithPivotDTO;
import com.projects.spotifyclone.entity.ArtistEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface ArtistMapper {
    ArtistDTO toArtistDTO(ArtistEntity artistEntity);
    List<ArtistDTO> artistEntityListToArtistDTOList(List<ArtistEntity> list);
    List<ArtistEntity> artistDTOListToArtistEntityList(List<ArtistDTO> list);
    ArtistEntity fromArtistDTO(ArtistDTO artistDTO);
    ArtistWithPivotDTO toArtistWithPivotDTO(ArtistEntity artistEntity);
    List<ArtistWithPivotDTO> artistEntityListToArtistWithPivotDTOList(List<ArtistEntity> list);
    List<ArtistEntity> artistWithPivotDTOListToArtistEntityList(List<ArtistWithPivotDTO> list);
    ArtistEntity fromArtistWithPivotDTO(ArtistWithPivotDTO artistDTO);
}

package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.TrackDTO;
import com.projects.spotifyclone.entity.TrackEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TrackMapper {
    TrackDTO toTrackDTO(TrackEntity trackEntity);
    TrackEntity fromTrackDTO(TrackDTO trackDTO);
}

package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.TrackDTO;
import com.projects.spotifyclone.entity.TrackEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TrackMapper {
    TrackDTO toTrackDTO(TrackEntity trackEntity);
    List<TrackDTO> trackEntityListToTrackDTOList(List<TrackEntity> list);
    TrackEntity fromTrackDTO(TrackDTO trackDTO);
}

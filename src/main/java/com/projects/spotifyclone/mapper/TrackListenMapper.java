package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.TrackListenDTO;
import com.projects.spotifyclone.entity.TrackListenEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TrackListenMapper {
    TrackListenDTO toTrackListenDTO(TrackListenEntity tracklistenEntity);
    TrackListenEntity fromTrackListenDTO(TrackListenDTO tracklistenDTO);
}

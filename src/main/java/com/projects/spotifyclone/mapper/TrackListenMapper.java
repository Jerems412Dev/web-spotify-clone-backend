package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.TrackListenDTO;
import com.projects.spotifyclone.entity.TrackListenEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface TrackListenMapper {
    TrackListenDTO toTrackListenDTO(TrackListenEntity tracklistenEntity);
    List<TrackListenDTO> tracklistenEntityListToTrackListenDTOList(List<TrackListenEntity> list);
    TrackListenEntity fromTrackListenDTO(TrackListenDTO tracklistenDTO);
}

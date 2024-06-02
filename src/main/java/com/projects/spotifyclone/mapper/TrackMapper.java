package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.TrackDTO;
import com.projects.spotifyclone.dto.TrackWithPivotDTO;
import com.projects.spotifyclone.entity.TrackEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TrackMapper {
    TrackDTO toTrackDTO(TrackEntity trackEntity);
    List<TrackDTO> trackEntityListToTrackDTOList(List<TrackEntity> list);
    List<TrackEntity> trackDTOListToTrackEntityList(List<TrackDTO> list);
    TrackEntity fromTrackDTO(TrackDTO trackDTO);
    TrackWithPivotDTO toTrackWithPivotDTO(TrackEntity trackEntity);
    List<TrackWithPivotDTO> trackEntityListToTrackWithPivotDTOList(List<TrackEntity> list);
    List<TrackEntity> trackWithPivotDTOListToTrackEntityList(List<TrackWithPivotDTO> list);
    TrackEntity fromTrackWithPivotDTO(TrackWithPivotDTO trackDTO);
}

package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.AlbumDTO;
import com.projects.spotifyclone.dto.AlbumWithPivotDTO;
import com.projects.spotifyclone.entity.AlbumEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface AlbumMapper {
    AlbumDTO toAlbumDTO(AlbumEntity albumEntity);
    AlbumWithPivotDTO toAlbumWithPivotDTO(AlbumEntity albumEntity);
    List<AlbumDTO> albumEntityListToAlbumDTOList(List<AlbumEntity> list);
    List<AlbumWithPivotDTO> albumEntityListToAlbumWithPivotDTOList(List<AlbumEntity> list);
    List<AlbumEntity> albumDTOListToAlbumEntityList(List<AlbumDTO> list);
    AlbumEntity fromAlbumDTO(AlbumDTO albumDTO);
    List<AlbumEntity> albumWithPivotDTOListToAlbumEntityList(List<AlbumWithPivotDTO> list);
    AlbumEntity fromAlbumWithPivotDTO(AlbumWithPivotDTO albumDTO);
}

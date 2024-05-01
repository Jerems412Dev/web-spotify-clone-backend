package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.AlbumDTO;
import com.projects.spotifyclone.entity.AlbumEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface AlbumMapper {
    AlbumDTO toAlbumDTO(AlbumEntity albumEntity);
    List<AlbumDTO> albumEntityListToAlbumDTOList(List<AlbumEntity> list);
    AlbumEntity fromAlbumDTO(AlbumDTO albumDTO);
}

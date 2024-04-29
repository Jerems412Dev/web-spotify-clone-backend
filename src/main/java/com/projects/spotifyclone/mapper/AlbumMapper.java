package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.AlbumDTO;
import com.projects.spotifyclone.entity.AlbumEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AlbumMapper {
    AlbumDTO toAlbumDTO(AlbumEntity albumEntity);
    AlbumEntity fromAlbumDTO(AlbumDTO albumDTO);
}

package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.UserPlaylistDTO;
import com.projects.spotifyclone.entity.UserPlaylistEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserPlaylistMapper {
    UserPlaylistDTO toUserPlaylistDTO(UserPlaylistEntity userPlaylistEntity);
    UserPlaylistEntity fromUserPlaylistDTO(UserPlaylistDTO userPlaylistDTO);
}

package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.UserPlaylistDTO;
import com.projects.spotifyclone.entity.UserPlaylistEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface UserPlaylistMapper {
    UserPlaylistDTO toUserPlaylistDTO(UserPlaylistEntity userPlaylistEntity);
    List<UserPlaylistDTO> userPlaylistEntityListToUserPlaylistDTOList(List<UserPlaylistEntity> list);
    UserPlaylistEntity fromUserPlaylistDTO(UserPlaylistDTO userPlaylistDTO);
}

package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.UserDTO;
import com.projects.spotifyclone.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO toUserDTO(UserEntity userEntity);
    UserEntity fromUserDTO(UserDTO userDTO);
}

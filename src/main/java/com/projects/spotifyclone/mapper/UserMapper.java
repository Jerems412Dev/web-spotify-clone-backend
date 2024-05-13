package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.RegisterDTO;
import com.projects.spotifyclone.dto.UserDTO;
import com.projects.spotifyclone.entity.UserEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    UserDTO toUserDTO(UserEntity userEntity);
    List<UserDTO> userEntityListToUserDTOList(List<UserEntity> list);
    UserEntity fromUserDTO(UserDTO userDTO);
    UserEntity fromRegisterDTO(RegisterDTO register);
}

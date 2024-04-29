package com.projects.spotifyclone.dto;

import com.projects.spotifyclone.entity.RoleEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long idUser;
    private String profileName;
    private String username;
    private String gender;
    private String birth;
    private String country;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private RoleEntity role;
}

package com.projects.spotifyclone.dto;

import com.projects.spotifyclone.entity.RoleEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private long idUser;
    private String username;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private RoleEntity role;
}

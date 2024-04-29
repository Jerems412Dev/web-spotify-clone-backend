package com.projects.spotifyclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPlaylistDTO {
    private long idUserPlaylist;
    private String namePlaylist;
    private String description;
    private String profilePicture;
}

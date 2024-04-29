package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "userplaylists")
public class UserPlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUserPlaylist;
    private String namePlaylist;
    private String description;
    private String profilePicture;
}

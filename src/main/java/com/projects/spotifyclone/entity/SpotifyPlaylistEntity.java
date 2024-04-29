package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "spotifyplaylists")
public class SpotifyPlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSpotifyPlaylist;
    private String namePlaylist;
    private String description;
    private String profilePicture;
}

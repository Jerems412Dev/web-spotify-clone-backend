package com.projects.spotifyclone.dto;

import com.projects.spotifyclone.entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    //All relationships

    //relation for user playlists
    @OneToMany(mappedBy = "user")
    private List<UserPlaylistDTO> playlists;

    //relation for fav user track
    @ManyToMany
    private List<TrackDTO> tracks;

    //relation for follow user artist
    @ManyToMany
    private List<ArtistDTO> artists;

    //relation for fav user album
    @ManyToMany
    private List<AlbumDTO> albums;

    //relation for fav user album
    @ManyToMany
    private List<SpotifyPlaylistDTO> spotifyplaylists;
}

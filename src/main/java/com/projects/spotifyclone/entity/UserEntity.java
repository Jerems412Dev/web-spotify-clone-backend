package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String profileName;
    @Column(unique = true)
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
    private List<UserPlaylistEntity> playlists;

    //relation for fav user track
    @ManyToMany
    private List<TrackEntity> tracks;

    //relation for follow user artist
    @ManyToMany
    private List<ArtistEntity> artists;

    //relation for fav user album
    @ManyToMany
    private List<AlbumEntity> albums;

    //relation for fav user album
    @ManyToMany
    private List<SpotifyPlaylistEntity> spotifyplaylists;

    @OneToMany(mappedBy = "user")
    private Set<TrackListenEntity> trackListen;
}

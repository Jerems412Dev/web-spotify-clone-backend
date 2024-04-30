package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "fav_track",
            joinColumns = @JoinColumn(name = "track_id", referencedColumnName = "idTrack"),
            inverseJoinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "idUser"))
    private List<TrackEntity> tracks;

    //relation for follow user artist
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "follow_artist",
            joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "idArtist"),
            inverseJoinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "idUser"))
    private List<ArtistEntity> artists;

    //relation for fav user album
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "fav_album",
            joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "idAlbum"),
            inverseJoinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "idUser"))
    private List<AlbumEntity> albums;

    //relation for fav user album
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "fav_playlist",
            joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "idSpotifyPlaylist"),
            inverseJoinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "idUser"))
    private List<SpotifyPlaylistEntity> spotifyplaylists;
}

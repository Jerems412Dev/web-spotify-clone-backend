package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tracks")
public class TrackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTrack;
    private String titleTrack;
    private String duration;
    private String profilePicture;

    //All relationships

    @ManyToOne
    @JoinColumn(name="album_id")
    private AlbumEntity album;

    @ManyToMany(mappedBy = "tracks")
    private List<UserEntity> users;

    //relation for artists
    @ManyToMany
    private List<ArtistEntity> artists;

    //relation for categories
    @ManyToMany
    private List<CategoryEntity> categories;

    //relation for spotifyplaylist
    @ManyToMany
    private List<SpotifyPlaylistEntity> spotifyplaylists;

    //relation for userplaylist
    @ManyToMany
    private List<UserPlaylistEntity> userplaylists;

    @OneToMany(mappedBy = "track")
    private Set<TrackListenEntity> trackListen;
}

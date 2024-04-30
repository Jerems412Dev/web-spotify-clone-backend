package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "track_artist",
            joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "idArtist"),
            inverseJoinColumns = @JoinColumn(name = "track_id",
                    referencedColumnName = "idTrack"))
    private List<ArtistEntity> artists;

    //relation for categories
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "track_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "idCategory"),
            inverseJoinColumns = @JoinColumn(name = "track_id",
                    referencedColumnName = "idTrack"))
    private List<CategoryEntity> categories;

    //relation for spotifyplaylist
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "track_spotifyplaylist",
            joinColumns = @JoinColumn(name = "spotifyplaylist_id", referencedColumnName = "idSpotifyPlaylist"),
            inverseJoinColumns = @JoinColumn(name = "track_id",
                    referencedColumnName = "idTrack"))
    private List<SpotifyPlaylistEntity> spotifyplaylists;

    //relation for userplaylist
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "track_userplaylist",
            joinColumns = @JoinColumn(name = "userplaylist_id", referencedColumnName = "idUserPlaylist"),
            inverseJoinColumns = @JoinColumn(name = "track_id",
                    referencedColumnName = "idTrack"))
    private List<UserPlaylistEntity> userplaylists;
}

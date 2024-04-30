package com.projects.spotifyclone.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackDTO {
    private long idTrack;
    private String titleTrack;
    private String duration;
    private String profilePicture;

    //All relationships

    @ManyToOne
    @JoinColumn(name="album_id")
    private AlbumDTO album;

    @ManyToMany(mappedBy = "tracks")
    private List<UserDTO> users;

    //relation for artists
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "track_artist",
            joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "idArtist"),
            inverseJoinColumns = @JoinColumn(name = "track_id",
                    referencedColumnName = "idTrack"))
    private List<ArtistDTO> artists;

    //relation for categories
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "track_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "idCategory"),
            inverseJoinColumns = @JoinColumn(name = "track_id",
                    referencedColumnName = "idTrack"))
    private List<CategoryDTO> categories;

    //relation for spotifyplaylist
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "track_spotifyplaylist",
            joinColumns = @JoinColumn(name = "spotifyplaylist_id", referencedColumnName = "idSpotifyPlaylist"),
            inverseJoinColumns = @JoinColumn(name = "track_id",
                    referencedColumnName = "idTrack"))
    private List<SpotifyPlaylistDTO> spotifyplaylists;

    //relation for userplaylist
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "track_userplaylist",
            joinColumns = @JoinColumn(name = "userplaylist_id", referencedColumnName = "idUserPlaylist"),
            inverseJoinColumns = @JoinColumn(name = "track_id",
                    referencedColumnName = "idTrack"))
    private List<UserPlaylistDTO> userplaylists;
}

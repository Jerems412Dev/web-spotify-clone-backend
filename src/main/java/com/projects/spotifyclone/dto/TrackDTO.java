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
    @ManyToMany
    private List<ArtistDTO> artists;

    //relation for categories
    @ManyToMany
    private List<CategoryDTO> categories;

    //relation for spotifyplaylist
    @ManyToMany
    private List<SpotifyPlaylistDTO> spotifyplaylists;

    //relation for userplaylist
    @ManyToMany
    private List<UserPlaylistDTO> userplaylists;
}

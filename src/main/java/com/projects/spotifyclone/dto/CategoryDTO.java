package com.projects.spotifyclone.dto;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private long idCategory;
    private String nameCategory;
    private String color;

    //All relationships

    @ManyToMany(mappedBy = "categories")
    private List<TrackDTO> tracks;

    @ManyToMany(mappedBy = "categories")
    private List<ArtistDTO> artists;

    @ManyToMany(mappedBy = "categories")
    private List<AlbumDTO> albums;

    @ManyToMany(mappedBy = "categories")
    private List<SpotifyPlaylistDTO> spotifyplaylists;
}

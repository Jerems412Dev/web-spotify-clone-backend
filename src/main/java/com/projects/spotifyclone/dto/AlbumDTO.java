package com.projects.spotifyclone.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
    private long idAlbum;
    private String titleAlbum;
    private String profilePicture;
    private String releaseDate;

    //All relationships

    @ManyToOne
    @JoinColumn(name="artist_id")
    private ArtistDTO artist;

    @OneToMany(mappedBy = "album")
    private List<TrackDTO> tracks;

    @ManyToMany(mappedBy = "albums")
    private List<UserDTO> users;

    //relation for categories
    @ManyToMany
    private List<CategoryDTO> categories;
}

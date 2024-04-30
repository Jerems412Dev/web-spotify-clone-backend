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

    //All relationships

    @ManyToOne
    @JoinColumn(name="artist_id")
    private ArtistDTO artist;

    @OneToMany(mappedBy = "album")
    private List<TrackDTO> tracks;

    @ManyToMany(mappedBy = "albums")
    private List<UserDTO> users;

    //relation for categories
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "album_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "idCategory"),
            inverseJoinColumns = @JoinColumn(name = "album_id",
                    referencedColumnName = "idAlbum"))
    private List<CategoryDTO> categories;
}
